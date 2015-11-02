package com.nbadaily_api.daily;

import com.nbadaily_api.base.BaseReq;
import com.nbadaily_api.base.CommonResult;
import com.nbadaily_api.base.IReturnCallBack;
import com.nbadaily_api.base.ProtocolType;
import com.nbadaily_api.jsoup.JsoupFactory;

import org.json.JSONObject;
import org.jsoup.select.Elements;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : NBADaily
 * @Create Date  : 2015/11/2  16:12
 */
public class DailyReq extends BaseReq{


    @Override
    public JSONObject toJson(String str) {

        return null;
    }

    @Override
    public String fromJson(JSONObject jsonObject) {

        return null;
    }

    @Override
    public void doGet(IReturnCallBack callBack) {
        callBack.onReturn(ProtocolType.ResponseEvent.START,new CommonResult());
        Elements  elements= JsoupFactory.getInstance().getDiv(getUrl(),"game-container-inner");
        if (null!=elements){
            Elements e=  elements.select("li");
            callBack.onReturn(ProtocolType.ResponseEvent.SUCCESS,new CommonResult());
        }else {
            callBack.onReturn(ProtocolType.ResponseEvent.ERROR,new CommonResult());
        }
    }

    @Override
    public String getUrl() {
        return "http://kbs.sports.qq.com/#nba";
    }


}
