package com.gdufe.easymath.service.impl;

import com.gdufe.easymath.bean.ResponseResult;
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
        ResponseResult<ClassInfo> resultMsg = new ResponseResult();
        classCreateInfo.setStudent_set("");
        classCreateInfo.setCreate_time(new Timestamp(new Date().getTime()));
        ClassInfo classInfo = classInfoDao.save(classCreateInfo);
        if(classInfo != null) {
            resultMsg.setCode(0);
            resultMsg.setMsg("创建成功!");
            resultMsg.setData(classInfo);
        } else {
            resultMsg.setCode(1);
            resultMsg.setMsg("创建失败!");
            resultMsg.setData(null);
        }
        return resultMsg;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseResult<List<ClassInfo>> selectClassInfo(int uid) throws Exception {
        ResponseResult<List<ClassInfo>> resultMsg = new ResponseResult();
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
