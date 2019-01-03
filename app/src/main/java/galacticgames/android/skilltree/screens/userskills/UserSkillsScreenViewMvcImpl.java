package galacticgames.android.skilltree.screens.userskills;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.List;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.common.toolbar.ToolbarViewMvc;
import galacticgames.android.skilltree.screens.common.ViewMvcFactory;
import galacticgames.android.skilltree.screens.common.views.BaseObservableViewMvc;
import galacticgames.android.skilltree.skill.Skill;

public class UserSkillsScreenViewMvcImpl extends BaseObservableViewMvc<UserSkillsScreenViewMvc.Listener>
            implements UserSkillsScreenViewMvc, UserSkillsRecyclerAdapter.Listener{

    //region final declarations

    private final ToolbarViewMvc mToolbarViewMvc;

    private final Toolbar mToolbar;
    private final RecyclerView mRecyclerSkills;
    private final UserSkillsRecyclerAdapter mAdapter;
    private final ProgressBar mProgressBar;
    private final Button mNewSkillButton;

    //endregion

    public UserSkillsScreenViewMvcImpl(LayoutInflater inflater,
                                       @Nullable ViewGroup parent,
                                       ViewMvcFactory viewMvcFactory){

        setRootView(inflater.inflate(R.layout.layout_userskills_list, parent, false));

        mRecyclerSkills = findViewById(R.id.skill_recycler_view);
        mRecyclerSkills.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new UserSkillsRecyclerAdapter(this, viewMvcFactory);
        mRecyclerSkills.setAdapter(mAdapter);

        mProgressBar = findViewById(R.id.progress);

        mNewSkillButton = findViewById(R.id.btn_add_skill);
        mNewSkillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()){
                    listener.onNewSkillClicked();
                }
            }
        });

        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getToolbarViewMvc(mToolbar);
        initToolbar();
    }

    private void initToolbar() {
        mToolbarViewMvc.setTitle(getString(R.string.user_skills_list_screen_title));
        mToolbar.addView(mToolbarViewMvc.getRootView());
        mToolbarViewMvc.enableHomeButtonAndListen(new ToolbarViewMvc.HomeClickListener(){
            @Override
            public void onHomeClicked() {
                for (Listener listener : getListeners()){
                    listener.onHomeClicked();
                }
            }
        } );
    }

    @Override
    public void onUserSkillClicked(Skill skill) {
        for (Listener listener : getListeners()){
            listener.onSkillClicked(skill);
        }
    }

    @Override
    public void bindSkills(List<Skill> skills) {
        mAdapter.bindSkills(skills);
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
