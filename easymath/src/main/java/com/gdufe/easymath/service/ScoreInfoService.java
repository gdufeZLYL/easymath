package com.gdufe.easymath.service;

import com.gdufe.easymath.bean.ResponseResult;
import com.gdufe.easymath.entity.ScoreInfo;

public interface ScoreInfoService {

    /**
     * 保存成绩信息
     * @param tScoreInfo
     * @return
     */
    ResponseResult<ScoreInfo> saveScoreInfo(ScoreInfo tScoreInfo);
}
