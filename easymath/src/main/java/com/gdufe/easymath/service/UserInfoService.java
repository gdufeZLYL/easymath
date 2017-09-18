package com.gdufe.easymath.service;

import com.gdufe.easymath.bean.ResponseResult;
import com.gdufe.easymath.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    /**
     * 注册用户
     * @param userRegisterInfo
     * @return
     * @throws Exception
     */
    ResponseResult<UserInfo> registerUserInfo(
            UserInfo userRegisterInfo) throws Exception;

    /**
     * 用户登录
     * @param userLoginInfo
     * @return
     * @throws Exception
     */
    ResponseResult<UserInfo> loginUserInfo(
            UserInfo userLoginInfo) throws Exception;

    /**
     * 列出所有教师信息
     * @param teacherInfo
     * @return
     * @throws Exception
     */
    ResponseResult<List<UserInfo>> listTeacher(
            UserInfo teacherInfo) throws Exception;
}
