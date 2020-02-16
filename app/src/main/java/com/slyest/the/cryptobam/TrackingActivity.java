package com.slyest.the.cryptobam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.slyest.the.cryptobam.tracking.Tracker;

public class TrackingActivity extends AppCompatActivity {

    protected Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);

        mTracker = new Tracker(this);
    }
}
