package com.cnlms.add2013.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
 * Date: 6/12/13 6:23 PM
 */
public class ActDetails extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_details);

        final Session session = (Session) getIntent().getExtras().get("session");

        ((TextView) findViewById(R.id.session)).setText(session.getName());
        ((TextView) findViewById(R.id.speaker)).setText("Speaker : "    + session.getSpeaker());
        ((TextView) findViewById(R.id.venue)).setText("Venue : "        + session.getVenue());
        ((TextView) findViewById(R.id.time)).setText("Time : "          + session.getTime());

    }
}
