package com.panguin.ohhahhhae.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import com.panguin.ohhahhhae.Constants;
import com.panguin.ohhahhhae.MainActivity;
import com.panguin.ohhahhhae.R;

import java.util.Calendar;

public class RegisterFragment extends Fragment {
    DatePicker datePicker;
    private int result_month=0;
    private int year, month, day;
    private Calendar calendar;

    private View wholeView=null;
    private boolean gender = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle date){
        wholeView = inflater.inflate(R.layout.fragment_register, null);
        //bring root view
        //bind to wholeView
        return wholeView;
        //must return wholeView for showing xml , null-> nullPointerException
    }

    @Override
    public void onResume(){
        super.onResume();
        makeView();
    }
    @Override
    public void onPause(){
        super.onPause();
    }

    private void makeView(){
        //make listener and convey to makeView
        ((Button) wholeView.findViewById(R.id.btnRegister_login)).setOnClickListener(click);
        //Register button click listener
        ((RadioButton)wholeView.findViewById(R.id.radio_Male)).setOnCheckedChangeListener(check);
        ((RadioButton)wholeView.findViewById(R.id.radio_Female)).setOnCheckedChangeListener(check);

        calendar = Calendar.getInstance();
        result_month=monthCalculate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));


    }


    CheckBox.OnCheckedChangeListener check = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(buttonView.getId()==R.id.radio_Male)
                if(isChecked)
                    gender = true;
            //남아가 체크 됐을때

            if(buttonView.getId()==R.id.radio_Female)
                if(isChecked)
                    gender = false;
            //여아가 체크 됐을때

        }
    };

    View.OnClickListener click = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            //when View is clicked in onClickListener
            int id = v.getId();
            //get id from clicked one (as integer)
            if(id == R.id.btnRegister_login){
                ((MainActivity) getActivity()).setName(((EditText) wholeView.findViewById(R.id.editRegister_name)).getText().toString());
                ((MainActivity) getActivity()).setMonth(Integer.toString(result_month));
                ((MainActivity) getActivity()).setGender(gender);
                ((MainActivity) getActivity()).moveFragment(Constants.MENU);
            }
            //Second page
        }

    };

    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {

            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;
        }
    };

    public int monthCalculate (int c_year, int c_monthOfYear, int c_dayOfMonth) {
        int y = 0, m = 0;
        int result;

        y = (c_year - year) * 12;
        m = c_monthOfYear - month;
        result = y + m;

        return result;
    }
}

