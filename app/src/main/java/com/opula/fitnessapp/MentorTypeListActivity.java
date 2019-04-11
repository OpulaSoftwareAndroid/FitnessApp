package com.opula.fitnessapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.opula.fitnessapp.Adapter.MentorTypeListAdapter;
import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.Crude.SharedPreference;
import com.opula.fitnessapp.POJOClasses.MentorListModel.Info;
import com.opula.fitnessapp.POJOClasses.MentorListModel.MentorMemberList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MentorTypeListActivity extends AppCompatActivity {

    @BindView(R.id.lvMentor)
    ListView lvMentor;

    TextView tvMentorName;
    MentorTypeListAdapter adapter;

    SharedPreference sharedPreference;
    String strRegisterID;
    String TAG = "MentorSubTypeListActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_list);

        ButterKnife.bind(this);



        adapter = new MentorTypeListAdapter(this);
        lvMentor.setAdapter(adapter);



//
//        ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
//        Sprite doubleBounce = new DoubleBounce();
//        progressBar.setIndeterminateDrawable(doubleBounce);
//        progressBar.getProgress();






        getMentorTypeList();
    }



    private void getMentorTypeList() {
//        String strRegisterID = sharedPreference.getValue(MentorSubTypeListActivity.this, Constants.STORED_REGISTER_ID);
        strRegisterID = "85475825";


        if (AppGlobal.isNetwork(this)) {

            Map<String, String> optioMap = new HashMap<>();
            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_TYPE, "1");

            new RestClient(this).getInstance().get().GetMentorList(optioMap).enqueue(new Callback<MentorMemberList>(){
                @Override
                public void onResponse(Call<MentorMemberList> call, Response<MentorMemberList> response) {

                    if (response.body() != null) {

                        if (response.body().getStatus() == 1) {
                            adapter.addAll((ArrayList<Info>) response.body().getInfo());
                        }


                        Log.d(TAG, "android the response we get user detail by id  is " + new Gson().toJson(response));


                        if (response.body().getStatus() == 1) {
                            Toast.makeText(MentorTypeListActivity.this, "" + response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(MentorTypeListActivity.this,"",Toast.LENGTH_LONG).show();
                        }


                    }
                }




                @Override
                public void onFailure(Call<MentorMemberList> call, Throwable t) {

                }
//                @Override
//                public void onResponse(Call<getMentorTypeList> call, Response<getMentorTypeList> response)


            });

        }

    }

}


