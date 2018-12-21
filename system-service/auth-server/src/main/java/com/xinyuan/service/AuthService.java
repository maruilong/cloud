package com.xinyuan.service;

import com.xinyuan.base.service.BaseService;
import com.xinyuan.entity.Auth;
import com.xinyuan.mapper.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hwz
 */
@Service
public class AuthService extends BaseService<AuthRepository, Auth, Long> {

    @Autowired
    private AuthRepository authRepository;

    public List<Auth> findByObId(Integer id) {
        return authRepository.findByObId(id);
    }

    /***
     * 判断一个人是否拥有某个权限
     * @param tableName
     * @param actionName
     * @return
     */
//    public Boolean isAuth(String tableName, ActionName actionName) {
//        Long userId = userService.findUserId();
//
//        String code = tableName.toUpperCase() + "_" + actionName.name();
//
//        List<SelectParam> selectParams = new ArrayList<>();
//        selectParams.add(new SelectParam("obId", userId, ParamCondition.EQUAL));
//        selectParams.add(new SelectParam("functionCode", code, ParamCondition.EQUAL));
//
//        Auth auth = getByCondition(selectParams);
//
//        return auth != null;
////        return true;
//    }

}
