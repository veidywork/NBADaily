package com.nbadaily_api.base;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : NBADaily
 * @Create Date  : 2015/11/2  16:36
 */
public interface IReturnCallBack<T extends CommonResult> {
    public void onReturn(ProtocolType.ResponseEvent event,T result);
}
