package com.cnlms.add.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.cnlms.add.R;
import com.cnlms.add.ui.fragments.FragRandom;
import com.cnlms.add.ui.fragments.FragRandomRemember;

public final class ActMain extends FragmentActivity{

    public static final String KEY_MODE = "mode";
    public static final int MODE_ADD_FRAGMENT = 0;
    public static final int MODE_ADD_FRAGMENT_WITH_ANIM = 1;
    public static final int MODE_REPLACE_FRAGMENT_WITH_ANIM = 2;
    public static final int MODE_REPLACE_FRAGMENT_WITH_ANIM_REMEMBER = 3;

    private int mode;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_main);

        this.mode = getIntent().getExtras().getInt(ActMain.KEY_MODE);

        /** Display initial fragment **/
        showInitialFragment();

        /** Next Button onClick Handler **/
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (mode) {

                    case MODE_ADD_FRAGMENT:
                        addNewFragment();
                        break;

                    case MODE_ADD_FRAGMENT_WITH_ANIM:
                        addNewFragmentWithAnimation();
                        break;

                    case MODE_REPLACE_FRAGMENT_WITH_ANIM:
                        replaceNewFragmentWithAnimation();
                        break;

                    case  MODE_REPLACE_FRAGMENT_WITH_ANIM_REMEMBER:
                        replaceNewFragmentWithAnimationAndRemember();

                }


            }

        });

        /** Back Button Click Listener **/
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                getSupportFragmentManager().popBackStack();

            }

        });

    }

    private void showInitialFragment() {

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.frag_container,
                mode == MODE_REPLACE_FRAGMENT_WITH_ANIM_REMEMBER ?
                        new FragRandomRemember():
                        new FragRandom());

        ft.commit();

    }

    /**
     *  Add new fragment without animation
     */
    private void addNewFragment() {

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.frag_container, new FragRandom());
        ft.addToBackStack(null);

        ft.commit();

    }

    /**
     *  Add new fragment with custom animation
     */
    private void addNewFragmentWithAnimation() {

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.setCustomAnimations(
                R.anim.slide_in_to_left,
                R.anim.slide_out_to_left,
                R.anim.slide_in_to_right,
                R.anim.slide_out_to_right
        );

        ft.add(R.id.frag_container, new FragRandom());
        ft.addToBackStack(null);

        ft.commit();

    }

    /**
     *  remove current attached fragment and add new one
     *  with animation
     */
    private void replaceNewFragmentWithAnimation() {

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.setCustomAnimations(
                R.anim.slide_in_to_left,
                R.anim.slide_out_to_left,
                R.anim.slide_in_to_right,
                R.anim.slide_out_to_right
        );

        ft.replace(R.id.frag_container, new FragRandom());
        ft.addToBackStack(null);

        ft.commit();

    }

    /**
     *  remove current attached fragment and add new one
     *  with animation;
     *  also takes into account onDestroyView() and onCreateView()
     */
    private void replaceNewFragmentWithAnimationAndRemember() {

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.setCustomAnimations(
                R.anim.slide_in_to_left,
                R.anim.slide_out_to_left,
                R.anim.slide_in_to_right,
                R.anim.slide_out_to_right
        );

        ft.replace(R.id.frag_container, new FragRandomRemember());
        ft.addToBackStack(null);

        ft.commit();

    }

}
