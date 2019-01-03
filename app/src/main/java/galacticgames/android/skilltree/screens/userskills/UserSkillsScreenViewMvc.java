package galacticgames.android.skilltree.screens.userskills;

import java.util.List;

import galacticgames.android.skilltree.screens.common.views.ObservableViewMvc;
import galacticgames.android.skilltree.skill.Skill;

public interface UserSkillsScreenViewMvc extends ObservableViewMvc<UserSkillsScreenViewMvc.Listener> {

    public interface Listener{
        void onHomeClicked();

        void onSkillClicked(Skill skill);

        void onSkillListClicked();

        void onNewSkillClicked();
    }

    void bindSkills(List<Skill> skills);

    void showProgressIndication();

    void hideProgressIndication();
}
