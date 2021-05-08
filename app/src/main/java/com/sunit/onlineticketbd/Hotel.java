package com.sunit.onlineticketbd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;

import com.startapp.sdk.adsbase.StartAppAd;

public class Hotel extends AppCompatActivity {
    private CardView hotelbooking_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        hotelbooking_btn = findViewById(R.id.hotelbooking);

        hotelbooking_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_hotelbooking();
            }
        });

    }

    public void open_hotelbooking() {
        if (!isconnected(this)) {

            Intent intent = new Intent(this, No_internet.class);
            startActivity(intent);
        } else {
            StartAppAd.showAd(this);

            Intent intent = new Intent(this, Hotelbooking.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(Hotel sust) {

        ConnectivityManager connectivityManager=(ConnectivityManager)sust.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wificon=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobilecon=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if(( wificon!=null && wificon.isConnected() ) || (mobilecon!=null && mobilecon.isConnected()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @Override
    public void onBackPressed () {
        super.onBackPressed();
        this.finish();
    }
}