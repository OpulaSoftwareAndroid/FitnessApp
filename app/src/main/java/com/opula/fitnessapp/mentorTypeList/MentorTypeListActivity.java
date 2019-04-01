package com.opula.fitnessapp.mentorTypeList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.Crude.SharedPreference;
import com.opula.fitnessapp.POJOClasses.MentorTypeListModel.Info;
import com.opula.fitnessapp.POJOClasses.MentorTypeListModel.MentorTypeList;
import com.opula.fitnessapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MentorTypeListActivity extends AppCompatActivity {

    @BindView(R.id.lvMentorType)
    ListView lvMentorType;

    @BindView(R.id.tvHeaderTitle)
    TextView tvHeaderTitle;


    SharedPreference sharedPreference;
    String strRegisterID;
    String TAG = "MentorTypeListActivity";

    MentorTypeListAdapter adapter;

    String mentorTypeID;
    String mentorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_type_list);

        try {
            ButterKnife.bind(this);
            mentorTypeID = getIntent().getStringExtra("mentorTypeID");
            mentorName = getIntent().getStringExtra("mentorName");

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


            callAPIGetMentorTypeList();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        try {


            tvHeaderTitle.setText(mentorName);

            adapter = new MentorTypeListAdapter(this);
            lvMentorType.setAdapter(adapter);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void callAPIGetMentorTypeList() {
//        String strRegisterID = sharedPreference.getValue(MentorListActivity.this, Constants.STORED_REGISTER_ID);
        strRegisterID = "85475825";


        if (AppGlobal.isNetwork(this)) {

            Map<String, String> optioMap = new HashMap<>();
            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_MENTOR_TYPE, mentorTypeID);
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_TYPE, "1");

            new RestClient(this).getInstance().get().getMentorTypeList(optioMap).enqueue(new Callback<MentorTypeList>() {
                @Override
                public void onResponse(Call<MentorTypeList> call, Response<MentorTypeList> response) {

                    if (response.body() != null) {

                        if (response.body().getStatus() == 1) {
                            adapter.addAll((ArrayList<Info>) response.body().getInfo());
                        }


//                        Log.d(TAG, "Jignesh the response we get user detail by id  is " + new Gson().toJson(response));


                        if (response.body().getStatus() == 1) {
                            Toast.makeText(MentorTypeListActivity.this, "" + response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<MentorTypeList> call, Throwable t) {
                }
            });
        }
    }
}
