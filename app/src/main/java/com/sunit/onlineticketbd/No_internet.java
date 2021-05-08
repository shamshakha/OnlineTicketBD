package com.sunit.onlineticketbd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class No_internet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);
    }

    @Override
    public void onBackPressed () {
        super.onBackPressed();
        this.finish();
    }

}