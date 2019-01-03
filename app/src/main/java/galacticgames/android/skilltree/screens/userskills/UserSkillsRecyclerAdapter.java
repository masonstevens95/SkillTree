package galacticgames.android.skilltree.screens.userskills;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import galacticgames.android.skilltree.screens.common.ViewMvcFactory;
import galacticgames.android.skilltree.screens.userskills.userskillsitem.UserSkillsListItemViewMvc;
import galacticgames.android.skilltree.skill.Skill;

public class UserSkillsRecyclerAdapter extends RecyclerView.Adapter<UserSkillsRecyclerAdapter.MyViewHolder>
            implements UserSkillsListItemViewMvc.Listener {

    public interface Listener {
        void onUserSkillClicked(Skill skill);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private final UserSkillsListItemViewMvc mViewMvc;

        public MyViewHolder (UserSkillsListItemViewMvc viewMvc) {
            super(viewMvc.getRootView());
            mViewMvc = viewMvc;
        }
    }

    private final Listener mListener;
    private final ViewMvcFactory mViewMvcFactory;

    private List<Skill> mSkills = new ArrayList<>();

    public UserSkillsRecyclerAdapter(Listener listener, ViewMvcFactory viewMvcFactory) {
        mListener = listener;
        mViewMvcFactory = viewMvcFactory;
    }

    public void bindSkills(List<Skill> skills){
        mSkills = new ArrayList<>(skills);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UserSkillsListItemViewMvc viewMvc = mViewMvcFactory.getUsersSkillListItemViewMvc(parent);
        viewMvc.registerListener(this);
        return new MyViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mViewMvc.bindSkill(mSkills.get(position));
    }

    @Override
    public int getItemCount() {
        return mSkills.size();
    }

    @Override
    public void onUserSkillClicked(Skill skill) {
        mListener.onUserSkillClicked(skill);
    }

}
