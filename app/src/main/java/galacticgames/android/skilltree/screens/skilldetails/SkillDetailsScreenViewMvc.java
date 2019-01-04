package galacticgames.android.skilltree.screens.skilldetails;

import galacticgames.android.skilltree.screens.common.views.ObservableViewMvc;

public interface SkillDetailsScreenViewMvc extends ObservableViewMvc<SkillDetailsScreenViewMvc.Listener> {

    public interface Listener{
        void onHomeClicked();

        void onAchievementTabClicked();

        void onGraphTabClicked();

        void onLogTabClicked();

        void onAddClicked();
    }
}
