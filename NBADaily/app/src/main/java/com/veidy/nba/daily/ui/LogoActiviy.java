package com.veidy.nba.daily.ui;

import android.content.Intent;
import android.os.Bundle;

import com.veidy.nba.daily.MainActivity;
import com.veidy.nba.daily.R;
import com.veidy.nba.daily.logic.db.DBLogic;
import com.veidy.nba.daily.logic.db.IDBLogic;
import com.veidy.nba.daily.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import greendao.NBATeam;

/**
 * 启动
 */
public class LogoActiviy extends BaseActivity {

    private IDBLogic idbLogic;
    private boolean star = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_activiy);

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (star)
                    initNBATeam();

            }
        }).start();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void initLogic() {
        super.initLogic();
        idbLogic = new DBLogic();
    }

    private void initNBATeam() {
        List<NBATeam> data = idbLogic.selectALLNBATeam();
        if (null == data || data.isEmpty()) {
            data = new ArrayList<>();
            //东部
            NBATeam nbaTeam = null;
            nbaTeam = new NBATeam(0l, "老鹰", "", R.mipmap.e_1);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(1l, "猛龙", "", R.mipmap.e_28);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(2l, "活塞", "", R.mipmap.e_8);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(3l, "骑士", "", R.mipmap.e_5);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(4l, "奇才", "", R.mipmap.e_27);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(5l, "公牛", "", R.mipmap.e_4);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(6l, "尼克斯", "", R.mipmap.e_18);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(7l, "热火", "", R.mipmap.e_14);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(8l, "凯尔特人", "", R.mipmap.e_2);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(9l, "步行者", "", R.mipmap.e_11);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(10l, "黄蜂", "", R.mipmap.e_30);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(11l, "雄鹿", "", R.mipmap.e_15);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(12l, "魔术", "", R.mipmap.e_19);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(13l, "76人", "", R.mipmap.e_20);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(14l, "篮网", "", R.mipmap.e_17);
            data.add(nbaTeam);

            //西部
            nbaTeam = new NBATeam(15l, "快船", "", R.mipmap.w_12);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(16l, "雷霆", "", R.mipmap.w_25);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(17l, "火箭", "", R.mipmap.w_10);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(18l, "马刺", "", R.mipmap.w_24);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(19l, "湖人", "", R.mipmap.w_13);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(20l, "森林狼", "", R.mipmap.w_16);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(21l, "国王", "", R.mipmap.w_23);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(22l, "小牛", "", R.mipmap.w_6);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(23l, "爵士", "", R.mipmap.w_26);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(24l, "太阳", "", R.mipmap.w_21);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(25l, "开拓者", "", R.mipmap.w_7);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(26l, "掘金", "", R.mipmap.e_28);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(27l, "鹈鹕", "", R.mipmap.w_3);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(28l, "灰熊", "", R.mipmap.w_29);
            data.add(nbaTeam);
            nbaTeam = new NBATeam(29l, "勇士", "", R.mipmap.w_9);
            data.add(nbaTeam);

            boolean isadd = idbLogic.initNBATeamData(data);
        }
        star=false;
    }
}
