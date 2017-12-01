package com.example.hodeozshopping2.shopping2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TinderActivity extends AppCompatActivity {

    private int e1, e2, e3, e4, e5, e6, e7, e8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinder);

        Intent mIntent = getIntent();
        e1 = mIntent.getIntExtra("e1", e1);
        e2 = mIntent.getIntExtra("e2", e2);
        e3 = mIntent.getIntExtra("e3", e3);
        e4 = mIntent.getIntExtra("e4", e4);
        e5 = mIntent.getIntExtra("e5", e5);
        e6 = mIntent.getIntExtra("e6", e6);
        e7 = mIntent.getIntExtra("e7", e7);
        e8 = mIntent.getIntExtra("e8", e8);


        TinderDinnerFragment tinderDinnerFragment = new TinderDinnerFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("e1", e1);
        bundle.putInt("e2", e2);
        bundle.putInt("e3", e3);
        bundle.putInt("e4", e4);
        bundle.putInt("e5", e5);
        bundle.putInt("e6", e6);
        bundle.putInt("e7", e7);
        bundle.putInt("e8", e8);
        tinderDinnerFragment.setArguments(bundle);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.container, tinderDinnerFragment)
        //.add(R.id.container, tinderDinnerFragment)
          .addToBackStack(null)
          .commit();


        FragmentManager fm2 = getFragmentManager();
        FragmentTransaction ft2 = fm2.beginTransaction();

        TongueFragment tongueFragment = new TongueFragment();

        ft2.add(R.id.containerTongue, tongueFragment)
          .addToBackStack("")
          .commit();
    }
}
