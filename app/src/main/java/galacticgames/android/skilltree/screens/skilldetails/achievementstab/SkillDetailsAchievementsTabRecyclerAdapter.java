package galacticgames.android.skilltree.screens.skilldetails.achievementstab;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import galacticgames.android.skilltree.achievement.Achievement;
import galacticgames.android.skilltree.screens.common.ViewMvcFactory;
import galacticgames.android.skilltree.screens.skilldetails.SkillDetailsScreenViewMvc;
import galacticgames.android.skilltree.screens.skilldetails.SkillDetailsScreenViewMvcImpl;
import galacticgames.android.skilltree.screens.skilldetails.achievementstab.achievementstabitem.AchievementsTabListItemViewMvc;

public class SkillDetailsAchievementsTabRecyclerAdapter extends RecyclerView.Adapter<SkillDetailsAchievementsTabRecyclerAdapter.MyViewHolder>
                implements AchievementsTabListItemViewMvc.Listener {

    public interface Listener {
        void onAchievementClicked(Achievement achievement);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private final AchievementsTabListItemViewMvc mViewMvc;

        public MyViewHolder (AchievementsTabListItemViewMvc viewMvc) {
            super(viewMvc.getRootView());
            mViewMvc = viewMvc;
        }
    }

    private final Listener mListener;
    private final ViewMvcFactory mViewMvcFactory;

    private List<Achievement> mAchievements = new ArrayList<>();

    public SkillDetailsAchievementsTabRecyclerAdapter(Listener listener, ViewMvcFactory viewMvcFactory) {
        mListener = listener;
        mViewMvcFactory = viewMvcFactory;
    }

    public void bindAchievements(List<Achievement> achievements){
        mAchievements = new ArrayList<>(achievements);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AchievementsTabListItemViewMvc viewMvc = mViewMvcFactory.getAchievementsTabListItemViewMvc(parent);
        viewMvc.registerListener(this);
        return new MyViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mViewMvc.bindAchievement(mAchievements.get(position));
    }

    @Override
    public int getItemCount() {
        return mAchievements.size();
    }

    @Override
    public void onAchievementClicked(Achievement achievement) {
        //TODO: implement
    }
}
