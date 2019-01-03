package galacticgames.android.skilltree.screens.skilldetails.logstab.logstabitem;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.log.Log;
import galacticgames.android.skilltree.screens.common.views.BaseObservableViewMvc;

public class LogsTabListItemViewMvcImpl extends BaseObservableViewMvc<LogsTabListItemViewMvc.Listener>
                implements LogsTabListItemViewMvc{

    private final TextView mTitle;
    private final TextView mTime;
    private final TextView mDetails;

    private Log mLog;

    public LogsTabListItemViewMvcImpl(LayoutInflater inflater,
                                      @Nullable ViewGroup parent){
        setRootView(inflater.inflate(R.layout.layout_skilldetails_logs_item, parent, false));

        mTitle = findViewById(R.id.log_title);
        mTime = findViewById(R.id.log_time);
        mDetails = findViewById(R.id.log_details);
        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()) {
                    listener.onLogClicked(mLog);
                }
            }
        });
    }

    @Override
    public void bindLog(Log log) {
        mLog = log;
        //TODO: set image here. needs to be a property of achievement.
        //TODO: set title
        //mTitle.setText(mAchievement.getTitle());
        //TODO: set details
        //mDetails.setText(mAchievement.getDetails());
    }
}
