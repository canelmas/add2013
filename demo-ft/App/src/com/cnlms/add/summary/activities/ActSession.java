package com.cnlms.add.summary.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.cnlms.add.R;
import com.cnlms.add.summary.fragments.FragSessionInfo;
import com.cnlms.add.summary.fragments.FragSpeaker;
import com.cnlms.add.summary.fragments.FragVenue;
import com.cnlms.add.summary.models.Session;
import com.cnlms.add.summary.models.Speaker;

/**
 * Copyright 2013 Pozitron.
 * <p/>
 * All rights reserved.
 * POZITRON PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * <p/>
 * User: can <can.elmas@pozitron.com>
 * Date: 6/14/13 1:52 AM
 */
public class ActSession extends SherlockFragmentActivity implements
        FragSessionInfo.SpeakerClickListener,
        FragSessionInfo.HallClickListener {

    public static String KEY_SESSION = "SESSION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_activity);

        Session session = (Session) getIntent().getExtras().get(KEY_SESSION);

        //   Show initial fragment
        showSessionDetails(session);

    }

    private void showSessionDetails(Session session) {

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.fragment_container, FragSessionInfo.newInstance(session, this, this));
        ft.commit();

    }

    @Override
    public void onSpeakerClicked(Speaker speaker) {

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.setCustomAnimations(
                R.anim.slide_in_to_left,
                R.anim.slide_out_to_left,
                R.anim.slide_in_to_right,
                R.anim.slide_out_to_right
        );

        ft.replace(R.id.fragment_container, FragSpeaker.newInstance(speaker));
        ft.addToBackStack(null);

        ft.commit();

    }

    @Override
    public void onHallClicked(String hall) {

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.setCustomAnimations(
                R.anim.slide_in_to_left,
                R.anim.slide_out_to_left,
                R.anim.slide_in_to_right,
                R.anim.slide_out_to_right
        );

        ft.replace(R.id.fragment_container, FragVenue.newInstance(hall, true));
        ft.addToBackStack(null);

        ft.commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {

                finish();

            } else {

                getSupportFragmentManager().popBackStack();

            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
