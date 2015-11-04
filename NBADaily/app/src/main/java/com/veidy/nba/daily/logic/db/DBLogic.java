package com.veidy.nba.daily.logic.db;

import com.veidy.nba.daily.NBAApplication;

import java.util.List;

import de.greenrobot.dao.AbstractDao;
import greendao.DaoSession;
import greendao.NBATeam;
import greendao.NBATeamDao;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : NBADaily
 * @Copyright : GL. All Rights Reserved
 * @Company : 江苏国立网络科技有限公司
 * @Create Date  : 2015/11/4  16:44
 */
public class DBLogic extends BaseDBLogic implements IDBLogic {


    @Override
    public boolean initNBATeamData(List<NBATeam> nbaTeams) {
        NBATeamDao nbaTeamDao = NBAApplication.getInstance().getDaoSession().getNBATeamDao();
        if (null != nbaTeams && nbaTeams.size() > 0) {
            for (NBATeam nbaTeam : nbaTeams) {
                nbaTeamDao.insert(nbaTeam);
            }

        }

        return false;
    }

    @Override
    public List<NBATeam> selectALLNBATeam() {
        DaoSession daoSession= NBAApplication.getInstance().getDaoSession();

        NBATeamDao nbaTeamDao =daoSession.getNBATeamDao();
        List<NBATeam> nbaTeamList = nbaTeamDao.queryBuilder().list();
        return nbaTeamList;
    }

    @Override
    public AbstractDao getDao() {
        return new NBATeamDao(null);
    }
}
