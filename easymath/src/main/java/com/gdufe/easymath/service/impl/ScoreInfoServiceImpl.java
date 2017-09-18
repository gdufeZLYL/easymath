package com.gdufe.easymath.service.impl;

import com.gdufe.easymath.bean.ResponseResult;
import com.gdufe.easymath.dao.ScoreInfoDao;
import com.gdufe.easymath.entity.ScoreInfo;
import com.gdufe.easymath.service.ScoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class ScoreInfoServiceImpl implements ScoreInfoService {

    @Autowired
    ScoreInfoDao scoreInfoDao;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseResult<ScoreInfo> saveScoreInfo(ScoreInfo targetScoreInfo) {
        ResponseResult<ScoreInfo> resultMsg = new ResponseResult<ScoreInfo>();
        //101类测试成绩保存
        if(targetScoreInfo.getType() == 101) {
            ScoreInfo tempScoreInfo = scoreInfoDao.findByUidAndTypeAndLevel(
                    targetScoreInfo.getUid(), targetScoreInfo.getType(),
                    targetScoreInfo.getLevel());
            if(tempScoreInfo != null) {

            }
        } else if(targetScoreInfo.getType() == 202) {

        }
        return resultMsg;
    }

}
