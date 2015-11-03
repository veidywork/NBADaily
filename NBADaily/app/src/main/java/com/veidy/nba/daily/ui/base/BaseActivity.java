package com.veidy.nba.daily.ui.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : NBADaily
 * @Create Date  : 2015/11/2  14:39
 */
public class BaseActivity extends AppCompatActivity {
    private Handler mhanlder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLogic();
    }

    protected void initView(String title) {

    }

    protected void initData() {

    }

    protected void initLogic(){

    }
    /** 消息处理 */
    protected void handleStateMessage(Message message) {

    }


    /** handler */
    protected Handler getHandler() {
        if (mhanlder == null) {
            mhanlder = new Handler(this.getMainLooper()) {
                public void handleMessage(Message msg) {
                    handleStateMessage(msg);
                }
            };
        }
        return mhanlder;
    }

    protected void sendMessage(Message message) {
        getHandler().sendMessage(message);
    }

    protected void sendMessage(int what, Object obj) {
        Message message = new Message();
        message.what = what;
        message.obj = obj;
        getHandler().sendMessage(message);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int id) {
        T result = (T) findViewById(id);
        if (result == null) {
            throw new IllegalArgumentException("view 0x" + Integer.toHexString(id) + " doesn't exist");
        }
        return result;
    }


}
