package galacticgames.android.skilltree.screens.skilldetails;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.List;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.achievement.Achievement;
import galacticgames.android.skilltree.common.toolbar.ToolbarViewMvc;
import galacticgames.android.skilltree.log.Log;
import galacticgames.android.skilltree.screens.common.ViewMvcFactory;
import galacticgames.android.skilltree.screens.common.views.BaseObservableViewMvc;
import galacticgames.android.skilltree.screens.skilldetails.achievementstab.SkillDetailsAchievementsTabRecyclerAdapter;
import galacticgames.android.skilltree.screens.skilldetails.logstab.SkillDetailsLogsTabRecyclerAdapter;

public class SkillDetailsScreenViewMvcImpl extends BaseObservableViewMvc<SkillDetailsScreenViewMvc.Listener>
            implements SkillDetailsScreenViewMvc,
            SkillDetailsAchievementsTabRecyclerAdapter.Listener,
            SkillDetailsLogsTabRecyclerAdapter.Listener {

    //region final declarations

    private final ToolbarViewMvc mToolbarViewMvc;

    private final Toolbar mToolbar;
    private final RecyclerView mRecyclerAchievements;
    private final RecyclerView mRecyclerLogs;
    private final SkillDetailsAchievementsTabRecyclerAdapter mAchievementsAdapter;
    private final SkillDetailsLogsTabRecyclerAdapter mLogsAdapter;

    private final BottomNavigationView mBottomNavigationView;

    private final ProgressBar mProgressBar;
    private final Button mNewLogButton;

    //endregion

    public SkillDetailsScreenViewMvcImpl(LayoutInflater inflater,
                                       @Nullable ViewGroup parent,
                                       ViewMvcFactory viewMvcFactory){

        setRootView(inflater.inflate(R.layout.layout_skilldetails_main, parent, false));

        mRecyclerAchievements = findViewById(R.id.skilldetails_achievements_recyclerview);
        mRecyclerAchievements.setLayoutManager(new LinearLayoutManager(getContext()));
        mAchievementsAdapter = new SkillDetailsAchievementsTabRecyclerAdapter(this, viewMvcFactory);
        mRecyclerAchievements.setAdapter(mAchievementsAdapter);

        mRecyclerLogs = findViewById(R.id.skilldetails_logs_recyclerview);
        mRecyclerLogs.setLayoutManager(new LinearLayoutManager(getContext()));
        mLogsAdapter = new SkillDetailsLogsTabRecyclerAdapter(this, viewMvcFactory);
        mRecyclerLogs.setAdapter(mLogsAdapter);

        mBottomNavigationView = findViewById(R.id.bottom_navigation_view);
        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.navigation_achievements:
                                onAchievementTabClicked();
                                return true;
                            case R.id.navigation_graph:
                                onGraphTabClicked();
                                return true;
                            case R.id.navigation_log:
                                onLogTabClicked();
                                return true;
                        }

                        return false;
                    }
        });

        mProgressBar = findViewById(R.id.progress);

        mNewLogButton = findViewById(R.id.btn_new_log);
        mNewLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()){
                    listener.onAddClicked();
                }
            }
        });

        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getToolbarViewMvc(mToolbar);
        initToolbar();
    }

    private void initToolbar() {
        //TODO: set toolbar text, in controller given whatever skill this is
        mToolbarViewMvc.setTitle("Skill Details");
        mToolbar.addView(mToolbarViewMvc.getRootView());
        mToolbarViewMvc.enableHomeButtonAndListen(new ToolbarViewMvc.HomeClickListener(){
            @Override
            public void onHomeClicked() {
                for (Listener listener : getListeners()){
                    listener.onHomeClicked();
                }
            }
        } );
        mToolbarViewMvc.enableAddButtonAndListen(new ToolbarViewMvc.AddClickListener(){
            @Override
            public void onAddClicked() {
                for (Listener listener : getListeners()){
                    listener.onAddClicked();
                }
            }
        });
    }


    //@Override
    public void onAchievementTabClicked() {
        for (Listener listener : getListeners()){
            listener.onAchievementTabClicked();
        }
    }

    @Override
    public void onAchievementClicked(Achievement achievement) {
        for (Listener listener : getListeners()){
            listener.onAchievementClicked(achievement);
        }
    }

    //@Override
    public void onGraphTabClicked() {
        for (Listener listener : getListeners()){
            listener.onGraphTabClicked();
        }
    }

    //@Override
    public void onLogTabClicked() {
        for (Listener listener : getListeners()){
            listener.onLogTabClicked();
        }
    }

    @Override
    public void onLogClicked(Log log) {
        for (Listener listener : getListeners()){
            listener.onLogClicked(log);
        }
    }

    @Override
    public void bindAchievements(List<Achievement> achievements) {
        mAchievementsAdapter.bindAchievements(achievements);
    }

    @Override
    public void bindLogs(List<Log> logs) {
        mLogsAdapter.bindLogs(logs);
    }

    @Override
    public void showProgressIndication() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressIndication() {
        mProgressBar.setVisibility(View.GONE);
    }
}
