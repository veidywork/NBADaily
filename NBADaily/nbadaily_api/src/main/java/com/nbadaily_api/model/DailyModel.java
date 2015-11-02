package com.nbadaily_api.model;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : NBADaily
 * @Create Date  : 2015/11/2  14:54
 */
public class DailyModel extends BaseModel{

    /**
     * 主场球队名称
     */
    public String team_A;

    /**
     * 主场球队id
     */
    public String team_A_id;

    /**
     * 主场球队icon
     */
    public PHOTO team_A_icon;

    /**
     * 客场球队名称
     */
    public String team_B;

    /**
     * 客场球队id
     */
    public String team_B_id;

    /**
     * 主场球队icon
     */
    public PHOTO team_B_icon;

    /**
     * 主场球队得分
     */
    public int team_A_score;


    /**
     * 客场球队得分
     */
    public int team_B_score;


    /**
     * 开赛时间
     */
    public String play_time;


    /**
     * 比赛状态  0代表未开始，1代表常规进行中，2代表加时进行中 ，3代表比赛结束
     */
    public int play_state;

}
