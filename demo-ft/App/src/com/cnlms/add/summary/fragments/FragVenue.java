package com.cnlms.add.summary.fragments;

import android.R;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Copyright 2013 Pozitron.
 * <p/>
 * All rights reserved.
 * POZITRON PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * <p/>
 * User: can <can.elmas@pozitron.com>
 * Date: 6/14/13 12:53 AM
 */
public final class FragVenue extends SupportMapFragment {

    private static final int ZOOM_LEVEL = 13;

    private final LatLng mLatLng = new LatLng(39.89139,32.78472);

    private String mTitle;

    private boolean mSetActionBarTitle;

    public static FragVenue newInstance(final String title, final boolean setActionBarTitle) {

        FragVenue instance = new FragVenue();

        instance.mTitle                 = title;
        instance.mSetActionBarTitle     = setActionBarTitle;

        return instance;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        if (mSetActionBarTitle) {

            getActivity().getActionBar().setTitle(mTitle);

        }

        final GoogleMap map = getMap();

        final Marker marker = map.addMarker(
                new MarkerOptions().
                        position(mLatLng).
                        title(mTitle).
                        snippet("ADD 2013").
                        icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_menu_mylocation))
        );


        //  animate to the point
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(mLatLng, ZOOM_LEVEL));

        //  display info window
        marker.showInfoWindow();


    }


}
