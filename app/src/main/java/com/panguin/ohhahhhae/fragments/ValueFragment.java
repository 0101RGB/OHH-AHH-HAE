package com.panguin.ohhahhhae.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.panguin.ohhahhhae.Constants;
import com.panguin.ohhahhhae.MainActivity;
import com.panguin.ohhahhhae.R;

public class ValueFragment extends Fragment {
    private View wholeView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle data){
        wholeView = inflater.inflate(R.layout.fragment_value, null);
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
        ((Button)wholeView.findViewById(R.id.btnValue_back)).setOnClickListener(click);
    }

    View.OnClickListener click = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(v.getId() == R.id.btnValue_back)
                ((MainActivity)getActivity()).moveFragment(Constants.MENU);
        }
    };
}
