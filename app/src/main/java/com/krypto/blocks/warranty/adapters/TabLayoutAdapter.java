package com.krypto.blocks.warranty.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



import com.krypto.blocks.warranty.fragments.SummaryFragment;
import com.krypto.blocks.warranty.model.TabIt;

import java.util.ArrayList;

public class TabLayoutAdapter extends FragmentStatePagerAdapter {

    private ArrayList<TabIt> list;

    public TabLayoutAdapter(FragmentManager fm, ArrayList<TabIt> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int pos) {
        switch (pos) {
            case 0:
                return SummaryFragment.newInstance();
            default:
                return SummaryFragment.newInstance();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).name;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}