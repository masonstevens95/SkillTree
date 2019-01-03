package galacticgames.android.skilltree.screens.skilldetails.logstab;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import galacticgames.android.skilltree.log.Log;
import galacticgames.android.skilltree.screens.common.ViewMvcFactory;
import galacticgames.android.skilltree.screens.skilldetails.logstab.logstabitem.LogsTabListItemViewMvc;

public class SkillDetailsLogsTabRecyclerAdapter extends RecyclerView.Adapter<SkillDetailsLogsTabRecyclerAdapter.MyViewHolder>
        implements LogsTabListItemViewMvc.Listener {

    public interface Listener {
        void onLogClicked(Log log);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private final LogsTabListItemViewMvc mViewMvc;

        public MyViewHolder (LogsTabListItemViewMvc viewMvc) {
            super(viewMvc.getRootView());
            mViewMvc = viewMvc;
        }
    }

    private final Listener mListener;
    private final ViewMvcFactory mViewMvcFactory;

    private List<Log> mLogs = new ArrayList<>();

    public SkillDetailsLogsTabRecyclerAdapter(Listener listener, ViewMvcFactory viewMvcFactory) {
        mListener = listener;
        mViewMvcFactory = viewMvcFactory;
    }

    public void bindLogs(List<Log> logs){
        mLogs = new ArrayList<>(logs);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LogsTabListItemViewMvc viewMvc = mViewMvcFactory.getLogsTabListItemViewMvc(parent);
        viewMvc.registerListener(this);
        return new MyViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mViewMvc.bindLog(mLogs.get(position));
    }

    @Override
    public int getItemCount() {
        return mLogs.size();
    }

    @Override
    public void onLogClicked(Log log) {
        //TODO: implement
    }

}
