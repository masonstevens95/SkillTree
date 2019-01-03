package galacticgames.android.skilltree.screens.userskills.userskillsitem;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.screens.common.views.BaseObservableViewMvc;
import galacticgames.android.skilltree.skill.Skill;

public class UserSkillsListItemViewMvcImpl extends BaseObservableViewMvc<UserSkillsListItemViewMvc.Listener>
                implements UserSkillsListItemViewMvc {

    private final TextView mSkillName;

    private Skill mSkill;

    public UserSkillsListItemViewMvcImpl(LayoutInflater inflater,
                                         @Nullable ViewGroup parent){
        setRootView(inflater.inflate(R.layout.layout_userskills_list_item, parent, false));

        mSkillName = findViewById(R.id.skill_name);
        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()) {
                    listener.onUserSkillClicked(mSkill);
                }
            }
        });
    }

    @Override
    public void bindSkill(Skill skill) {
        mSkill = skill;
        mSkillName.setText(skill.getTitle());
    }
}
