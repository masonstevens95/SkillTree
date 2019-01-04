package galacticgames.android.skilltree.screens.skilldetails.achievementstab;

import java.util.List;

import galacticgames.android.skilltree.skill.achievement.Achievement;
import galacticgames.android.skilltree.screens.common.views.ObservableViewMvc;

public interface AchievementsTabViewMvc extends ObservableViewMvc<AchievementsTabViewMvc.Listener> {

    public interface Listener{
        void onHomeClicked();

        void onAchievementClicked(Achievement achievement);
    }

    void bindAchievements(List<Achievement> achievements);

    void showProgressIndication();

    void hideProgressIndication();

}
