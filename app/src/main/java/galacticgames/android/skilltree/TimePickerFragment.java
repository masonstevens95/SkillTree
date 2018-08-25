package galacticgames.android.skilltree;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.NumberPicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimePickerFragment extends android.support.v4.app.DialogFragment{

    public static final String EXTRA_HOUR =
            "galacticgames.android.skilltree.hour";
    public static final String EXTRA_MINUTE =
            "galacticgames.android.skilltree.minute";

    private static final String ARG_HOURS = "hours";
    private static final String ARG_MINUTES = "minutes";

    private NumberPicker mHourPicker;
    private NumberPicker mMinutePicker;

    public static TimePickerFragment newInstance(Number hours, Number minutes){
        Bundle args = new Bundle();
        args.putSerializable(ARG_HOURS, hours);
        args.putSerializable(ARG_MINUTES, minutes);

        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //parse Date into a Calendar object
        Number hours = (Number) getArguments().getSerializable(ARG_HOURS);
        Number minutes = (Number) getArguments().getSerializable(ARG_MINUTES);

        /*
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        */

        //inflate the dialog layout
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_time, null);

        //null is onDateChangedListener
        //LogFragment now shows DatePickerFragment what date to show.
        mHourPicker = (NumberPicker) v.findViewById(R.id.hours);
        mHourPicker.setMaxValue(23);
        if (hours == null){
            mHourPicker.setValue(0);
        }else{
            mHourPicker.setValue(hours.intValue());
        }
        mHourPicker.setOnValueChangedListener(onHourValueChangeListener);

        mMinutePicker = (NumberPicker) v.findViewById(R.id.minutes);
        mMinutePicker.setMaxValue(59);
        if (minutes == null){
            mMinutePicker.setValue(0);
        }else{
            mMinutePicker.setValue(minutes.intValue());
        }
        mMinutePicker.setOnValueChangedListener(onMinuteValueChangeListener);

        //return the proper dialog
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.time_picker_title)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            //use sendResult methos to retrieve data from DatePicker and send to LogFragment
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //int year = mDatePicker.getYear();
                                //int month = mDatePicker.getMonth();
                                //int day = mDatePicker.getDayOfMonth();
                                //Date date = new GregorianCalendar(year,month, day).getTime();
                                int hours = mHourPicker.getValue();
                                int minutes = mMinutePicker.getValue();
                                sendResult(Activity.RESULT_OK, hours, minutes);
                            }
                        })
                .create();
    }

    NumberPicker.OnValueChangeListener onHourValueChangeListener =
            new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {

                    mHourPicker.setValue(i1);

                }
            };

    NumberPicker.OnValueChangeListener onMinuteValueChangeListener =
            new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {

                    mMinutePicker.setValue(i1);

                }
            };

    //sends date back to LogFragment
    //DatePickerFragment passes to LogFragment.onActivityResult(int, int, Intent).
    //because LogFragment and DatePickerFragment are hosted by the dame activity,
    //Fragment.onActivityResult(...) can be borrowed and called directly on the target fragment
    //to pass back data.
    private void sendResult(int resultCode, Number hours, Number minutes){
        if (getTargetFragment() == null){
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_HOUR, hours);
        intent.putExtra(EXTRA_MINUTE, minutes);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }

}
