package com.cnlms.add.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.cnlms.add.R;
import com.cnlms.add.summary.activities.ActSummary;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2013 Pozitron.
 * <p/>
 * All rights reserved.
 * POZITRON PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * <p/>
 * User: can <can.elmas@pozitron.com>
 * Date: 6/13/13 10:43 PM
 */
public class ActChoose extends Activity implements AdapterView.OnItemClickListener {

    private List<String> options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_choose);

        ListView listView = (ListView) findViewById(R.id.listview_options);

        options = new ArrayList<String>();

        options.add("Add");
        options.add("Add with Animation");
        options.add("Replace with Animation");
        options.add("Replace with Animation and remember the number");
        options.add("Summary");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, options);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, ActMain.class);

        switch (position) {

            case 0:
            default:
                intent.putExtra(ActMain.KEY_MODE, ActMain.MODE_ADD_FRAGMENT);
                break;

            case 1:
                intent.putExtra(ActMain.KEY_MODE, ActMain.MODE_ADD_FRAGMENT_WITH_ANIM);
                break;

            case 2:
                intent.putExtra(ActMain.KEY_MODE, ActMain.MODE_REPLACE_FRAGMENT_WITH_ANIM);
                break;

            case 3:
                intent.putExtra(ActMain.KEY_MODE, ActMain.MODE_REPLACE_FRAGMENT_WITH_ANIM_REMEMBER);
                break;

            case 4 :

                intent = new Intent(this, ActSummary.class);
                startActivity(intent);

                return;

        }

        startActivity(intent);

    }
}
