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

public class GrowthinfoFragment extends Fragment {
    private View wholeView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle data){
        wholeView = inflater.inflate(R.layout.fragment_growthinfo, null);
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
        ((Button)wholeView.findViewById(R.id.btnGrowthinfo_graph)).setOnClickListener(click);
        ((Button)wholeView.findViewById(R.id.btnGrowthinfo_develop)).setOnClickListener(click);
        ((Button)wholeView.findViewById(R.id.btnGrowthinfo_expect)).setOnClickListener(click);
        ((Button)wholeView.findViewById(R.id.button_fragment_forth_back)).setOnClickListener(click);
    }

    View.OnClickListener click = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(v.getId() == R.id.btnGrowthinfo_graph)
                //graph button clicked
                ((MainActivity)getActivity()).moveFragment(Constants.GRAPH);
            else if(v.getId() == R.id.btnGrowthinfo_develop)
                //develop button clicked
                ((MainActivity)getActivity()).moveFragment(Constants.DEVELOP);
            else if(v.getId() == R.id.btnGrowthinfo_expect)
                //expect button clicked
                ((MainActivity)getActivity()).moveFragment(Constants.EXPECT);
            else if(v.getId() == R.id.button_fragment_forth_back)
                //back button clicked
                ((MainActivity)getActivity()).moveFragment(Constants.MENU);

        }
    };
}
