package com.cnlms.add.summary.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragment;
import com.cnlms.add.R;
import com.cnlms.add.summary.models.Data;
import com.cnlms.add.summary.models.Session;

import java.util.List;

/**
 * Copyright 2013 Pozitron.
 * <p/>
 * All rights reserved.
 * POZITRON PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * <p/>
 * User: can <can.elmas@pozitron.com>
 * Date: 6/14/13 12:53 AM
 */
public final class FragSessions extends SherlockFragment {

    public interface SessionSelectionListener {
        void onSessionSelected(final Session session);
    }

    /**
     *  Session Selection Listener
     */
    private SessionSelectionListener mListener;

    public static FragSessions newInstance(SessionSelectionListener listener) {

        final FragSessions fragment = new FragSessions();

        fragment.mListener = listener;

        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_sessions, container, false);

        //  populate list view
        ListView listView = (ListView) view.findViewById(R.id.list_view_sessions);

        final List<Session> sessions = Data.get();

        listView.setAdapter(new SessionAdapter(sessions));

        //  delegate session selection to the listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onSessionSelected(sessions.get(position));
            }

        });

        return view;
    }



    class SessionAdapter extends BaseAdapter {

        private List<Session> sessionList;

        private LayoutInflater inflater;

        public SessionAdapter(final List<Session> sessionList) {

            this.sessionList = sessionList;

            inflater = LayoutInflater.from(FragSessions.this.getActivity());

        }

        @Override
        public int getCount() {
            return sessionList.size();
        }

        @Override
        public Session getItem(int position) {
            return sessionList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView txtView = (TextView) inflater.inflate(R.layout.item_session, parent, false);

            Session session = sessionList.get(position);

            txtView.setText(session.getSessionName());

            return txtView;

        }
    }

}
