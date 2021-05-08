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

public class Movie extends AppCompatActivity {
    private CardView movietheater_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        movietheater_btn = findViewById(R.id.movietheater);

        movietheater_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_movietheater();
            }
        });

    }

    public void open_movietheater() {
        if (!isconnected(this)) {

            Intent intent = new Intent(this, No_internet.class);
            startActivity(intent);
        } else {
            StartAppAd.showAd(this);

            Intent intent = new Intent(this, Movietheater.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(Movie sust) {

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