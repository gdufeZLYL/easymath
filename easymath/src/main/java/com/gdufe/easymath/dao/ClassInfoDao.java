package com.gdufe.easymath.dao;

import com.gdufe.easymath.entity.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassInfoDao extends JpaRepository<ClassInfo, Integer> {

    /**
     * 查询uid所创建的班级信息
     * @param uid
     * @return
     */
    List<ClassInfo> findByUid(int uid);

}
