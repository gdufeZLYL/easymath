package com.gdufe.easymath.service;

import com.gdufe.easymath.bean.ResponseResult;
import com.gdufe.easymath.entity.ClassInfo;

import java.util.List;

public interface ClassInfoService {

    /**
     * 创建班级
     * @param classCreateInfo
     * @return
     * @throws Exception
     */
    ResponseResult<ClassInfo> createClassInfo(ClassInfo classCreateInfo) throws Exception;

    /**
     * 查看用户创建的班级信息
     * @param uid
     * @return
     * @throws Exception
     */
    ResponseResult<List<ClassInfo>> selectClassInfo(int uid) throws Exception;
}
