package com.sunit.onlineticketbd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.startapp.sdk.adsbase.StartAppAd;

public class Train extends AppCompatActivity {
    private CardView rail_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);
        rail_btn = findViewById(R.id.rail);

        rail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_rail();
            }
        });

    }

    public void open_rail() {
        if (!isconnected(this)) {

            Intent intent = new Intent(this, No_internet.class);
            startActivity(intent);
        } else {
            StartAppAd.showAd(this);

            goToUrl ( "https://www.esheba.cnsbd.com/#/");
        }
    }

    private boolean isconnected(Train sust) {

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

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    @Override
    public void onBackPressed () {
        super.onBackPressed();
        this.finish();
    }
}