package galacticgames.android.skilltree.screens.skilldetails.logstab.logstabitem;

import galacticgames.android.skilltree.achievement.Achievement;
import galacticgames.android.skilltree.log.Log;
import galacticgames.android.skilltree.screens.common.views.ObservableViewMvc;

public interface LogsTabListItemViewMvc extends ObservableViewMvc<LogsTabListItemViewMvc.Listener> {

    public interface Listener{
        void onLogClicked(Log log);
    }

    void bindLog(Log log);
}
