package com.krypto.blocks.warranty;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.krypto.blocks.warranty.fragments.ExpiredFragment;

public class ExpiredActivity extends AppCompatActivity {

    public void ExpiredFragment() {

        ExpiredFragment expiredFragment= new ExpiredFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, expiredFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expired);
        ExpiredFragment();
    }
}
