package galacticgames.android.skilltree.screens.skilldetails.achievementstab;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.skill.achievement.Achievement;
import galacticgames.android.skilltree.screens.common.ViewMvcFactory;
import galacticgames.android.skilltree.screens.common.views.BaseObservableViewMvc;

public class AchievementsTabViewMvcImpl extends BaseObservableViewMvc<AchievementsTabViewMvc.Listener>
                implements AchievementsTabViewMvc, SkillDetailsAchievementsTabRecyclerAdapter.Listener{

    //region final declarations

    private final RecyclerView mRecyclerSkills;
    private final SkillDetailsAchievementsTabRecyclerAdapter mAdapter;
    private final ProgressBar mProgressBar;

    //endregion

    public AchievementsTabViewMvcImpl(LayoutInflater inflater,
                                       @Nullable ViewGroup parent,
                                       ViewMvcFactory viewMvcFactory){

        setRootView(inflater.inflate(R.layout.layout_skilldetails_achievements_tab, parent, false));

        mRecyclerSkills = findViewById(R.id.skilldetails_achievements_recyclerview);
        mRecyclerSkills.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new SkillDetailsAchievementsTabRecyclerAdapter(this, viewMvcFactory);
        mRecyclerSkills.setAdapter(mAdapter);

        mProgressBar = findViewById(R.id.progress);
    }

    @Override
    public void onAchievementClicked(Achievement achievement) {
        for (Listener listener : getListeners()){
            listener.onAchievementClicked(achievement);
        }
    }

    @Override
    public void bindAchievements(List<Achievement> achievements) {
        mAdapter.bindAchievements(achievements);
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
