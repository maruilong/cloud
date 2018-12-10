package com.xinyuan.service;

import com.thoughtworks.xstream.core.BaseException;
import com.xinyuan.common.service.Order;
import com.xinyuan.common.service.PageBean;
import com.xinyuan.common.service.ParamCondition;
import com.xinyuan.common.service.SelectParam;
import com.xinyuan.common.util.EntityUtils;
import com.xinyuan.common.util.ReflectionUtils;
import com.xinyuan.common.web.Conditions;
import com.xinyuan.common.web.PageBody;
import com.xinyuan.mapper.BaseJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 基础Service层
 *
 * @author
 * @since 2018-03-06
 */
@Slf4j
public abstract class BaseService<J extends BaseJpaRepository<T, ID>, T, ID extends Serializable> {

    @Autowired
    protected J bizRepository;

    @Autowired
    protected EntityManager entityManager;

    /**
     * 业务新增方法(初始化和校验)
     *
     * @author 2018-03-06 14:00
     */
    @Transactional(rollbackFor = Exception.class)
    public T save(T entity) throws BaseException {
        String fieldName = "id";

        T jpaResult = bizRepository.saveAndFlush(entity);
        //清空一级缓存
        entityManager.clear();

        T result = null;

        if (ReflectionUtils.hasField(jpaResult, fieldName)) {

            result = bizRepository.findOne((ID) ReflectionUtils.getFieldValue(jpaResult, fieldName));
        }
        return result;
    }

    /**
     * 业务删除方法(初始化和校验)
     *
     * @author 2018-03-06 14:01
     */
    public void remove(ID id) throws BaseException {
        T entity = bizRepository.findOne(id);
        if (entity != null) {
            if (ReflectionUtils.hasField(entity, "deleted")) {
                ReflectionUtils.invokeSetter(entity, "deleted", 1);
            }
            bizRepository.save(entity);
        }
    }


    /**
     * 业务更新方法(初始化和校验)
     *
     * @author 2018-03-06 14:59
     */
    @Transactional(rollbackFor = Exception.class)
    public void update(T entity) throws BaseException {
        T result = null;
        if (ReflectionUtils.hasField(entity, "id")) {
            ID id = (ID) ReflectionUtils.getFieldValue(entity, "id");
            result = bizRepository.findOne(id);
        }
        EntityUtils.copyPropertiesIgnoreNull(entity, result);
        bizRepository.saveAndFlush(result);
    }

    /**
     * 查询单个方法
     *
     * @author 2018-03-06 14:59
     */
    public T get(ID id) throws BaseException {
        return bizRepository.findOne(id);
    }

    /**
     * 业务条件查询方法(带分页参数)
     *
     * @author 2018-03-08 9:17
     */
    public Page findByCondition(Integer pageNum, Integer pageSize, Sort sort, List<SelectParam> selectParams) {
        int page = 1;
        int limit = 10;
        if (pageNum != null) {
            page = pageNum;
        }
        if (pageSize != null) {
            limit = pageSize;
        }

        Specification querySpecifi = getSpecification(selectParams, false);
        PageBean pageBean = new PageBean(page, limit, sort);
        return bizRepository.findAll(querySpecifi, pageBean);
    }

    /**
     * 业务条件查询方法(带分页参数)
     *
     * @author 2018-03-08 9:17
     */
    public Page findByCondition(Integer pageNum, Integer pageSize, List<SelectParam> selectParams) {
        int page = 1;
        int limit = 10;
        if (pageNum != null) {
            page = pageNum;
        }
        if (pageSize != null) {
            limit = pageSize;
        }

        Specification querySpecifi = getSpecification(selectParams, false);
        PageBean pageBean = new PageBean(page, limit, null);
        return bizRepository.findAll(querySpecifi, pageBean);
    }

    /**
     * 不带分页条件查询
     *
     * @author 2018-03-13 16:03
     */
    public List<T> findByCondition(List<SelectParam> selectParams) {
        return bizRepository.findAll(getSpecification(selectParams, false));
    }

    /**
     * 不带分页条件查询
     *
     * @author 2018-03-13 16:03
     */
    public T getByCondition(List<SelectParam> selectParams) {
        List<T> list = bizRepository.findAll(getSpecification(selectParams, false));

        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.get(0);
    }

    /**
     * 非业务表的条件查询(不带deleted字段的条件查询)
     *
     * @author 2018-03-21 18:59
     */
    public List<T> findByConditionAndDelete(List<SelectParam> selectParams) {
        return bizRepository.findAll(getSpecification(selectParams, true));
    }

