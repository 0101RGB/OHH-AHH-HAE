package com.panguin.ohhahhhae.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MenuFragment extends Fragment {
    private View wholeView = null;
    private String mName = null;
    private String mMonth = null;
    private String mGender = null;
    public MenuFragment (){}
    public MenuFragment (String Name, String Month, String Gender){
        this.mName = Name;
        this.mMonth = Month;
        this.mGender = Gender;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle data){
        wholeView = inflater.inflate(R.layout.fragment_menu, null);
        return wholeView;
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
        ((Button)wholeView.findViewById(R.id.btnMenu_estimate)).setOnClickListener(click);
        ((Button)wholeView.findViewById(R.id.btnMenu_growthInfo)).setOnClickListener(click);
        ((TextView)wholeView.findViewById(R.id.textViewInfo)).setText(mName + " ("+ mGender +"/"+mMonth+"개월)");
    }

    View.OnClickListener click = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(v.getId() == R.id.btnMenu_estimate)
                ((MainActivity)getActivity()).moveFragment(Constants.MEASURE);
                //Third page showing
                //fragment is basic method, it can bring activity
            else if(v.getId() == R.id.btnMenu_growthInfo)
                ((MainActivity)getActivity()).moveFragment(Constants.GROWTHINFO);
            //Growing Info. page will be showed
        }
    };
}
