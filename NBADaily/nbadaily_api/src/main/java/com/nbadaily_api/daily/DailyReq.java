package com.nbadaily_api.daily;

import com.nbadaily_api.base.BaseReq;
import com.nbadaily_api.base.CommonResult;
import com.nbadaily_api.base.IReturnCallBack;
import com.nbadaily_api.base.ProtocolType;
import com.nbadaily_api.daily.data.DailyResult;
import com.nbadaily_api.jsoup.JsoupFactory;
import com.nbadaily_api.model.DailyModel;

import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

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
    public void doGet(IReturnCallBack callBack,CommonResult result) {
        callBack.onReturn(ProtocolType.ResponseEvent.START,new DailyResult());
        //game-container-inner
       Document document= JsoupFactory.getInstance().getDocument(getUrl());
        if (null!=document){
            // 拿到表格数据
            Elements e_2 = document.select("div#table980middle");
            Elements trs = e_2.select("tr");
            List tr_list = new ArrayList<>();
            int flag = 0;
            // 得到今天的比赛
            for (int i = 0; i < trs.size(); i++) {
                Elements tds = trs.get(i).select("td");
                if (flag < 2) {
                    for (int j = 0; j < tds.size(); j++) {
                        String text = tds.get(j).text();
                        if ("类型".equals(text)) {
                            flag++;
                        }
                    }
                    tr_list.add(trs.get(i));
                }
            }
            List<DailyModel> data = new ArrayList<>();
            for (int i = 1; i < tr_list.size() - 1; i++) {
                DailyModel daily = new DailyModel();

                Elements tds = trs.get(i).select("td");
                daily.play_time = tds.get(0).text();
                daily.team_A = tds.get(2).text();
                daily.format_score = tds.get(3).text();
                daily.team_B = tds.get(4).text();
                data.add(daily);

            }
            DailyResult dailyResult=new DailyResult();
            dailyResult.dailyModels=data;
            callBack.onReturn(ProtocolType.ResponseEvent.SUCCESS,dailyResult);
        }else {
            callBack.onReturn(ProtocolType.ResponseEvent.ERROR,new DailyResult());
        }
    }

    @Override
    public String getUrl() {
        return "http://nba.sports.sina.com.cn/match_result.php?dpc=1";
    }


}
