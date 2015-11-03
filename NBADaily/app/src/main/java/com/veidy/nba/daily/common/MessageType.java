package com.veidy.nba.daily.common;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : NBADaily
 * @Copyright : GL. All Rights Reserved
 * @Company : 江苏国立网络科技有限公司
 * @Create Date  : 2015/11/3  10:12
 */
public interface MessageType {

    public static final int BASE=0X0000;

    /**
     * 获取日报成功
     */
    public static final int DAILYLIST_SUCCESS=BASE+1;

    /**
     * 获取日报失败
     */
    public static final int DAILYLIST_FAILED=BASE+2;
}
