package com.cnlms.add.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cnlms.add.R;

/**
 * Copyright 2013 Pozitron.
 * <p/>
 * All rights reserved.
 * POZITRON PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * <p/>
 * User: can <can.elmas@pozitron.com>
 * Date: 6/13/13 1:35 AM
 */
public final class FragRandom extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TextView view = (TextView) inflater.inflate(R.layout.frag_random, container, false);

        //  set a numeric value
        view.setText(String.valueOf(System.currentTimeMillis() % 50));

        return view;

    }

}
