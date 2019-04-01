package com.opula.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.Crude.SharedPreference;
import com.opula.fitnessapp.POJOClasses.UserDetailsModel.UserDetailPOJO;
import com.opula.fitnessapp.mentorListScreen.MentorListActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainHomeScreenActivity extends AppCompatActivity {

    @BindView(R.id.btnMentor)
    Button btnMentor;

    Button btnRegisterUser,btnViewProfile,btnLogout;
    SharedPreference sharedPreference;
    String strRegisterID;
    String TAG = "MainHomeScreenActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home_screen);

        ButterKnife.bind(this);

        sharedPreference = new SharedPreference();
        strRegisterID = sharedPreference.getValue(this, Constants.STORED_REGISTER_ID);

        btnRegisterUser = findViewById(R.id.btnRegisterUser);
        btnLogout = findViewById(R.id.btnLogout);

        btnViewProfile=findViewById(R.id.btnViewProfile);
        btnViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainHomeScreenActivity.this, MainViewProfileActivity.class);
                startActivity(intent);

            }
        });
        btnRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainHomeScreenActivity.this, MainRegistrationActivity.class);
                startActivity(intent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainHomeScreenActivity.this, MainLoginActivity.class);
                sharedPreference.removeValue(MainHomeScreenActivity.this,Constants.STORED_REGISTER_ID);
                startActivity(intent);
            }
        });

//        ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
//        Sprite doubleBounce = new DoubleBounce();
//        progressBar.setIndeterminateDrawable(doubleBounce);
//        progressBar.getProgress();
        getUserDetailsByID();
    }

    @OnClick(R.id.btnMentor)
    public void onClickDietPlan() {
        try {
            Intent intent = new Intent(MainHomeScreenActivity.this, MentorListActivity.class);
            startActivity(intent);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void getUserDetailsByID() {
        String strRegisterID = sharedPreference.getValue(MainHomeScreenActivity.this, Constants.STORED_REGISTER_ID);

        if (AppGlobal.isNetwork(this)) {

            Map<String, String> optioMap = new HashMap<>();
            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_TYPE, "1");

            new RestClient(this).getInstance().get().getUserDetailByID(optioMap).enqueue(new Callback<UserDetailPOJO>() {
                @Override
                public void onResponse(Call<UserDetailPOJO> call, Response<UserDetailPOJO> response) {

                    if (response.body() != null) {
                        Log.d(TAG, "jigar the response we get user detail by id  is " + new Gson().toJson(response));


                        if (response.body().getStatus() == 1) {
                            Toast.makeText(MainHomeScreenActivity.this, "" + response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<UserDetailPOJO> call, Throwable t) {
                }
            });
        }
    }
}
