package com.xinyuan.relation.mapper;

import com.xinyuan.base.mapper.BaseJpaRepository;
import com.xinyuan.relation.entity.Relation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liang

 */
@Repository
public interface RelationRepository extends BaseJpaRepository<Relation,Long> {

    Relation findBySrcUserAndActionTypeAndTargetIdAndTargetTypeAndDeleted(Long srcUser, String actionType, Long targetId, String targetType, int deleted);

    List<Relation> findByTargetIdAndDeleted(Long targetId, int deleted);

    List<Relation> findByTargetIdAndTargetTypeAndDeleted(Long targetId, String targetType, int deleted);

    List<Relation> findBySrcUserAndActionTypeAndTargetTypeAndDeleted(Long srcUser, String actionType, String targetType, int deleted);

    List<Relation> findBySrcUserAndActionTypeOrActionTypeAndTargetTypeOrTargetTypeAndDeleted(Long srcUser, String actionType1, String actionType2, String targetType1, String targetType2, int deleted);

    List<Relation> findBySrcUserAndActionTypeInAndTargetTypeInAndDeletedOrderByIdDesc(Long srcUser, List<String> actionType, List<String> targetType, int deleted);
}
