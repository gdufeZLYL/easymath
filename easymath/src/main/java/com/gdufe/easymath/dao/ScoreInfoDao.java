package com.gdufe.easymath.dao;

import com.gdufe.easymath.entity.ScoreInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreInfoDao extends JpaRepository<ScoreInfo, Integer> {

    /**
     * 查询个人等级考试指定类型的成绩
     * @param uid
     * @param type
     * @param level
     * @return
     */
    @Query("select s from ScoreInfo s where s.uid = :uid and s.type = :type and s.level = :level")
    ScoreInfo findByUidAndTypeAndLevel(@Param("uid") int uid,
                                       @Param("type") int type, @Param("level") int level);

    /**
     * 查询个人等级考试(等级升序)
     * @param uid
     * @param type
     * @return
     */
    @Query("select s from ScoreInfo s where s.uid = :uid and s.type = :type order by s.type asc")
    List<ScoreInfo> listFtScore(@Param("uid") int uid,
                                @Param("type") int type);

}
