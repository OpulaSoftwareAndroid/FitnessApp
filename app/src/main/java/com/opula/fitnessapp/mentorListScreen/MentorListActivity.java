package com.opula.fitnessapp.mentorListScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.Crude.SharedPreference;
import com.opula.fitnessapp.POJOClasses.MentorListModel.Info;
import com.opula.fitnessapp.POJOClasses.MentorListModel.MentorList;
import com.opula.fitnessapp.R;
import com.opula.fitnessapp.mentorTypeList.MentorTypeListActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MentorListActivity extends AppCompatActivity {

    @BindView(R.id.lvMentor)
    ListView lvMentor;

    SharedPreference sharedPreference;
    String strRegisterID;
    String TAG = "MentorListActivity";

    MentorListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_list);

        ButterKnife.bind(this);

//        sharedPreference = new SharedPreference();
//        strRegisterID = sharedPreference.getValue(this, Constants.STORED_REGISTER_ID);
//
//        btnRegisterUser = findViewById(R.id.btnRegisterUser);
//        btnRegisterUser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MentorListActivity.this, MainRegistrationActivity.class);
//                startActivity(intent);
//            }
//        });

//        ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
//        Sprite doubleBounce = new DoubleBounce();
//        progressBar.setIndeterminateDrawable(doubleBounce);
//        progressBar.getProgress();

        initView();


        callAPIGetMentorList();
    }

    private void initView() {
        try {

            adapter = new MentorListAdapter(this);
            lvMentor.setAdapter(adapter);

            lvMentor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MentorListActivity.this, MentorTypeListActivity.class);
                    intent.putExtra("mentorTypeID", adapter.getItem(position).getMentorID());
                    intent.putExtra("mentorName", adapter.getItem(position).getName());
                    startActivity(intent);

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void callAPIGetMentorList() {
//        String strRegisterID = sharedPreference.getValue(MentorListActivity.this, Constants.STORED_REGISTER_ID);
        strRegisterID = "85475825";


        if (AppGlobal.isNetwork(this)) {

            Map<String, String> optioMap = new HashMap<>();
            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_TYPE, "1");

            new RestClient(this).getInstance().get().getMentorList(optioMap).enqueue(new Callback<MentorList>() {
                @Override
                public void onResponse(Call<MentorList> call, Response<MentorList> response) {

                    if (response.body() != null) {

                        if (response.body().getStatus() == 1) {
                            adapter.addAll((ArrayList<Info>) response.body().getInfo());
                        }


//                        Log.d(TAG, "Jignesh the response we get user detail by id  is " + new Gson().toJson(response));


                        if (response.body().getStatus() == 1) {
                            Toast.makeText(MentorListActivity.this, "" + response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<MentorList> call, Throwable t) {
                }
            });
        }
    }
}
