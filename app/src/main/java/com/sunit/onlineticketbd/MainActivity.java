package com.sunit.onlineticketbd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;


public class MainActivity extends AppCompatActivity {
    private CardView bus_btn;
    private CardView train_btn;
    private CardView launch_btn;
    private CardView plane_btn;
    private CardView hotel_btn;
    private CardView movie_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bus_btn = findViewById(R.id.bus);
        train_btn = findViewById(R.id.train);
        launch_btn = findViewById(R.id.launch);
        plane_btn = findViewById(R.id.plane);
        hotel_btn = findViewById(R.id.hotel);
        movie_btn = findViewById(R.id.movie);

        StartAppSDK.init(MainActivity.this, "201963835\t", false);


        bus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_bus();
            }
        });

        train_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_train();
            }
        });

        launch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_launch();
            }
        });

        plane_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_plane();
            }
        });

        hotel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_hotel();
            }
        });

        movie_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_movie();
            }
        });
    }

        public void open_bus() {
            StartAppAd.showAd(this);

                Intent intent = new Intent(this, Bus.class);
                startActivity(intent);

        }

        public void open_train() {
                StartAppAd.showAd(this);

                Intent intent = new Intent(this, Train.class);
                startActivity(intent);
        }

        public void open_launch() {
                StartAppAd.showAd(this);

                Intent intent = new Intent(this, Launch.class);
                startActivity(intent);

        }

        public void open_plane() {
                StartAppAd.showAd(this);

                Intent intent = new Intent(this, Plane.class);
                startActivity(intent);
        }

        public void open_hotel() {
                StartAppAd.showAd(this);

                Intent intent = new Intent(this, Hotel.class);
                startActivity(intent);
        }

        public void open_movie() {

                StartAppAd.showAd(this);

                Intent intent = new Intent(this, Movie.class);
                startActivity(intent);
            }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.title1){
            Intent intent = new Intent(this, Contact.class);
            startActivity(intent);

        }

        if(id==R.id.title2){
            Uri uri= Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());

            if(!isconnected(this))
            {
                Intent intent=new Intent(this,No_internet.class);
                startActivity(intent);
            }
            else {
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        }

        if(id==R.id.title3){
            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String shareMessage= "\nLet me recommend you this application\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "Share with"));
            } catch(Exception e) {
                Toast.makeText(MainActivity.this,"Can not Share an error occured",Toast.LENGTH_LONG).show();
            }
        }

        return super.onOptionsItemSelected(item);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private boolean isconnected(MainActivity sust) {

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
    }
