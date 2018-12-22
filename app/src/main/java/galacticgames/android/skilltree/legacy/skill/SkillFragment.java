package galacticgames.android.skilltree.legacy.skill;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.UUID;

import galacticgames.android.skilltree.R;

public class SkillFragment extends Fragment{

    private static final String ARG_SKILL_ID = "skill_id";

    private Skill mSkill;

    private EditText mTitleField;

    public static SkillFragment newInstance(UUID skillId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_SKILL_ID, skillId);

        SkillFragment fragment = new SkillFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //UUID from intent
        UUID skillId = (UUID) getArguments().getSerializable(ARG_SKILL_ID);
        mSkill = SkillData.get(getActivity()).getSkill(skillId);
    }

    @Override
    public void onPause(){
        super.onPause();

        SkillData.get(getActivity())
                .updateSkill(mSkill);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_entry_skill, container, false);


        //******************Title EditText********************//
        mTitleField = (EditText) v.findViewById(R.id.skill_title);
        //first time loaded, set the notes text from intent.
        mTitleField.setText(mSkill.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mSkill.setTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //intentionally left blank
            }
        });

        return v;
    }

}
