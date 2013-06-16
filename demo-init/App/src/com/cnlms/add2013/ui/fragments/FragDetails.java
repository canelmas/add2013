package com.cnlms.add2013.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cnlms.add2013.R;
import com.cnlms.add2013.models.Session;

/**
 * Copyright 2013 Pozitron.
 * <p/>
 * All rights reserved.
 * POZITRON PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * <p/>
 * User: can <can.elmas@pozitron.com>
 * Date: 6/12/13 3:29 PM
 */
public final class FragDetails extends Fragment {

    private TextView sessionName;
    private TextView speaker;
    private TextView venue;
    private TextView time;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_details, container, false);

        sessionName = (TextView) view.findViewById(R.id.session);
        speaker     = (TextView) view.findViewById(R.id.speaker);
        venue       = (TextView) view.findViewById(R.id.venue);
        time        = (TextView) view.findViewById(R.id.time);

        return view;

    }

    public void setSessionInfo(final Session session) {

        sessionName.setText(session.getName());
        speaker.setText("Speaker : "    + session.getSpeaker());
        venue.setText("Venue : "        + session.getVenue());
        time.setText("Time : "          + session.getTime());

    }

}
