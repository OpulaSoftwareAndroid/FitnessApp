package com.opula.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.Crude.SharedPreference;
import com.opula.fitnessapp.POJOClasses.UserDetailsModel.UserDetailPOJO;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;

public class MainLoginActivity extends AppCompatActivity {

    EditText editTextMobileNumber,editTextPassword;
    Button btnSubmit;
    String strMobileNumber,strPassword;
    String TAG="MainLoginActivity";
    SharedPreference sharedPreference;
    TextView textViewNewUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        editTextMobileNumber =findViewById(R.id.editTextMobileNumber);
        editTextPassword=findViewById(R.id.editTextPassword);
        btnSubmit=findViewById(R.id.btnSubmit);
        sharedPreference=new SharedPreference();
        textViewNewUser=findViewById(R.id.textViewNewUser);
        textViewNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainLoginActivity.this,MainRegistrationActivity.class);
                startActivity(intent);
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editTextMobileNumber.getText().toString().equals(""))
                {
                    editTextMobileNumber.setError("Please Enter Valid Phone Number");
                }else if(editTextPassword.getText().toString().equals(""))
                {
                    editTextPassword.setError("Please Enter Valid Password");

                }else
                {
                    strPassword=editTextPassword.getText().toString();
                    strMobileNumber= editTextMobileNumber.getText().toString();
                    setSignInUser();
                }

            }
        });
    }
    public void setSignInUser()
    {
        AppGlobal.showProgressDialog(this);
        StringRequest req = new StringRequest(Request.Method.POST, Constants.API_USER_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String res) {
                        try {
                            Log.v(TAG, "jigar the response user login " + res);


                            JSONObject response = new JSONObject(res);

//                            {"status":1,"msg":"Successfully Registered.","info":21933002}
                            String strMessage = response.getString(Constants.TAG_MSG);
                            AppGlobal.hideProgressDialog(MainLoginActivity.this);
                            String strStatus=response.getString(Constants.TAG_STATUS);
                            if(strStatus.equals("1")) {

                                JSONObject jsonObjectInfo=response.getJSONObject(Constants.TAG_INFO);

                                String strRegisterId=jsonObjectInfo.getString(Constants.TAG_REGISTER_ID);
                                sharedPreference.save(getApplicationContext(),strRegisterId,Constants.STORED_REGISTER_ID);
                                Intent intent=new Intent(MainLoginActivity.this,MainHomeScreenActivity.class);
                                startActivity(intent);
                                finish();
                                Toast.makeText(MainLoginActivity.this,strMessage,Toast.LENGTH_LONG).show();
                            }else
                            {
                                Toast.makeText(MainLoginActivity.this,strMessage,Toast.LENGTH_LONG).show();
                            }



                        } catch (JSONException e) {
                            AppGlobal.hideProgressDialog(MainLoginActivity.this);

                            Log.v(TAG, "jigar the json error user login " + e);

                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            AppGlobal.hideProgressDialog(MainLoginActivity.this);

                            Log.v(TAG, "jigar the null pointer user register " + e);

                            e.printStackTrace();
                        } catch (Exception e) {
                            AppGlobal.hideProgressDialog(MainLoginActivity.this);

                            Log.v(TAG, "jigar the exception in user register " + e);

                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Log.v(TAG, "jigar the volley error user login " + error);
                AppGlobal.hideProgressDialog(MainLoginActivity.this);

            }


        }) {


//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> map = new HashMap<String, String>();
////                strDOB = editTextDOB.getText().toString();
////                strMobileNumber = editTextMobileNumber.getText().toString();
////                strUserName = editTextMobileNumber.getText().toString();
////                strPassword = editTextPassword.getText().toString();
////                strConfirmPassword = editTextConfirmPassword.getText().toString();
////                strEmailID = editTextEmailID.getText().toString();
////                //    strUserWeight=  editTextUserWeight.getText().toString();
////                //      strEmailID=  editTextEmailID.getText().toString();
////                strUserWeight = editTextUserWeight.getText().toString();
////                strUserHeight = editTextUserHeight.getText().toString();
////                strMedicalCondition = editTextMedicalCondition.getText().toString();
////                strDailyActivity = editTextDailyActivity.getText().toString();
//                map.put(Constants.TAG_NAME, strUserName);
//                map.put(Constants.TAG_EMAIL_ID, strEmailID);
//                map.put(Constants.TAG_GENDER, strGender);
//                map.put(Constants.TAG_MOBILE_NO, "" + strMobileNumber);
//                map.put(Constants.TAG_DOB, "" + strDOB);
//                map.put(Constants.TAG_PASSWORD, "" + strPassword);
//                map.put(Constants.TAG_WEIGHT, "" + strUserWeight);
//                map.put(Constants.TAG_HEIGHT, "" + strUserHeight);
//                map.put(Constants.TAG_WORKOUT_START_TIME, "" + strWorkoutStartTime);
//                map.put(Constants.TAG_WORKOUT_END_TIME, "" + strWorkoutEndTime);
//                map.put(Constants.TAG_REST_START_TIME, "" + strRestStartTime);
//                map.put(Constants.TAG_REST_END_TIME, "" + strRestEndTime);
//                map.put(Constants.TAG_MEDICAL_CONDITION, "" + strMedicalCondition);
//                map.put(Constants.TAG_DAILY_ACTIVITY, "" + strDailyActivity);
//                map.put(Constants.TAG_VALID_DATA, "AjsEFhsjcnshsuj@kjmjkmrtghy8rr");
//                map.put(Constants.TAG_TYPE, "1");
//                Log.v(TAG, "jigar the set user register params=" + map);
//                return map;
////                "Name" : "Kevin Dhimmar",
////                        "Gender" : "Male",
////                        "MobileNo" : "123456789111",
////                        "DOB" : "06-02-1996",
////                        "Password" : "12345678",
////                        "Weigth" : "50",
////                        "EmailID"
////                "Heigth" : "5",
////                        "WorkoutStartTime" : "05:02:02",
////                        "WorkoutEndTime" : "05:02:02",
////                        "StartRestTime" : "05:02:02",
////                        "EndRestTime" : "05:02:02",
////                        "MedicalCondition" : "No",
////                        "DailyActivity" : "Travelling",
////                        "ValidData":"AjsEFhsjcnshsuj@kjmjkmrtghy8rr",
////                        "Type":"1"
//            }

            @Override
            public byte[] getBody() throws com.android.volley.AuthFailureError {
                String strValidData="AjsEFhsjcnshsuj@kjmjkmrtghy8rr";
                String str = "{" +
                        "\""+Constants.TAG_MOBILE_NO+"\" : \""+strMobileNumber+"\",\"" +
                        ""+Constants.TAG_PASSWORD+"\" : \""+strPassword+"\",\"" +
                        ""+Constants.TAG_VALID_DATA+"\" : \""+strValidData+"\",\"" +
                        ""+Constants.TAG_TYPE+"\" : \"1\"" +"}";
                Log.v(TAG, "jigar the user login params=" + str);

                return str.getBytes();
            };

            public String getBodyContentType()
            {
                return "application/json; charset=utf-8";
            }


        };

        Fitness_Application.getInstance().addToRequestQueue(req, TAG);

    }


    public static class MainHomeScreenActivity extends AppCompatActivity {

        @BindView(R.id.btnMentor)
        Button btnMentor;

        Button btnRegisterUser,btnViewProfile,btnLogout,btnSelectDietPlan,btnViewSubscriptionPlan;
        SharedPreference sharedPreference;
        String strRegisterID;
        String TAG = "MainHomeScreenActivity";
        LinearLayout linearLayoutSelectDietPlan;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_home_screen);

            ButterKnife.bind(this);

            sharedPreference = new SharedPreference();
            strRegisterID = sharedPreference.getValue(this, Constants.STORED_REGISTER_ID);
            btnSelectDietPlan=findViewById(R.id.btnSelectDietPlan);
            btnSelectDietPlan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainHomeScreenActivity.this, MainDietPlanActivity.class);
                    startActivity(intent);

                }
            });

            btnViewSubscriptionPlan=findViewById(R.id.btnViewSubscriptionPlan);
            btnViewSubscriptionPlan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 //   Intent intent = new Intent(MainHomeScreenActivity.this, MainSubscriptionType.class);
                 //   startActivity(intent);

                }
            });


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
                Intent intent = new Intent(MainHomeScreenActivity.this, MentorTypeListActivity.class);
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
                    public void onResponse(Call<UserDetailPOJO> call, retrofit2.Response<UserDetailPOJO> response) {

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
}
