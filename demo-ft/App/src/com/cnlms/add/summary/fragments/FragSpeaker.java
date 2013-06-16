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
import com.cnlms.add.summary.models.Speaker;

/**
 * Copyright 2013 Pozitron.
 * <p/>
 * All rights reserved.
 * POZITRON PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * <p/>
 * User: can <can.elmas@pozitron.com>
 * Date: 6/14/13 12:53 AM
 */
public final class FragSpeaker extends SherlockFragment {

    private static final String KEY_SPEAKER = "SPEAKER";

    public static FragSpeaker newInstance(Speaker speaker) {

        FragSpeaker fragment = new FragSpeaker();

        Bundle data = new Bundle();
        data.putSerializable(KEY_SPEAKER, speaker);

        fragment.setArguments(data);

        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_speaker, container, false);

        Speaker speaker = (Speaker) getArguments().getSerializable(KEY_SPEAKER);

        ((TextView)view.findViewById(R.id.speaker_name)).setText(speaker.getName());
        ((TextView)view.findViewById(R.id.speaker_info)).setText(speaker.getInfo());
        ((TextView)view.findViewById(R.id.speaker_email)).setText(speaker.getEmail());

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        //  Modify action bar
        ActionBar actionBar = getActivity().getActionBar();

        actionBar.setTitle("Speaker Info");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //  Tell activity that this fragment has its own menu
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_speaker, menu);

        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_item_send_mail) {

            Toast.makeText(getActivity(), "sending message", Toast.LENGTH_SHORT).show();

            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
