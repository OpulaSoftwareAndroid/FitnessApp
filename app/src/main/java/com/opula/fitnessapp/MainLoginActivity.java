package com.opula.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.opula.fitnessapp.Activity.MainHomeScreenActivity;
import com.opula.fitnessapp.Activity.MainRegistrationActivity;
import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.SharedPreference;

import org.json.JSONException;
import org.json.JSONObject;

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
                Intent intent=new Intent(MainLoginActivity.this, MainRegistrationActivity.class);
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
                                Intent intent=new Intent(MainLoginActivity.this, MainHomeScreenActivity.class);
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



}
