package com.veidy.nba.daily.logic.daily;

import com.veidy.nba.daily.logic.OnFinishReqListener;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : NBADaily
 * @Create Date  : 2015/11/2  16:33
 */
public interface IDailyLogic {

    public void getDaily(String time,OnFinishReqListener onFinishReqListener);
}
