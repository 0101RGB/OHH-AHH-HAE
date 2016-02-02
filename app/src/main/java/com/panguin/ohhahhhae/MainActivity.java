package com.panguin.ohhahhhae;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.panguin.ohhahhhae.fragments.DevelopFragment;
import com.panguin.ohhahhhae.fragments.ExpectFragment;
import com.panguin.ohhahhhae.fragments.GraphFragment;
import com.panguin.ohhahhhae.fragments.GrowthinfoFragment;
import com.panguin.ohhahhhae.fragments.MeasureFragment;
import com.panguin.ohhahhhae.fragments.MenuFragment;
import com.panguin.ohhahhhae.fragments.RegisterFragment;
import com.panguin.ohhahhhae.fragments.ValueFragment;

public class MainActivity extends FragmentActivity {
    private String mName = null;
    private String mMonth = null;
    private String mGender = null;

    private FragmentTransaction mFrgTransaction = null;
    private RegisterFragment mRegister = null;
    private MenuFragment mMenu = null;
    private MeasureFragment mMeasure = null;
    private ValueFragment mValue = null;
    private GrowthinfoFragment mGrowthinfo = null;
    private DevelopFragment mDevelop = null;
    private ExpectFragment mExpect = null;
    private GraphFragment mGraph = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume(){
        super.onResume();
        makeView();
        moveFragment(Constants.REGISTER);
    }
    @Override
    public void onPause(){
        super.onPause();

    }

    private void makeView()
    {
        mRegister = new RegisterFragment();
        mMeasure = new MeasureFragment();
        mGrowthinfo = new GrowthinfoFragment();
        mDevelop = new DevelopFragment();
        mGraph = new GraphFragment();
        mValue = new ValueFragment();

    }

    public void moveFragment(int type){
        mFrgTransaction = getSupportFragmentManager().beginTransaction();
        switch (type){
            case Constants.REGISTER:
                mFrgTransaction.replace(R.id.container, mRegister);
                break;
            case Constants.MENU:
                if(mMenu == null)
                    mMenu = new MenuFragment(mName, mMonth, mGender);
                mFrgTransaction.replace(R.id.container, mMenu);
                break;
            case Constants.MEASURE:
                mFrgTransaction.replace(R.id.container, mMeasure);
                break;
            case Constants.VALUE:
                mFrgTransaction.replace(R.id.container, mValue);
                break;
            case Constants.GROWTHINFO:
                mFrgTransaction.replace(R.id.container, mGrowthinfo);
                break;
            case Constants.DEVELOP:
                mFrgTransaction.replace(R.id.container, mDevelop);
                break;
            case Constants.EXPECT:
                if(mExpect == null)
                    mExpect = new ExpectFragment(mGender);
                mFrgTransaction.replace(R.id.container, mExpect);
                break;
            case Constants.GRAPH:
                mFrgTransaction.replace(R.id.container, mGraph);
                break;
            default:
        }
        mFrgTransaction.commit();
    }

    public void setName(String Name) { mName = Name; }
    public void setMonth(String Month) { mMonth = Month; }
    public void setGender(Boolean Gender) {
        if(Gender)
            mGender = "남아";
        else
            mGender = "여아";
    }

    public String getName(){ return mName; }
    public String getMonth() { return mMonth; }
    public String getGender() { return mGender; }

}

