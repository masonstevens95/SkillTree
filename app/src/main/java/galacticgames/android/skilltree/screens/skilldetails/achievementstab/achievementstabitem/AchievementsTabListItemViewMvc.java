package galacticgames.android.skilltree.screens.skilldetails.achievementstab.achievementstabitem;

import galacticgames.android.skilltree.achievement.Achievement;
import galacticgames.android.skilltree.screens.common.views.ObservableViewMvc;

public interface AchievementsTabListItemViewMvc extends ObservableViewMvc<AchievementsTabListItemViewMvc.Listener> {

    public interface Listener{
        void onAchievementClicked(Achievement achievement);
    }

    void bindAchievement(Achievement achievement);
}
