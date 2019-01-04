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
            implements SkillDetailsScreenViewMvc
//            SkillDetailsAchievementsTabRecyclerAdapter.Listener,
//            SkillDetailsLogsTabRecyclerAdapter.Listener
                                                        {

    //region final declarations

    private final ToolbarViewMvc mToolbarViewMvc;

    private final Toolbar mToolbar;
//    private final RecyclerView mRecyclerAchievements;
//    private final RecyclerView mRecyclerLogs;
//    private final SkillDetailsAchievementsTabRecyclerAdapter mAchievementsAdapter;
//    private final SkillDetailsLogsTabRecyclerAdapter mLogsAdapter;

    private final BottomNavigationView mBottomNavigationView;

    private final ProgressBar mProgressBar;

    //endregion

    public SkillDetailsScreenViewMvcImpl(LayoutInflater inflater,
                                       @Nullable ViewGroup parent,
                                       ViewMvcFactory viewMvcFactory){

        setRootView(inflater.inflate(R.layout.layout_skilldetails_main, parent, false));

//        mRecyclerAchievements = findViewById(R.id.skilldetails_achievements_recyclerview);
//        mRecyclerAchievements.setLayoutManager(new LinearLayoutManager(getContext()));
//        mAchievementsAdapter = new SkillDetailsAchievementsTabRecyclerAdapter(this, viewMvcFactory);
//        mRecyclerAchievements.setAdapter(mAchievementsAdapter);
//
//        mRecyclerLogs = findViewById(R.id.skilldetails_logs_recyclerview);
//        mRecyclerLogs.setLayoutManager(new LinearLayoutManager(getContext()));
//        mLogsAdapter = new SkillDetailsLogsTabRecyclerAdapter(this, viewMvcFactory);
//        mRecyclerLogs.setAdapter(mLogsAdapter);

        mBottomNavigationView = findViewById(R.id.bottom_navigation_view);
        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.navigation_achievements:
                                for (Listener listener : getListeners()){
                                    listener.onAchievementTabClicked();
                                }
                                return true;
                            case R.id.navigation_graph:
                                for (Listener listener : getListeners()){
                                    listener.onGraphTabClicked();
                                }
                                return true;
                            case R.id.navigation_log:
                                for (Listener listener : getListeners()){
                                    listener.onLogTabClicked();
                                }
                                return true;
                        }

                        return false;
                    }
        });

        mProgressBar = findViewById(R.id.progress);

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


    public void onAchievementTabClicked() {
        for (Listener listener : getListeners()){
            listener.onAchievementTabClicked();
        }
    }

    public void onGraphTabClicked() {
        for (Listener listener : getListeners()){
            listener.onGraphTabClicked();
        }
    }

    public void onLogTabClicked() {
        for (Listener listener : getListeners()){
            listener.onLogTabClicked();
        }
    }
}
