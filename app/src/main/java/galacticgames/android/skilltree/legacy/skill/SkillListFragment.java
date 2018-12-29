package galacticgames.android.skilltree.legacy.skill;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import galacticgames.android.skilltree.R;

public class SkillListFragment extends Fragment {

    private RecyclerView mSkillListRecyclerView;
    private SkillAdapter mSkillAdapter;

    private Button mAddSkillButton;

    //to maintain independence of fragments and delegate funtionality to the host activity, we use callbacks.
    private Callbacks mCallbacks;

    /*
    required interface for hosting activities
     */
    public interface Callbacks{
        void onSkillSelected(Skill skill);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mCallbacks = (Callbacks) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_list_skill, container, false);

        mSkillListRecyclerView = (RecyclerView) view.findViewById(R.id.skill_recycler_view);
        mSkillListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAddSkillButton = (Button) view.findViewById(R.id.btn_add_skill);
        mAddSkillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "Add Skill Clicked", Toast.LENGTH_SHORT).show();
                Skill skill = new Skill();
                SkillData.get(getActivity()).addSkill(skill);
                Intent intent = SkillActivity
                        .newIntent(getActivity(), skill.getId());
                startActivity(intent);
            }
        });

        updateUI();

        return view;
    }

    @Override
    public void onDetach(){
        super.onDetach();
        mCallbacks = null;
    }

    //updates the UI
    private void updateUI(){
        SkillData skillData = SkillData.get(getActivity());
        List<Skill> skills = skillData.getSkills();

        mSkillAdapter = new SkillAdapter(skills);
        mSkillListRecyclerView.setAdapter(mSkillAdapter);
    }

    //The ViewHolder; this is holds the smaller views within recyclerview. Also pulls out all the
        //widgets you are interested in. Currently just skill title.
    private class SkillHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Skill mSkill;
        private TextView mTitleTextView;
        //constructor
        public SkillHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.fragment_list_skill_item, parent, false));

            //click listener
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.skill_title);
        }

        //allows binding
        public void bind(Skill skill){
            mSkill = skill;
            mTitleTextView.setText(mSkill.getTitle());
        }

        @Override
        public void onClick(View view){
            //Toast.makeText(getActivity(),
            //        mSkill.getTitle() + " clicked!",
            //        Toast.LENGTH_SHORT).show();

            mCallbacks.onSkillSelected(mSkill);
        }
    }

    //The Adapter. When RecyclerView needs to display a new viewholder or connect a crime object
        //to an existing Viewholder, it will ask the Adapter for help.
    private class SkillAdapter extends RecyclerView.Adapter<SkillHolder> {

        private List<Skill> mSkills;

        //constructor
        public SkillAdapter(List<Skill> skills){
            mSkills = skills;
        }

        //called by the recyclerview when it needs a viewholder to display an item with.
            //This only happens to initialize after they are recycled.
        @Override
        public SkillHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new SkillHolder(layoutInflater, parent);
        }

        //binds model data to a widget.
        @Override
        public void onBindViewHolder(SkillHolder holder, int position){
            Skill skill = mSkills.get(position);
            holder.bind(skill);
        }

        @Override
        public int getItemCount(){
            return mSkills.size();
        }
    }
}
