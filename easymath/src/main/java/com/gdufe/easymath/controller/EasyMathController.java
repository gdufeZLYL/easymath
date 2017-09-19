package com.gdufe.easymath.controller;

import com.gdufe.easymath.bean.ResponseResult;
import com.gdufe.easymath.bean.UserJoinInfo;
import com.gdufe.easymath.entity.ClassInfo;
import com.gdufe.easymath.entity.ScoreInfo;
import com.gdufe.easymath.entity.UserInfo;
import com.gdufe.easymath.service.ClassInfoService;
import com.gdufe.easymath.service.ScoreInfoService;
import com.gdufe.easymath.service.UserInfoService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/easymath")
public class EasyMathController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ClassInfoService classInfoService;
    @Autowired
    private ScoreInfoService scoreInfoService;

    @RequestMapping("/register")
    @ResponseBody
    public ResponseResult<UserInfo> register(@RequestBody UserInfo userRegisterInfo){
        ResponseResult<UserInfo> resultMsg = null;
        try {
            resultMsg = userInfoService.registerUserInfo(userRegisterInfo);
        } catch (Exception e) {
            resultMsg = new ResponseResult<UserInfo>();
            resultMsg.setCode(1);
            resultMsg.setMsg(e.getMessage());
            resultMsg.setData(null);
        }
        return resultMsg;
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResponseResult<UserInfo> login(@RequestBody UserInfo userLoginInfo){
        ResponseResult<UserInfo> resultMsg = null;
        try {
            resultMsg = userInfoService.loginUserInfo(userLoginInfo);
        } catch (Exception e) {
            resultMsg = new ResponseResult<UserInfo>();
            resultMsg.setCode(1);
            resultMsg.setMsg(e.getMessage());
            resultMsg.setData(null);
        }
        return resultMsg;
    }

    @RequestMapping("/teacherList")
    @ResponseBody
    public ResponseResult<List<UserInfo>> teacherList(@RequestBody UserInfo teacherInfo) {
        ResponseResult<List<UserInfo>> resultMsg = null;
        try {
            resultMsg = userInfoService.listTeacher(teacherInfo);
        } catch (Exception e) {
            resultMsg = new ResponseResult<List<UserInfo>>();
            resultMsg.setCode(1);
            resultMsg.setMsg(e.getMessage());
            resultMsg.setData(null);
        }
        return resultMsg;
    }

    @RequestMapping("/createClass")
    @ResponseBody
    public ResponseResult<ClassInfo> createClass(@RequestBody ClassInfo classCreateInfo) {
        ResponseResult<ClassInfo> resultMsg = null;
        try {
            resultMsg = classInfoService.createClassInfo(classCreateInfo);
        } catch (Exception e) {
            resultMsg = new ResponseResult<ClassInfo>();
            resultMsg.setCode(1);
            resultMsg.setMsg(e.getMessage());
            resultMsg.setData(null);
        }
        return resultMsg;
    }

    @RequestMapping("/selectClass")
    @ResponseBody
    public ResponseResult<List<ClassInfo>> selectClass(@RequestBody ClassInfo classSelectInfo) {
        ResponseResult<List<ClassInfo>> resultMsg = null;
        try {
            resultMsg = classInfoService.selectClassInfo(classSelectInfo.getUid());
        } catch (Exception e) {
            resultMsg = new ResponseResult<List<ClassInfo>>();
            resultMsg.setCode(1);
            resultMsg.setMsg(e.getMessage());
            resultMsg.setData(null);
        }
        return resultMsg;
    }

    @RequestMapping("/joinClass")
    @ResponseBody
    public ResponseResult<ClassInfo> joinClass(@RequestBody UserJoinInfo userJoinInfo) {
        ResponseResult<ClassInfo> resultMsg = null;
        try {
            resultMsg = classInfoService.joinClassInfo(userJoinInfo);
        } catch (Exception e) {
            resultMsg = new ResponseResult<ClassInfo>();
            resultMsg.setCode(1);
            resultMsg.setMsg(e.getMessage());
            resultMsg.setData(null);
        }
        return resultMsg;
    }

    @RequestMapping("/saveScore")
    @ResponseBody
    public ResponseResult<ScoreInfo> saveScore(@RequestBody ScoreInfo targetScoreInfo) {
        ResponseResult<ScoreInfo> resultMsg = null;
        try {
            resultMsg = scoreInfoService.saveScoreInfo(targetScoreInfo);
        } catch (Exception e) {
            resultMsg = new ResponseResult<ScoreInfo>();
            resultMsg.setCode(1);
            resultMsg.setMsg(e.getMessage());
            resultMsg.setData(null);
        }
        return resultMsg;
    }

}
