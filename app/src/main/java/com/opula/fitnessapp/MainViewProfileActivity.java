package com.opula.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.opula.fitnessapp.Activity.MainCountDownTimerActivity;
import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.Crude.SharedPreference;
import com.opula.fitnessapp.POJOClasses.UserDetailsModel.UserDetailPOJO;
import com.opula.fitnessapp.CustomClass.CustomTextView;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;

public class MainViewProfileActivity extends AppCompatActivity {

    String strMobileNumber,strPassword;
    String TAG="MainLoginActivity";
    Button btnNext;
    CircleImageView circleImageViewProfileImage;
    SharedPreference sharedPreference;
    CustomTextView customTextViewUserName,customTextViewHeight,customTextViewWeight,customTextViewBMR
            ,customTextViewBMI,customTextViewIBW,customTextViewBirthDate;
    ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        sharedPreference = new SharedPreference();

        customTextViewUserName=findViewById(R.id.customTextViewUserName);
        customTextViewHeight=findViewById(R.id.customTextViewHeight);
        customTextViewWeight=findViewById(R.id.customTextViewWeight);
        customTextViewBMR=findViewById(R.id.customTextViewBMR);
        customTextViewBMI=findViewById(R.id.customTextViewBMI);
        customTextViewIBW=findViewById(R.id.customTextViewIBW);
        customTextViewBirthDate=findViewById(R.id.customTextViewBirthDate);
        circleImageViewProfileImage=findViewById(R.id.circleImageViewProfileImage);
//        circleImageViewProfileImage.setImageDrawable(R.drawable.user_default_image_boy);
        btnNext=findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainViewProfileActivity.this, MainMealTypeListActivity.class);
                startActivity(intent);
            }
        });
        getUserDetailsByID();
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
                            AppGlobal.hideProgressDialog(MainViewProfileActivity.this);
                            String strStatus=response.getString(Constants.TAG_STATUS);
                            if(strStatus.equals("1")) {

                                JSONObject jsonObjectInfo=response.getJSONObject(Constants.TAG_INFO);

                                String strRegisterId=jsonObjectInfo.getString(Constants.TAG_REGISTER_ID);
                                sharedPreference.save(getApplicationContext(),strRegisterId,Constants.STORED_REGISTER_ID);
                                Intent intent=new Intent(MainViewProfileActivity.this, MainCountDownTimerActivity.class);
                                startActivity(intent);
                                finish();
//                                Toast.makeText(MainViewProfileActivity.this,strMessage,Toast.LENGTH_LONG).show();
                            }else
                            {
                                Toast.makeText(MainViewProfileActivity.this,strMessage,Toast.LENGTH_LONG).show();
                            }



                        } catch (JSONException e) {
                            AppGlobal.hideProgressDialog(MainViewProfileActivity.this);

                            Log.v(TAG, "jigar the json error user login " + e);

                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            AppGlobal.hideProgressDialog(MainViewProfileActivity.this);

                            Log.v(TAG, "jigar the null pointer user register " + e);

                            e.printStackTrace();
                        } catch (Exception e) {
                            AppGlobal.hideProgressDialog(MainViewProfileActivity.this);

                            Log.v(TAG, "jigar the exception in user register " + e);

                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Log.v(TAG, "jigar the volley error user login " + error);
                AppGlobal.hideProgressDialog(MainViewProfileActivity.this);

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

        FitnessApplication.getInstance().addToRequestQueue(req, TAG);

    }

    private void getUserDetailsByID() {

        String strRegisterID = sharedPreference.getValue(MainViewProfileActivity.this, Constants.STORED_REGISTER_ID);

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
                            customTextViewUserName.setText(response.body().getInfo().getFullName());
                            customTextViewHeight.setText(response.body().getInfo().getHeigth()+" ");
                            customTextViewWeight.setText(response.body().getInfo().getWeigth()+" ");
                            customTextViewBirthDate.setText(response.body().getInfo().getDOB());
                            Toast.makeText(MainViewProfileActivity.this, "" + response.body().getMsg(), Toast.LENGTH_SHORT).show();

                            Picasso.with(getApplicationContext()).load(R.drawable.user_default_image_boy).into(circleImageViewProfileImage);

//                            android:src="@drawable/user_default_image_boy"

//                            if(response.body().getInfo().getProfilePicture().equals(null))
//                            {
//
//                            }else {
//                                Picasso.get().load(response.body().getInfo().getProfilePicture()).into(circleImageViewProfileImage);
//                            }
                            String strUserWeight=response.body().getInfo().getWeigth();
                            String strUserHeight=response.body().getInfo().getHeigth();

                            String IBW="";
                            if(response.body().getInfo().getGender().equals("Male"))
                            {
                                 IBW= String.valueOf(Float.parseFloat(strUserHeight)-100);

                            }else
                            {
                                 IBW= String.valueOf(Float.parseFloat(strUserHeight)-105);

                            }
                            String BMR=String.valueOf(Float.parseFloat(strUserWeight)*(2.2)*(11));
                            if(BMR.length()>8) {
                                BMR = BMR.substring(0, 7);
                            }
                            String BMI=String.valueOf(Float.parseFloat(strUserWeight)/(Float.parseFloat(strUserHeight))
                                    *(Float.parseFloat(strUserHeight)));

//                            BMR - Weight*(2.2)*(11)
//    BMI - Weight(kg) / (height in cm)*(height in cm)
//    IBW (for men) - (height in cm) - 100
//    IBW (for women) - (height in cm) - 105

                            customTextViewBMR.setText(BMR);
                            customTextViewBMI.setText(BMI);
                            customTextViewIBW.setText(IBW);

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
