package galacticgames.android.skilltree.legacy.log;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;

import java.util.List;
import java.util.UUID;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.legacy.skill.Skill;
import galacticgames.android.skilltree.legacy.skill.SkillData;

public class LogListFragment extends Fragment{

    private static final String ARG_SKILL_ID = "skill_id";

    private LineChart mLogGraph;
    private RecyclerView mLogListRecyclerView;
    private LogAdapter mLogAdapter;
    private Log mLog;
    private Skill mSkill;

    public static LogListFragment newInstance(UUID logId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_SKILL_ID, logId);

        LogListFragment fragment = new LogListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        UUID skillId = (UUID) getArguments().getSerializable(ARG_SKILL_ID);

        mSkill = SkillData.get(getActivity()).getSkill(skillId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.legacy_fragment_list_log, container, false);

        mLogGraph = (LineChart) view.findViewById(R.id.skill_graph);

        mLogListRecyclerView = (RecyclerView) view.findViewById(R.id.log_recycler_view);
        mLogListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    //need to do this so the list updates after adjusting values in LogFragment
    @Override
    public void onResume(){
        super.onResume();
        updateUI();
    }

    //initialize menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.legacy_fragment_list_log, menu);
    }

    //make the menu actually do something
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.new_log:
                Log log = new Log();
                LogData.get(getActivity()).addLog(log, mSkill);
                Intent intent = LogActivity
                        .newIntent(getActivity(), log.getId());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //updates the UI
    private void updateUI(){
        LogData logData = LogData.get(getActivity());
        List<Log> logs = logData.getLogs();

        if (mLogAdapter == null){
            mLogAdapter = new LogListFragment.LogAdapter(logs);
            mLogListRecyclerView.setAdapter(mLogAdapter);
        }else{
            mLogAdapter.setLogs(logs);
            mLogAdapter.notifyDataSetChanged();
        }
    }

    //The ViewHolder; this is holds the smaller views within recyclerview. Also pulls out all the
    //widgets you are interested in. Currently just skill title.
    private class LogHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Log mLog;
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private TextView mNotesTextView;

        //constructor
        public LogHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.legacy_fragment_list_log_item, parent, false));

            //click listener
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.log_skill);
            mDateTextView = (TextView) itemView.findViewById(R.id.log_date);
            mNotesTextView = (TextView) itemView.findViewById(R.id.log_notes);
        }

        //allows binding
        public void bind(Log log){
            mLog = log;
            //***********
            //THIS NEEDS TO BE CHANGED WHEN MAKING DATABASE
            //***********
            //mTitleTextView.setText(mSkill.getTitle());
            mDateTextView.setText(mLog.getDate().toString());
            mNotesTextView.setText(mLog.getNotes());
        }

        @Override
        public void onClick(View view){

            //***********
            //THIS NEEDS TO BE CHANGED WHEN MAKING DATABASE
            //***********

            Intent intent = LogActivity.newIntent(getActivity(), mLog.getId());
            startActivity(intent);

            //Toast.makeText(getActivity(),
            //        mLog.getId() + " clicked!",
            //       Toast.LENGTH_SHORT).show();

            //mCallbacks.onSkillSelected(mSkill);
        }
    }

    //The Adapter. When RecyclerView needs to display a new viewholder or connect a crime object
    //to an existing Viewholder, it will ask the Adapter for help.
    private class LogAdapter extends RecyclerView.Adapter<LogListFragment.LogHolder> {

        private List<Log> mLogs;

        //constructor
        public LogAdapter(List<Log> logs){
            mLogs = logs;
        }

        //called by the recyclerview when it needs a viewholder to display an item with.
        //This only happens to initialize after they are recycled.
        @Override
        public LogListFragment.LogHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new LogListFragment.LogHolder(layoutInflater, parent);
        }

        //binds model data to a widget.
        @Override
        public void onBindViewHolder(LogListFragment.LogHolder holder, int position){
            Log log = mLogs.get(position);
            holder.bind(log);
        }

        @Override
        public int getItemCount(){
            return mLogs.size();
        }

        public void setLogs(List<Log> logs){
            mLogs = logs;
        }
    }

}
