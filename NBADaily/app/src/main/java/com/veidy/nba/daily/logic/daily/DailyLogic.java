package com.veidy.nba.daily.logic.daily;

import android.util.Log;

import com.nbadaily_api.base.IReturnCallBack;
import com.nbadaily_api.base.ProtocolType;
import com.nbadaily_api.daily.DailyReq;
import com.nbadaily_api.daily.data.DailyResult;
import com.veidy.nba.daily.logic.OnFinishReqListener;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : NBADaily
 * @Create Date  : 2015/11/2  16:32
 */
public class DailyLogic implements IDailyLogic {

    @Override
    public void getDaily(String time, final OnFinishReqListener onFinishReqListener) {
        DailyReq dailyReq = new DailyReq();
        dailyReq.doGet(new IReturnCallBack<DailyResult>() {
            @Override
            public void onReturn(ProtocolType.ResponseEvent event, DailyResult result) {
                if (ProtocolType.ResponseEvent.isFinish(event)) {
                    Log.d("DailyLogic","解析完成");
                    onFinishReqListener.onSuccess(result);
                }
            }
        },null);
    }
}
