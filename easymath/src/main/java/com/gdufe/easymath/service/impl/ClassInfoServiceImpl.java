package com.gdufe.easymath.service.impl;

import com.gdufe.easymath.bean.ResponseResult;
import com.gdufe.easymath.bean.UserJoinInfo;
import com.gdufe.easymath.dao.ClassInfoDao;
import com.gdufe.easymath.entity.ClassInfo;
import com.gdufe.easymath.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service("classInfoService")
public class ClassInfoServiceImpl implements ClassInfoService {

    @Autowired
    ClassInfoDao classInfoDao;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseResult<ClassInfo> createClassInfo(ClassInfo classCreateInfo) throws Exception {
        ResponseResult<ClassInfo> resultMsg = new ResponseResult<ClassInfo>();
        ClassInfo classInfo = classInfoDao.findByUidAndClass_name(
                classCreateInfo.getUid(), classCreateInfo.getClass_name());
        if(classInfo == null) {
            classCreateInfo.setStudent_set("");
            classCreateInfo.setCreate_time(new Timestamp(new Date().getTime()));
            classInfo = classInfoDao.save(classCreateInfo);
            resultMsg.setCode(0);
            resultMsg.setMsg("创建成功!");
            resultMsg.setData(classInfo);
        } else {
            resultMsg.setCode(1);
            resultMsg.setMsg("班级已经存在");
            resultMsg.setData(classInfo);
        }
        return resultMsg;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseResult<ClassInfo> joinClassInfo(UserJoinInfo userJoinInfo) throws Exception {
        ResponseResult<ClassInfo> resultMsg = new ResponseResult<ClassInfo>();
        ClassInfo classInfo = classInfoDao.findByGuid(userJoinInfo.getGuid());
        int flag = 0;
        if(!classInfo.getStudent_set().equals("")) {
            String[] stus = classInfo.getStudent_set().split(";");
            for(String stu : stus) {
                String[] stuInfo = stu.split(",");
                //该学生已经存在
                if(userJoinInfo.getUid() == Integer.valueOf(stuInfo[0])) {
                    flag = 1;
                    break;
                }
                //该学号已经存在
                if(userJoinInfo.getSno() == Integer.valueOf(stuInfo[1])) {
                    flag = 2;
                    break;
                }
            }
            if(flag == 0) {
                classInfo.setStudent_set(classInfo.getStudent_set()+";"+userJoinInfo.getUid()+","+
                        userJoinInfo.getSno()+","+userJoinInfo.getNickname());
                classInfo = classInfoDao.save(classInfo);
                resultMsg.setCode(0);
                resultMsg.setMsg("加入班级成功");
                resultMsg.setData(classInfo);
            } else {
                resultMsg.setCode(1);
                if(flag == 1)resultMsg.setMsg("该班级已经存在该学生了!");
                else resultMsg.setMsg("该班级已经存在该学号了!");
                resultMsg.setData(null);
            }
        } else {
            classInfo.setStudent_set(userJoinInfo.getUid()+","+
                    userJoinInfo.getSno()+","+userJoinInfo.getNickname());
            classInfo = classInfoDao.save(classInfo);
            resultMsg.setCode(0);
            resultMsg.setMsg("加入班级成功");
            resultMsg.setData(classInfo);
        }
        return resultMsg;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseResult<List<ClassInfo>> selectClassInfo(int uid) throws Exception {
        ResponseResult<List<ClassInfo>> resultMsg = new ResponseResult<List<ClassInfo>>();
        List<ClassInfo> classList = classInfoDao.findByUid(uid);
        if(classList != null) {
            resultMsg.setCode(1);
            resultMsg.setMsg("该教师没有班级呢o(╥﹏╥)o");
            resultMsg.setData(null);
        } else {
            resultMsg.setCode(0);
            resultMsg.setMsg("查询成功");
            resultMsg.setData(classList);
        }
        return resultMsg;
    }
}
