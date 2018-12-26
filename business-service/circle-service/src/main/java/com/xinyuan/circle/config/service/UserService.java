package com.xinyuan.circle.config.service;

import com.xinyuan.base.common.service.ParamCondition;
import com.xinyuan.base.common.service.SelectParam;
import com.xinyuan.circle.entity.mysql.User;
import com.xinyuan.circle.mapper.mysql.UserRepository;
import com.xinyuan.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liang
 */
@Service
public class UserService extends BaseService<UserRepository, User, Long> {

    @Autowired
    private UserRepository userRepository;


    /**
     * 通过userid查询user
     *
     * @param userId
     * @return
     */
    public User findByUserIdAndDeleted(Long userId) {
        return userRepository.findByUserIdAndDeleted(userId, 0);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * 通过name查询user
     *
     * @param name
     * @return
     */
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    /**
     * 通过id查询user
     *
     * @param id
     * @return
     */
    public User findById(Long id) {
        return userRepository.findByIdAndDeleted(id, 0);
    }

    /**
     * 根据token查询用户信息
     *
     * @return
     */
//    public User findUser() {
//        SecurityContext context = SecurityContextHolder.getContext();
//        Authentication authentication = context.getAuthentication();
//
//        //判断是否匿名登录
//        if (authentication.getPrincipal().equals("anonymousUser")) {
//            return null;
//        }
//
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        User user = findByUsername(userDetails.getUsername());
//        return user;
//    }


    /**
     * 通过真实姓名查询用户信息
     *
     * @param name
     * @return
     */
    public List<User> findByName(String name) {
        List<SelectParam> selectParams = new ArrayList<>();
        selectParams.add(new SelectParam("realName", name, ParamCondition.LIKE));
        return findByCondition(selectParams);
    }

    /**
     * 查所有
     *
     * @return
     */
    public List<User> findAlls() {
        return userRepository.findAll();
    }


    /**
     * 更新异常处理
     *
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(User user) {
        User username = userRepository.findByUsername(user.getUsername());
        if (username != null) {
            if (!user.getId().equals(username.getId())) {
//                throw SystemException.USER_NAME_IS_REPEAT;
            }
        }
        update(user);
    }
}
