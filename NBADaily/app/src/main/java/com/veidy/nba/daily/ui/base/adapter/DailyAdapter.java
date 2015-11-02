package com.veidy.nba.daily.ui.base.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nbadaily_api.model.DailyModel;
import com.veidy.nba.daily.R;

import java.util.List;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : NBADaily
 * @Create Date  : 2015/11/2  14:49
 */
public class DailyAdapter extends BaseVAdapter {
    public DailyAdapter(Context mContext, List mLists) {
        super(mContext, mLists);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView=View.inflate(mContext, R.layout.adapter_daily,null);
        }
        TextView tv_play_state=ViewHolder.get(convertView,R.id.tv_play_state);
        TextView tv_play_time=ViewHolder.get(convertView,R.id.tv_play_tiem);
        TextView tv_a_name=ViewHolder.get(convertView,R.id.tv_a_name);
        TextView tv_b_name=ViewHolder.get(convertView,R.id.tv_b_name);
        TextView tv_scroe=ViewHolder.get(convertView,R.id.tv_score);

        DailyModel dailyModel= (DailyModel) getItem(position);

        tv_a_name.setText(dailyModel.team_A);

        tv_b_name.setText(dailyModel.team_B);

        tv_scroe.setText(dailyModel.team_A_score+"-"+dailyModel.team_B_score);
        tv_play_time.setText(dailyModel.play_time);
        String state="未开始";
        switch (dailyModel.play_state) {
            case 0:
                state="未开始";
                break;
            case 1:
                state="进行中";
                break;
            case 2:
                state="加时";
                break;
            case 3:
                state="已结束";
                break;
        }
        tv_play_state.setText(state);
        return convertView;

    }
}
