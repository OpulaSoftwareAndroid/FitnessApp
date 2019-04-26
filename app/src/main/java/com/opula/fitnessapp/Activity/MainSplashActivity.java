package com.opula.fitnessapp.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.SharedPreference;
import com.opula.fitnessapp.MainLoginActivity;
import com.opula.fitnessapp.R;

public class MainSplashActivity extends AppCompatActivity {

    public static int REQUEST_CAMERA = 101;
    private SharedPreference sharedPreference;
    String version = "";
    String TAG="Splash";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_splash);
        sharedPreference = new SharedPreference();


        if (ActivityCompat.checkSelfPermission(MainSplashActivity.this, android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(MainSplashActivity.this, android.Manifest.permission.ACCESS_NETWORK_STATE)
                        != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(MainSplashActivity.this, android.Manifest.permission.ACCESS_WIFI_STATE)
                        != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(MainSplashActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(MainSplashActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                requestPermissions(new String[]{android.Manifest.permission.CAMERA,
                        android.Manifest.permission.ACCESS_NETWORK_STATE,
                        android.Manifest.permission.ACCESS_WIFI_STATE, android.Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CAMERA);
            }
        }

        initView();
//        else {
//       //     getvirsion();
//        }
    }
    private void getPermission() {
        if (ActivityCompat.checkSelfPermission(MainSplashActivity.this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(MainSplashActivity.this, Manifest.permission.ACCESS_NETWORK_STATE)
                        != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(MainSplashActivity.this, Manifest.permission.ACCESS_WIFI_STATE)
                        != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(MainSplashActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(MainSplashActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                requestPermissions(new String[]{Manifest.permission.CAMERA,
                        Manifest.permission.ACCESS_NETWORK_STATE,
                        Manifest.permission.ACCESS_WIFI_STATE,Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CAMERA);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CAMERA) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[2] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[3] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[4] == PackageManager.PERMISSION_GRANTED) {
               // getvirsion();

            } else {
                getPermission();
            }
        }
    }

    public void initView()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String strRegisterID = sharedPreference.getValue(MainSplashActivity.this, Constants.STORED_REGISTER_ID);

                Log.d(TAG,"jigar the stored register id we  have is "+strRegisterID);
                if (strRegisterID == null || strRegisterID.equalsIgnoreCase("0")) {
                    Intent i = new Intent(MainSplashActivity.this, MainLoginActivity.class);
                    startActivity(i);
                    finish();
                }else
                {
                    Intent i = new Intent(MainSplashActivity.this, MainHomeScreenActivity.class);
                    startActivity(i);
                    finish();

                }
//                else {
//
//                }
//
            }

        }, 1500);
    }
}
