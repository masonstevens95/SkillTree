package galacticgames.android.skilltree.screens.userskills.userskillsitem;

import galacticgames.android.skilltree.screens.common.views.ObservableViewMvc;
import galacticgames.android.skilltree.skill.Skill;

public interface UserSkillsListItemViewMvc extends ObservableViewMvc<UserSkillsListItemViewMvc.Listener> {

    public interface Listener{
        void onUserSkillClicked(Skill skill);
    }

    void bindSkill(Skill skill);
}
