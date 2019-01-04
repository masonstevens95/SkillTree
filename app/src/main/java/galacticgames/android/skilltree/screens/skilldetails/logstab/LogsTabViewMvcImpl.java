package galacticgames.android.skilltree.screens.skilldetails.logstab;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.List;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.common.toolbar.ToolbarViewMvc;
import galacticgames.android.skilltree.log.Log;
import galacticgames.android.skilltree.screens.common.ViewMvcFactory;
import galacticgames.android.skilltree.screens.common.views.BaseObservableViewMvc;
import galacticgames.android.skilltree.screens.skilldetails.achievementstab.SkillDetailsAchievementsTabRecyclerAdapter;

public class LogsTabViewMvcImpl extends BaseObservableViewMvc<LogsTabViewMvc.Listener>
                implements LogsTabViewMvc, SkillDetailsLogsTabRecyclerAdapter.Listener{

    //region final declarations

    private final RecyclerView mRecyclerSkills;
    private final SkillDetailsLogsTabRecyclerAdapter mAdapter;
    private final ProgressBar mProgressBar;
    private final Button mNewLogButton;

    //endregion

    public LogsTabViewMvcImpl(LayoutInflater inflater,
                                      @Nullable ViewGroup parent,
                                      ViewMvcFactory viewMvcFactory){

        setRootView(inflater.inflate(R.layout.layout_skilldetails_logs_tab, parent, false));

        mRecyclerSkills = findViewById(R.id.skilldetails_logs_recyclerview);
        mRecyclerSkills.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new SkillDetailsLogsTabRecyclerAdapter(this, viewMvcFactory);
        mRecyclerSkills.setAdapter(mAdapter);

        mProgressBar = findViewById(R.id.progress);

        mNewLogButton = findViewById(R.id.btn_new_log);
        mNewLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()){
                    listener.onNewLogClicked();
                }
            }
        });

    }

    @Override
    public void onLogClicked(Log log) {
        for (Listener listener : getListeners()){
            listener.onLogClicked(log);
        }
    }

    @Override
    public void bindLogs(List<Log> logs) {
        mAdapter.bindLogs(logs);
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
