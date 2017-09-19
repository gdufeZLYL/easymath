package com.gdufe.easymath.service.impl;

import com.gdufe.easymath.bean.ResponseResult;
import com.gdufe.easymath.dao.ScoreInfoDao;
import com.gdufe.easymath.entity.ScoreInfo;
import com.gdufe.easymath.service.ScoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service("scoreInfoService")
public class ScoreInfoServiceImpl implements ScoreInfoService {

    @Autowired
    ScoreInfoDao scoreInfoDao;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseResult<ScoreInfo> saveScoreInfo(ScoreInfo targetScoreInfo) throws Exception{
        ResponseResult<ScoreInfo> resultMsg = new ResponseResult<ScoreInfo>();

        if(targetScoreInfo.getType() == 101) {
            //101类测试成绩, 直接保存
            targetScoreInfo.setFinish_time(new Timestamp(new Date().getTime()));
            ScoreInfo scoreInfo = scoreInfoDao.save(targetScoreInfo);
            resultMsg.setCode(0);
            resultMsg.setMsg("保存成功");
            resultMsg.setData(scoreInfo);
        } else if(targetScoreInfo.getType() == 202) {
            //202类测试成绩
            long time = new Date().getTime() - 86400000;
            ScoreInfo scoreInfo = scoreInfoDao.findScoreOneDay(targetScoreInfo.getUid(),
                    targetScoreInfo.getType(), targetScoreInfo.getQue_type(), new Timestamp(time));
            if(scoreInfo == null) {
                //不存在，直接保存
                targetScoreInfo.setFinish_time(new Timestamp(new Date().getTime()));
                scoreInfo= scoreInfoDao.save(targetScoreInfo);
                resultMsg.setCode(0);
                resultMsg.setMsg("保存成功");
                resultMsg.setData(scoreInfo);
            } else {
                if(targetScoreInfo.getScore_right() >= scoreInfo.getScore_right()) {
                    //取最高成绩覆盖
                    scoreInfo.setScore_right(targetScoreInfo.getScore_right());
                    scoreInfo.setScore_wrong(targetScoreInfo.getScore_wrong());
                    scoreInfo.setFinish_time(new Timestamp(new Date().getTime()));
                    scoreInfo= scoreInfoDao.save(scoreInfo);
                    resultMsg.setCode(0);
                    resultMsg.setMsg("保存成功");
                    resultMsg.setData(scoreInfo);
                } else {
                    resultMsg.setCode(1);
                    resultMsg.setMsg("成绩已经存在了");
                    resultMsg.setData(scoreInfo);
                }
            }
        }
        return resultMsg;
    }

}
