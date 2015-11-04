package com.veidy.nba.daily.logic.db;

import de.greenrobot.dao.AbstractDao;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : NBADaily
 * @Copyright : GL. All Rights Reserved
 * @Company : 江苏国立网络科技有限公司
 * @Create Date  : 2015/11/4  16:46
 */
public abstract class BaseDBLogic<T extends AbstractDao> {

    public abstract T getDao();
}
