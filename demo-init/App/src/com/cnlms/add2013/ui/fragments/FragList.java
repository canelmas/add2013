package com.cnlms.add2013.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cnlms.add2013.R;
import com.cnlms.add2013.models.Session;

import java.util.List;

/**
 * Copyright 2013 Pozitron.
 * <p/>
 * All rights reserved.
 * POZITRON PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * <p/>
 * User: can <can.elmas@pozitron.com>
 * Date: 6/12/13 3:29 PM
 */
public final class FragList extends Fragment {

    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        /**
         *  Called before activity.onCreate() finishes
         */
        View view = inflater.inflate(R.layout.frag_list, container, false);

        listView = (ListView) view.findViewById(R.id.listview);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        //  generate dummy data
        final List<Session> dummyData = Session.dummyList(50);

        //  set list view adapter
        final ItemAdapter adapter = new ItemAdapter(dummyData);

        listView.setAdapter(adapter);

        //  pass onItemClick event to activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ((ItemSelectionListener)getActivity()).onItemSelected(dummyData.get(position));
            }

        });

    }

    /**
     *  Inner type interface that handles on session click listener
     */
    public interface ItemSelectionListener {
        void onItemSelected(final Session session);
    }

    /**
     *  List View Adapter
     */
    class ItemAdapter extends BaseAdapter {

        private List<Session> mSessionList;

        private final LayoutInflater inflater;

        public ItemAdapter(final List<Session> sessionList) {

            mSessionList = sessionList;

            inflater = LayoutInflater.from(FragList.this.getActivity());
        }

        @Override
        public int getCount() {
            return mSessionList.size();
        }

        @Override
        public Object getItem(int position) {
            return mSessionList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            final Session session = mSessionList.get(position);

            ViewHolder holder;

            if (view == null) {

                view = inflater.inflate(R.layout.session, parent, false);

                holder = new ViewHolder();

                holder.name = (TextView) view.findViewById(R.id.item_name);
                holder.cost = (TextView) view.findViewById(R.id.item_cost);

                view.setTag(holder);

            } else {

                holder = (ViewHolder) view.getTag();

            }

            holder.name.setText("Session : " + session.getName());
            holder.cost.setText(String.valueOf(session.getTime()));

            return view;

        }

        class ViewHolder {
            public TextView name;
            public TextView cost;
        }
    }
}
