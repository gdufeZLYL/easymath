package com.gdufe.easymath.dao;

import com.gdufe.easymath.entity.ScoreInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface ScoreInfoDao extends JpaRepository<ScoreInfo, Integer> {

    /**
     * 202类成绩24小时内查询成绩
     * @param uid
     * @param type
     * @param que_type
     * @return
     */
    @Query("select s from ScoreInfo s where s.uid = :uid and s.type = :type and s.que_type = :que_type and s.finish_time >= :time")
    ScoreInfo findScoreOneDay(@Param("uid") int uid, @Param("type") int type, @Param("que_type") int que_type, @Param("time") Timestamp time);

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
