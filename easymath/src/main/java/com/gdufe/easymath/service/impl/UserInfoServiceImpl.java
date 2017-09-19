package com.gdufe.easymath.service.impl;

import com.gdufe.easymath.bean.ResponseResult;
import com.gdufe.easymath.dao.UserInfoDao;
import com.gdufe.easymath.entity.UserInfo;
import com.gdufe.easymath.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseResult<UserInfo> registerUserInfo(
            UserInfo userRegisterInfo) throws Exception {
        ResponseResult<UserInfo> resultMsg = new ResponseResult<UserInfo>();
        UserInfo userInfo = userInfoDao.findByAccount(
                userRegisterInfo.getAccount()
        );
        if(userInfo == null) {
            userRegisterInfo.setCreate_time(new Timestamp(new Date().getTime()));
            userInfo = userInfoDao.save(userRegisterInfo);
            resultMsg.setCode(0);
            resultMsg.setMsg("注册成功!");
            resultMsg.setData(userInfo);
        } else {
            resultMsg.setCode(1);
            resultMsg.setMsg("注册失败!该账户已经存在!");
            resultMsg.setData(null);
        }
        return resultMsg;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseResult<UserInfo> loginUserInfo(UserInfo userLoginInfo) throws Exception {
        ResponseResult<UserInfo> resultMsg = new ResponseResult<UserInfo>();
        UserInfo userInfo = userInfoDao.findByActAndPwd(
                userLoginInfo.getAccount(),
                userLoginInfo.getPassword()
        );
        if(userInfo != null) {
            resultMsg.setCode(0);
            resultMsg.setMsg("登录成功");
            resultMsg.setData(userInfo);
        } else {
            resultMsg.setCode(1);
            resultMsg.setMsg("账户或密码错误");
            resultMsg.setData(null);
        }
        return resultMsg;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseResult<List<UserInfo>> listTeacher(UserInfo teacherInfo) throws Exception {
        ResponseResult<List<UserInfo>> resultMsg = new ResponseResult<List<UserInfo>>();
        List<UserInfo> teacherList = userInfoDao.findByNickname(
                teacherInfo.getNickname()
        );
        if(teacherList != null) {
            resultMsg.setCode(0);
            resultMsg.setMsg("查询成功");
            resultMsg.setData(teacherList);
        } else {
            resultMsg.setCode(1);
            resultMsg.setMsg("查询失败");
            resultMsg.setData(null);
        }
        return resultMsg;
    }
}
