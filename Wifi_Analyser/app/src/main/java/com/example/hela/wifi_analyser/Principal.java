package com.example.hela.wifi_analyser;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;


public class Principal extends TabActivity implements TabHost.OnTabChangeListener{
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tabHost = getTabHost();
        tabHost.setOnTabChangedListener(this);
        TabHost.TabSpec spec;
        Intent intent;
        //*********** first **********
        intent = new Intent().setClass(this, first.class);
        spec = tabHost.newTabSpec("First").setIndicator("").setContent(intent);
        tabHost.addTab(spec);
        //*********** second **********
        intent = new Intent().setClass(this, Second.class);
        spec = tabHost.newTabSpec("First").setIndicator("").setContent(intent);
        tabHost.addTab(spec);
        //*********** third **********
        //intent=new Intent().setClass(this,Third.class);
        //spec=tabHost.newTabSpec("Third").setIndicator("").setContent(intent);
        //tabHost.addTab(spec);
        //********************************
        tabHost.getTabWidget().setCurrentTab(0);
        tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.sig);
        tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.pulse);
        // tabHost.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.strength);

    }



    @Override
    public void onTabChanged(String s) {
        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
        {
            if(i==0)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.sig);
            else if(i==1)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.pulse);

        }


        Log.i("tabs", "CurrentTab: " + tabHost.getCurrentTab());


        if(tabHost.getCurrentTab()==0)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.orgsig);
        else if(tabHost.getCurrentTab()==1)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.orgpul);


    }
}
