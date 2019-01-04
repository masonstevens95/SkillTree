package galacticgames.android.skilltree.screens.skilldetails.logstab;

import java.util.List;

import galacticgames.android.skilltree.log.Log;
import galacticgames.android.skilltree.screens.common.views.ObservableViewMvc;

public interface LogsTabViewMvc extends ObservableViewMvc<LogsTabViewMvc.Listener> {

    public interface Listener{
        void onHomeClicked();

        void onLogClicked(Log log);

        void onNewLogClicked();
    }

    void bindLogs(List<Log> logs);

    void showProgressIndication();

    void hideProgressIndication();

}
