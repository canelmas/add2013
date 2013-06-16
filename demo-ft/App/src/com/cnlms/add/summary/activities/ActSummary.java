package com.cnlms.add.summary.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.cnlms.add.R;
import com.cnlms.add.summary.fragments.FragSessions;
import com.cnlms.add.summary.fragments.FragVenue;
import com.cnlms.add.summary.models.Session;

/**
 * Copyright 2013 Pozitron.
 * <p/>
 * All rights reserved.
 * POZITRON PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * <p/>
 * User: can <can.elmas@pozitron.com>
 * Date: 6/14/13 12:52 AM
 */
public class ActSummary extends SherlockFragmentActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener, FragSessions.SessionSelectionListener  {

    private ViewPager mViewPager;
    private MainPagerAdapter mPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_summary);

        /** View Pager **/
        mPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOnPageChangeListener(this);
        mViewPager.setOffscreenPageLimit(2);

        /** Initialize Action Bar **/
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        /** Tab 1 : Sessions **/
        actionBar.addTab(actionBar.newTab().setText("Sessions").setTabListener(this));

        /** Tab 2 : Speakers **/
        actionBar.addTab(actionBar.newTab().setText("Venue").setTabListener(this));

    }


    /** Action Bar Tab Listener Callback Methods **/
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }


    /** View Pager Callback Methods **/
    @Override
    public void onPageSelected(int position) {
        getSupportActionBar().setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {
    }

    @Override
    public void onPageScrollStateChanged(int i) {
    }

    @Override
    public void onSessionSelected(Session session) {

        Intent intent = new Intent(this, ActSession.class);

        intent.putExtra(ActSession.KEY_SESSION, session);

        startActivity(intent);

    }

    /** Main View Pager Adapter **/
    class MainPagerAdapter extends FragmentPagerAdapter {

        private static final int FRAGMENT_COUNT = 2;

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return position == 0 ?
                    FragSessions.newInstance(ActSummary.this) :
                    FragVenue.newInstance("Android Developer Days 2013", false);


        }

        @Override
        public int getCount() {
            return FRAGMENT_COUNT;
        }
    }

}
