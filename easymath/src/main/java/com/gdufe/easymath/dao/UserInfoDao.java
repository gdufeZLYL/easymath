package com.gdufe.easymath.dao;

import com.gdufe.easymath.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {

    /**
     * 根据用户账号查询
     * @param account
     * @return
     */
    UserInfo findByAccount(String account);

    /**
     * 根据真实姓名找到对应的老师
     * @param nickname
     * @return
     */
    List<UserInfo> findByNickname(String nickname);

    /**
     * 根据用户账户查询
     * @param account
     * @return
     */
    @Query("select u from UserInfo u where u.account = :account and u.password = :password")
    UserInfo findByActAndPwd(@Param("account") String account,
                               @Param("password") String password);
}
