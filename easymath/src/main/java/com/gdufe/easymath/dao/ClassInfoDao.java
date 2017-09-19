package com.gdufe.easymath.dao;

import com.gdufe.easymath.entity.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassInfoDao extends JpaRepository<ClassInfo, Integer> {

    /**
     * 查询uid所创建的班级信息
     * @param uid
     * @return
     */
    List<ClassInfo> findByUid(int uid);

    /**
     * 根据uid和class_name查询对应的班级信息
     * @param uid
     * @param class_name
     * @return
     */
    @Query("select c from ClassInfo c where c.uid = :uid and c.class_name = :class_name")
    ClassInfo findByUidAndClass_name(@Param("uid") int uid, @Param("class_name") String class_name);

    /**
     * 查询guid的班级信息
     * @param guid
     * @return
     */
    ClassInfo findByGuid(int guid);
}
