package com.veidy.nba.daily;

import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.nbadaily_api.daily.data.DailyResult;
import com.nbadaily_api.model.DailyModel;
import com.nbadaily_api.model.PHOTO;
import com.veidy.nba.daily.common.MessageType;
import com.veidy.nba.daily.logic.OnFinishReqListener;
import com.veidy.nba.daily.logic.daily.DailyLogic;
import com.veidy.nba.daily.logic.daily.IDailyLogic;
import com.veidy.nba.daily.logic.db.DBLogic;
import com.veidy.nba.daily.logic.db.IDBLogic;
import com.veidy.nba.daily.ui.base.BaseActivity;
import com.veidy.nba.daily.ui.base.adapter.DailyAdapter;

import java.util.ArrayList;
import java.util.List;

import greendao.NBATeam;
import greendao.NBATeamDao;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ListView lv;
    private DailyAdapter adapter;
    private List<DailyModel> dailyModelList = new ArrayList<>();
    IDailyLogic dailyLogic;
    private SwipeRefreshLayout swiperefreshlayout;
    private IDBLogic idbLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initView("");
        initData();


        new Thread(new Runnable() {
            @Override
            public void run() {
                dailyLogic.getDaily("", new OnFinishReqListener() {
                    @Override
                    public void onSuccess(Object object) {
                        ResponseData(object);
                    }

                    @Override
                    public void onFailed(Object object) {

                    }
                });
            }
        }).start();
    }

    @Override
    protected void handleStateMessage(Message message) {
        super.handleStateMessage(message);

        switch (message.what) {
            case MessageType.DAILYLIST_SUCCESS:
                swiperefreshlayout.setRefreshing(false);
                List<DailyModel> data = (List<DailyModel>) message.obj;
                if (null != data && data.size() > 0) {
                    dailyModelList.clear();
                    dailyModelList.addAll(data);
                    adapter.notifyDataSetChanged();
                }
                break;
        }

    }

    @Override
    protected void initLogic() {
        super.initLogic();
        if (dailyLogic == null)
            dailyLogic = new DailyLogic();
        idbLogic = new DBLogic();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void initView(String title) {
        super.initView(title);
        lv = getView(R.id.lv);
        swiperefreshlayout = getView(R.id.swiperefreshlayout);
    }

    @Override
    protected void initData() {
        super.initData();

        adapter = new DailyAdapter(this, dailyModelList);

        lv.setAdapter(adapter);

        swiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        dailyLogic.getDaily("", new OnFinishReqListener() {
                            @Override
                            public void onSuccess(Object object) {
                                ResponseData(object);
                            }

                            @Override
                            public void onFailed(Object object) {

                            }
                        });
                    }
                }).start();
            }
        });
    }

    /**
     * 解析返回数据
     *
     * @param object
     */
    private void ResponseData(Object object) {
        Message message = new Message();
        message.what = MessageType.DAILYLIST_SUCCESS;
        DailyResult result = (DailyResult) object;
        List<DailyModel> data = result.dailyModels;
        NBATeamDao nbaTeamDao = NBAApplication.getInstance().getDaoSession().getNBATeamDao();
        if (null != data && !data.isEmpty()) {
            for (DailyModel dailyModel : data) {

                List<NBATeam> A_TEAM = nbaTeamDao.queryBuilder().where(NBATeamDao.Properties.Team_name.eq(dailyModel.team_A)).list();
                PHOTO photo_a = new PHOTO();
                photo_a.drawableids = A_TEAM.get(0).getIcon_id();
                dailyModel.team_A_icon = photo_a;

                List<NBATeam> B_TEAM = nbaTeamDao.queryBuilder().where(NBATeamDao.Properties.Team_name.eq(dailyModel.team_B)).list();
                PHOTO photo_b = new PHOTO();
                photo_b.drawableids = B_TEAM.get(0).getIcon_id();
                dailyModel.team_B_icon = photo_b;

            }

        }
        message.obj = data;
        getHandler().sendMessage(message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
