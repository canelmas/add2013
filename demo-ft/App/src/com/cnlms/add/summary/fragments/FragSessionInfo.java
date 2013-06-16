package com.cnlms.add.summary.fragments;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.cnlms.add.R;
import com.cnlms.add.summary.models.Session;
import com.cnlms.add.summary.models.Speaker;

/**
 * Copyright 2013 Pozitron.
 * <p/>
 * All rights reserved.
 * POZITRON PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * <p/>
 * User: can <can.elmas@pozitron.com>
 * Date: 6/14/13 2:01 AM
 */
public final class FragSessionInfo extends SherlockFragment {

    private Session mSession;
    private SpeakerClickListener speakerClickListener;
    private HallClickListener hallClickListener;

    public interface SpeakerClickListener {
        void onSpeakerClicked(Speaker speaker);
    }

    public interface HallClickListener {
        void onHallClicked(String hall);
    }

    public static FragSessionInfo newInstance(Session session,
                                              SpeakerClickListener speakerClickListener,
                                              HallClickListener hallClickListener) {

        FragSessionInfo fragment = new FragSessionInfo();

        fragment.mSession               = session;
        fragment.speakerClickListener   = speakerClickListener;
        fragment.hallClickListener      = hallClickListener;

        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_session_detail, container, false);

        //  Session Name
        ((TextView)view.findViewById(R.id.sesion_detail_name)).setText(mSession.getSessionName());

        //  Speaker Name
        TextView speakerName = (TextView)view.findViewById(R.id.session_detail_speaker);

        speakerName.setText(mSession.getSpeaker().getName());

        speakerName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                speakerClickListener.onSpeakerClicked(mSession.getSpeaker());

            }

        });

        //  Hall
        TextView hallName = (TextView) view.findViewById(R.id.session_detail_hall);

        hallName.setText(mSession.getHall());

        hallName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hallClickListener.onHallClicked(mSession.getHall());
            }

        });

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        //  Modify action bar for this fragment
        ActionBar actionBar = getActivity().getActionBar();

        actionBar.setTitle("Session Info");
        actionBar.setDisplayHomeAsUpEnabled(true);

        //  Tell activity that this fragment has its own menu
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_session_info, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_item_share) {

            Toast.makeText(getActivity(), "Will share this session", Toast.LENGTH_SHORT).show();

            return true;

        }

        return super.onOptionsItemSelected(item);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
