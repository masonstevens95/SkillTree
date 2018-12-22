package galacticgames.android.skilltree.legacy.log;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import galacticgames.android.skilltree.R;

public class DatePickerFragment extends DialogFragment{

    public static final String EXTRA_DATE =
            "galacticgames.android.skilltree.date";

    private static final String ARG_DATE = "date";

    private DatePicker mDatePicker;

    public static DatePickerFragment newInstance(Date date){
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //parse Date into a Calendar object
        Date date = (Date) getArguments().getSerializable(ARG_DATE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        //inflate the dialog layout
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_date, null);

        //null is onDateChangedListener
        //LogFragment now shows DatePickerFragment what date to show.
        mDatePicker = (DatePicker) v.findViewById(R.id.dialog_date_picker);
        mDatePicker.init(year, month, day, null);

        //return the proper dialog
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            //use sendResult method to retrieve data from DatePicker and send to LogFragment
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int year = mDatePicker.getYear();
                                int month = mDatePicker.getMonth();
                                int day = mDatePicker.getDayOfMonth();
                                Date date = new GregorianCalendar(year,month, day).getTime();
                                sendResult(Activity.RESULT_OK, date);
                            }
                        })
                .create();
    }

    //sends date back to LogFragment
    //DatePickerFragment passes to LogFragment.onActivityResult(int, int, Intent).
        //because LogFragment and DatePickerFragment are hosted by the dame activity,
        //Fragment.onActivityResult(...) can be borrowed and called directly on the target fragment
        //to pass back data.
    private void sendResult(int resultCode, Date date){
        if (getTargetFragment() == null){
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_DATE, date);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }

}
