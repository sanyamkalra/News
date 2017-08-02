package com.sanyam.news;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by sanyam on 8/1/2017.
 */

public class View_Pager extends FragmentPagerAdapter {
    public View_Pager(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        if(position==0){
            fragment=new Fragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 1;
    }
}
