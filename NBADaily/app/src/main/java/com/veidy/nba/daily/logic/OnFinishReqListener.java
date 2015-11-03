package com.veidy.nba.daily.logic;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : NBADaily
 * @Copyright : GL. All Rights Reserved
 * @Company : 江苏国立网络科技有限公司
 * @Create Date  : 2015/11/3  10:08
 */
public interface OnFinishReqListener {

    public void onSuccess(Object object);

    public void onFailed(Object object);
}