    /**
     * 封装Specification对象
     *
     * @author 2018-03-13 16:04
     */
    private Specification getSpecification(List<SelectParam> selectParams, boolean isDelete) {
        return (Specification<T>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (selectParams != null) {
                for (SelectParam s : selectParams) {
                    switch (s.getCondition()) {
                        case EQUAL:
                            predicates.add(criteriaBuilder.equal(root.get(s.getParamKey()),
                                    s.getParamValue()));
                            break;
                        case GREATERTHAN:
                            predicates.add(criteriaBuilder.greaterThan(root.get(s.getParamKey()),
                                    (Comparable) s.getParamValue()));
                            break;
                        case LESSTHAN:
                            predicates.add(criteriaBuilder.lessThan(root.get(s.getParamKey()),
                                    (Comparable) s.getParamValue()));
                            break;
                        case LIKE:
                            predicates.add(criteriaBuilder.like(root.get(s.getParamKey()),
                                    "%" + s.getParamValue() + "%"));
                            break;
                        case GREATERTHANEQUAL:
                            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(s.getParamKey()),
                                    (Comparable) s.getParamValue()));
                            break;
                        case LESSTHANEQUAL:
                            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(s.getParamKey()),
                                    (Comparable) s.getParamValue()));
                            break;
                        case NOT_EQUAL:
                            predicates.add(criteriaBuilder.notEqual(root.get(s.getParamKey()),
                                    (Comparable) s.getParamValue()));
                            break;
                        case IN:
                            String key = s.getParamKey();
                            CriteriaBuilder.In<Object> in = criteriaBuilder.in(root.get(key));
                            List<Object> list = (List<Object>) s.getParamValue();
                            for (Object id : list) {
                                in.value(id);
                            }
                            predicates.add(in);
                            break;
                        default:
                            break;
                    }
                }
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    /**
     * 通用条件查询
     *
     * @param list
     * @return
     */
    public List<SelectParam> getSelectParamList(List<Conditions> list) {
        List<SelectParam> selectParamList = new ArrayList<>();
        if (list != null) {
            for (Conditions mapBean : list) {
                ParamCondition paramCondition = null;
                String condition = mapBean.getCondition();
                switch (condition) {
                    case "GREATERTHAN":
                        paramCondition = ParamCondition.GREATERTHAN;
                        break;
                    case "LESSTHAN":
                        paramCondition = ParamCondition.LESSTHAN;
                        break;
                    case "LIKE":
                        paramCondition = ParamCondition.LIKE;
                        break;
                    case "GREATERTHANEQUAL":
                        paramCondition = ParamCondition.GREATERTHANEQUAL;
                        break;
                    case "LESSTHANEQUAL":
                        paramCondition = ParamCondition.LESSTHANEQUAL;
                        break;
                    case "IN":
                        paramCondition = ParamCondition.IN;
                        break;
                    case "NOT_EQUAL":
                        paramCondition = ParamCondition.NOT_EQUAL;
                        break;
                    default:
                        paramCondition = ParamCondition.EQUAL;
                        break;
                }

                if (!ObjectUtils.isEmpty(mapBean.getValue())) {
                    SelectParam selectParam = new SelectParam(mapBean.getKey(), mapBean.getValue(), paramCondition);
                    selectParamList.add(selectParam);
                }

            }
        }
        return selectParamList;
    }


    public Page query(PageBody pageBody) {
        Page page;
        Sort sort = sort(pageBody.getOrder());

        if (pageBody.getConditions() != null) {
            Conditions conditions = new Conditions("deleted", "0", "EQUAL");
            pageBody.getConditions().add(conditions);
        }

        if (pageBody.getPageBean() != null) {
            page = findByCondition(pageBody.getPageBean().getPageNumber(), pageBody.getPageBean().getPageSize(), sort, getSelectParamList(pageBody.getConditions()));
        } else {
            page = findByCondition(1, Integer.MAX_VALUE, sort, getSelectParamList(pageBody.getConditions()));
        }
        return page;
    }

    public Sort sort(Order order) {
        Sort sort;
        if (order != null) {
            if (("DESC").equals(order.getDirection())) {
                sort = new Sort(Sort.Direction.DESC, order.getProperties());
            } else {
                sort = new Sort(Sort.Direction.ASC, order.getProperties());
            }
        } else {
            sort = new Sort(Sort.Direction.ASC, "id");
        }
        return sort;
    }

}
