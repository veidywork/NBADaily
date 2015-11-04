package com.veidy.nba.daily;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import greendao.DaoMaster;
import greendao.DaoSession;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : NBADaily
 * @Copyright : GL. All Rights Reserved
 * @Company : 江苏国立网络科技有限公司
 * @Create Date  : 2015/11/4  16:36
 */
public class NBAApplication extends Application {
    private SQLiteDatabase db;

    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private static  NBAApplication application;
    @Override
    public void onCreate() {
        application = this;
        super.onCreate();
        setupDatabase();
    }

    public static synchronized  NBAApplication getInstance(){
        if (null==application){
            application=new NBAApplication();
        }
        return application;
    }

    private void setupDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "daily-db", null);
        db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public void setDaoMaster(DaoMaster daoMaster) {
        this.daoMaster = daoMaster;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public void setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
    }
}
