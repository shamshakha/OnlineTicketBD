package com.sunit.onlineticketbd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    @Override
    public void onBackPressed () {
        super.onBackPressed();
        this.finish();
    }

}