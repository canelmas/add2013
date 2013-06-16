package com.cnlms.add2013.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.cnlms.add2013.R;
import com.cnlms.add2013.models.Session;
import com.cnlms.add2013.ui.fragments.FragDetails;
import com.cnlms.add2013.ui.fragments.FragList;

public final class ActMain extends FragmentActivity implements FragList.ItemSelectionListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_main);

    }

    @Override
    public void onItemSelected(Session session) {

        FragDetails fragDetails = (FragDetails) getSupportFragmentManager().findFragmentById(R.id.frag_details);

        if (fragDetails == null) {

            //  handset

            //  start Details Activity and pass session description
            Intent intent = new Intent(this, ActDetails.class);

            intent.putExtra("session", session);

            startActivity(intent);

        } else {

            //  tablet
            fragDetails.setSessionInfo(session);

        }

    }

}
