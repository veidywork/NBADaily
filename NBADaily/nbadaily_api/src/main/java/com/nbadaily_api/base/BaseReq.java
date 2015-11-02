package com.nbadaily_api.base;

import org.json.JSONObject;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : NBADaily
 * @Create Date  : 2015/11/2  16:27
 */
public abstract class BaseReq<T extends CommonResult> {

    public abstract JSONObject toJson(String str);

    public abstract String fromJson(JSONObject jsonObject);

    public abstract void doGet(IReturnCallBack callBack);

//    public abstract void  exec();

    public abstract String getUrl();
}
