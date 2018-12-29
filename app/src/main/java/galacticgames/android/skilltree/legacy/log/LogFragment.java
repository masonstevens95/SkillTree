package galacticgames.android.skilltree.legacy.log;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.legacy.skill.Skill;
import galacticgames.android.skilltree.legacy.skill.SkillData;

public class LogFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    private static final String ARG_LOG_ID = "log_id";
    private static final String DIALOG_DATE = "DialogDate";
    private static final String DIALOG_TIME = "DialogTime";

    private static final int REQUEST_DATE = 0;
    private static final int REQUEST_TIME = 1;

    private Log mLog;
    //this Log's Starting skill
    private Skill mSkill;
    int mSkillPosition;
    private Spinner mSkillSpinner;
    private Button mTimeButton;
    private Button mDateButton;
    private EditText mNotesField;

    public static LogFragment newInstance(UUID logId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_LOG_ID, logId);

        LogFragment fragment = new LogFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //UUID from intent
        UUID logId = (UUID) getArguments().getSerializable(ARG_LOG_ID);
        mLog = LogData.get(getActivity()).getLog(logId);
        mSkill = mLog.getSkill();
    }

    @Override
    public void onPause(){
        super.onPause();

        LogData.get(getActivity())
                .updateLog(mLog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.legacy_fragment_entry_log, container, false);

        //******************Skill Dropdown********************//
        mSkillSpinner = (Spinner) v.findViewById(R.id.log_skill_spinner);
        SkillData skillData = SkillData.get(getActivity());
        List<Skill> skills = skillData.getSkills();
        //gets current skill, sets it as the default. Currently brings up UUID or something... some formatting issue?
        mSkillPosition = skills.indexOf(mSkill);
        mSkillSpinner.setSelection(mSkillPosition);

        ArrayAdapter<Skill> adapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, skills);
        mSkillSpinner.setAdapter(adapter);
        mSkillSpinner.setOnItemSelectedListener(this);

        //******************Time Button********************//
        mTimeButton = (Button) v.findViewById(R.id.log_time_button);
        updateTime();
        mTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(mLog.getHours(), mLog.getMinutes());
                //sets LogFragment as the target fragment for the date request code
                dialog.setTargetFragment(LogFragment.this, REQUEST_TIME);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        //******************Date Button********************//
        mDateButton = (Button) v.findViewById(R.id.log_date_button);
        updateDate();
        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(mLog.getDate());
                //sets LogFragment as the target fragment for the date request code
                dialog.setTargetFragment(LogFragment.this, REQUEST_DATE);
                dialog.show(manager, DIALOG_DATE);
            }
        });

        //******************Notes EditText********************//
        mNotesField = (EditText) v.findViewById(R.id.log_notes);
        //first time loaded, set the notes text from intent.
        mNotesField.setText(mLog.getNotes());
        mNotesField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mLog.setNotes(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //intentionally left blank
            }
        });

        return v;
    }


    //For Spinner
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id){
        Skill skill = (Skill) parent.getItemAtPosition(position);
        mLog.setSkill(skill);
    }

    public void onNothingSelected(AdapterView<?> adapterView){
        mSkillSpinner.setSelection(mSkillPosition);
    }

    //respond to the date dialog
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode != Activity.RESULT_OK){
            return;
        }

        if (requestCode == REQUEST_DATE){
            Date date = (Date) data
                    .getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mLog.setDate(date);
            updateDate();
        }

        if (requestCode == REQUEST_TIME){
            Number hour = (Number) data
                    .getSerializableExtra(TimePickerFragment.EXTRA_HOUR);
            Number minute = (Number) data
                    .getSerializableExtra(TimePickerFragment.EXTRA_MINUTE);
            mLog.setHours(hour.intValue());
            mLog.setMinutes(minute.intValue());
            updateTime();
        }
    }

    private void updateDate() {
        mDateButton.setText(mLog.getDate().toString());
    }

    private void updateTime() {
        mTimeButton.setText(mLog.getHours() + "hours, " + mLog.getMinutes() + "minutes");
    }

}
