package com.veidy.nba.daily.logic.db;

import java.util.List;

import greendao.NBATeam;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : NBADaily
 * @Copyright : GL. All Rights Reserved
 * @Company : 江苏国立网络科技有限公司
 * @Create Date  : 2015/11/4  16:44
 */
public interface IDBLogic {

    /**初始化球队*/
    public boolean initNBATeamData(List<NBATeam> nbaTeams);

    public List<NBATeam> selectALLNBATeam();
}
