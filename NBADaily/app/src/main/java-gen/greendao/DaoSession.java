package greendao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig nBATeamDaoConfig;

    private final NBATeamDao nBATeamDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        nBATeamDaoConfig = daoConfigMap.get(NBATeamDao.class).clone();
        nBATeamDaoConfig.initIdentityScope(type);

        nBATeamDao = new NBATeamDao(nBATeamDaoConfig, this);

        registerDao(NBATeam.class, nBATeamDao);
    }
    
    public void clear() {
        nBATeamDaoConfig.getIdentityScope().clear();
    }

    public NBATeamDao getNBATeamDao() {
        return nBATeamDao;
    }

}
