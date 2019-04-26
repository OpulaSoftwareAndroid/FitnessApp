package com.opula.fitnessapp.Activity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.SharedPreference;
import com.opula.fitnessapp.FitnessApplication;
import com.opula.fitnessapp.MainLoginActivity;
import com.opula.fitnessapp.MainViewProfileActivity;
import com.opula.fitnessapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainRegistrationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner,spinnerWeight,spinnerHeight,spinnerInch;


    EditText editTextDOB, editTextMobileNumber, editTextUserName, editTextPassword
            ,editTextConfirmPassword,editTextEmailID
            ,editTextDailyActivity,conditiontext;


    EditText edit;
    TextView txtKG;

    Button btnWorkoutStartTime, btnWorkoutEndTime
            , btnRestStartTime, btnRestEndTime,btnSubmit;
    String TAG="MainRegistrationActivity";
    String strDOB,strMobileNumber,strUserName,strPassword,strConfirmPassword,strEmailID,strUserWeight,strUserHeight
            ,strMedicalCondition,strDailyActivity,strWorkoutStartTime,strWorkoutEndTime
            ,strRestStartTime,strRestEndTime;
    RadioButton radioButtonMale,radioButtonFemale;
    RadioGroup radioGroupGender;
    String strGender;

    SharedPreference sharedPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_main);
        getWindow().setBackgroundDrawableResource(R.drawable.fitness_background);





//      spinner condition....




        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        final List<String>  categories = new ArrayList<String>();
        categories.add("Medical Condition");
        categories.add("Other");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);


//        spinner.setAdapter(dataAdapter);



        spinnerWeight = (Spinner)findViewById(R.id.spinnerWeight);
        spinnerWeight.setOnItemSelectedListener(this);
        List<String> Weight = new ArrayList<String>();
        Weight.add("40");
        Weight.add("50");
        Weight.add("55");
        Weight.add("60");
        Weight.add("70");
        Weight.add("78");
        Weight.add("80");
        Weight.add("90");
        Weight.add("100");
        Weight.add("120");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Weight);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWeight.setAdapter(dataAdapter1);







//      spinner height....

        spinnerHeight = (Spinner)findViewById(R.id.spinnerHeight);
        spinnerHeight.setOnItemSelectedListener(this);
        List<String> Height = new ArrayList<String>();
        Height.add("c.m");
        Height.add("inch");


        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Height);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHeight.setAdapter(dataAdapter2);


        spinnerInch = (Spinner)findViewById(R.id.spinnerInch);
        spinnerInch.setOnItemSelectedListener(this);
        List<String> inch = new ArrayList<String>();
        inch.add("4.5");
        inch.add("5.5");
        inch.add("5.4");
        inch.add("5.4");
        inch.add("5.7");
        inch.add("6.2");

        ArrayAdapter<String> dataAdapterA = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, inch);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInch.setAdapter(dataAdapterA);

        spinnerInch.setVisibility(View.VISIBLE);






        setEnable();



        conditiontext = (EditText)findViewById(R.id.conditiontext);

        editTextDOB=findViewById(R.id.editTextBirthDate);
        editTextMobileNumber=findViewById(R.id.editTextMobileNumber);
        editTextUserName=findViewById(R.id.editTextUserName);
        editTextPassword=findViewById(R.id.editTextPassword);
        editTextConfirmPassword=findViewById(R.id.editTextConfirmPassword);
        editTextEmailID=findViewById(R.id.editTextEmailID);

        editTextEmailID=findViewById(R.id.editTextEmailID);

        editTextDailyActivity=findViewById(R.id.editTextDailyActivity);
        sharedPreference=new SharedPreference();

        radioButtonFemale=findViewById(R.id.radioFemale);
        radioButtonMale=findViewById(R.id.radioMale);
        radioGroupGender=findViewById(R.id.radioSex);

        btnWorkoutStartTime =findViewById(R.id.btnWorkoutStartTime);
        btnWorkoutEndTime =findViewById(R.id.btnWorkoutEndTime);
        btnRestStartTime =findViewById(R.id.btnRestStartTime);
        btnRestEndTime =findViewById(R.id.btnRestEndTime);
        btnSubmit =findViewById(R.id.btnSubmit);







        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent homeIntent = new Intent(MainRegistrationActivity.this, MainHomeScreenActivity.class);
                startActivity(homeIntent);


                if(editTextDOB.getText().toString().equals(""))
                {
                    editTextDOB.setError("Please Enter Date Of Birth");
                }else if(editTextMobileNumber.getText().toString().equals(""))
                {
                    editTextMobileNumber.setError("Please Enter Valid Phone Number");

                }else if(editTextUserName.getText().toString().equals(""))
                {
                    editTextUserName.setError("Please Enter Valid User Name");

                }else if(editTextPassword.getText().toString().equals(""))
                {
                    editTextPassword.setError("Please Enter Valid Password");

                }else if(editTextConfirmPassword.getText().toString().equals(""))
                {
                    editTextConfirmPassword.setError("Please Enter Valid Confirm Password");
                }
                else if(!editTextConfirmPassword.getText().toString().equals(editTextPassword.getText().toString()))
                {
                    editTextConfirmPassword.setError("Password and Confirm Password Should be same");
                    editTextConfirmPassword.requestFocus();
                }
                else if(editTextEmailID.getText().toString().equals(""))
                {
                    editTextEmailID.setError("Please Enter Valid Email ID");
                }
//                else if(spinnerWeight.toString().equals(""))
//                {
//                    spinnerWeight.setError("Please Enter Valid Weight");
//                }
//
//                else if(editTextUserHeight.getText().toString().equals(""))
//                {
//                    editTextUserHeight.setError("Please Enter Valid Height");
//                }
//                else if(editTextMedicalCondition.getText().toString().equals(""))
//                {
//                    editTextMedicalCondition.setError("Please Enter Valid Medical Condition");
//                }
                else if(editTextDailyActivity.getText().toString().equals(""))
                {
                    editTextDailyActivity.setError("Please Enter Valid Daily Activity");
                }
                else if(btnWorkoutStartTime.getText().toString().equals("Start Time    "))
                {
                    btnWorkoutStartTime.setError("Please Enter Valid Workout Start Time");
                }
                else if(btnWorkoutEndTime.getText().toString().equals("End Time  "))
                {
                    btnWorkoutEndTime.setError("Please Enter Valid Workout End Time");
                }
                else if(btnRestStartTime.getText().toString().equals("Start Time    "))
                {
                    btnRestStartTime.setError("Please Enter Valid Rest Start Time");
                }
                else if(btnRestEndTime.getText().toString().equals("End Time  "))
                {
                    btnRestEndTime.setError("Please Enter Valid Rest End Time");
                }
                else {

                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    int radioButtonID = radioGroupGender.getCheckedRadioButtonId();
                    View radioButton = radioGroupGender.findViewById(radioButtonID);
                    int indexOfSelectedGender = radioGroupGender.indexOfChild(radioButton);

                    String selectedtext = radioButtonMale.getText().toString();

                    if (indexOfSelectedGender == 0) {
                        strGender = "male";
                    } else {
                        strGender = "female";

                    }
                    System.out.println("jigar the selected gender is " + indexOfSelectedGender);
                    int intDate = 0, intMonth = 0, intYear = 0;
                    strDOB = editTextDOB.getText().toString();

                    try {

                        Date date = format.parse(strDOB);

                        final Calendar c = Calendar.getInstance();

                        c.setTime(format.parse(strDOB));
                        System.out.println("jigar Year = " + c.get(Calendar.YEAR));
                        System.out.println("jigar Month = " + (c.get(Calendar.MONTH)));
                        System.out.println("jigar Day = " + c.get(Calendar.DAY_OF_MONTH));

                        intDate = c.get(Calendar.DAY_OF_MONTH);
                        intMonth = c.get(Calendar.MONTH);
                        intYear = c.get(Calendar.YEAR);

                        System.out.println("jigar the outer date validation says is " +
                                intDate + intMonth + intYear);
                        System.out.println("jigar the outer date validation says is " +
                                intDate + intMonth + intYear);

                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                    Calendar myDate = Calendar.getInstance();
                        Date currentDate = Calendar.getInstance().getTime();
                        Date dateBirthDate = sdf.parse(strDOB);

                        System.out.println("jigar birth date date1 : " + sdf.format(dateBirthDate));
                        System.out.println("jigar current date2 : " + sdf.format(currentDate));

                        if (dateBirthDate.compareTo(currentDate) > 0) {
                            System.out.println("jigar the birth Date is after current Date");
                            editTextDOB.setError("Please Enter Valid Birth Date");
                        }
                        strMobileNumber = editTextMobileNumber.getText().toString();
                        strUserName = editTextUserName.getText().toString();
                        strPassword = editTextPassword.getText().toString();
                        strConfirmPassword = editTextConfirmPassword.getText().toString();
                        strEmailID = editTextEmailID.getText().toString();
//                            strUserWeight=  editTextUserWeight.getText().toString();
//                              strEmailID=  editTextEmailID.getText().toString();
//                        strUserWeight = editTextUserWeight.getText().toString();
//                        strUserHeight = editTextUserHeight.getText().toString();
//                        strMedicalCondition = editTextMedicalCondition.getText().toString();
                        strDailyActivity = editTextDailyActivity.getText().toString();
                        strWorkoutStartTime=btnWorkoutStartTime.getText().toString();
                        strWorkoutEndTime=btnWorkoutEndTime.getText().toString();
                        strRestStartTime=btnRestStartTime.getText().toString();
                        strRestEndTime=btnRestEndTime.getText().toString();

                        setRegisterUser();
                    } catch (ParseException e) {
                        System.out.println("jigar the error in date is " + e);
                        e.printStackTrace();
                    }
                }
            }
        });
        btnWorkoutStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openTimerDialog(btnWorkoutStartTime);
            }
        });

        btnWorkoutEndTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                openTimerDialog(btnWorkoutEndTime);
            }
        });
        btnRestStartTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                openTimerDialog(btnRestStartTime);
            }
        });

        btnRestEndTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                openTimerDialog(btnRestEndTime);

            }
        });

        TextWatcher textWatcher = new TextWatcher() {
            private String current = "";
            private String ddmmyyyy = "DDMMYYYY";
            private Calendar cal = Calendar.getInstance();

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().equals(current)) {
                    String clean = charSequence.toString().replaceAll("[^\\d.]|\\.", "");
                    String cleanC = current.replaceAll("[^\\d.]|\\.", "");

                    int cl = clean.length();
                    int sel = cl;
                    for (int j = 2; j <= cl && j < 6; j += 2) {
                        sel++;
                    }
                    //Fix for pressing delete next to a forward slash
                    if (clean.equals(cleanC)) sel--;

                    if (clean.length() < 8) {
                        clean = clean + ddmmyyyy.substring(clean.length());
                    } else {
                        //This part makes sure that when we finish entering numbers
                        //the date is correct, fixing it otherwise
                        int day = Integer.parseInt(clean.substring(0, 2));
                        int mon = Integer.parseInt(clean.substring(2, 4));
                        int year = Integer.parseInt(clean.substring(4, 8));

                        mon = mon < 1 ? 1 : mon > 12 ? 12 : mon;
                        cal.set(Calendar.MONTH, mon - 1);
                        year = (year < 1900) ? 1900 : (year > 2100) ? 2100 : year;
                        cal.set(Calendar.YEAR, year);
                        // ^ first set year for the line below to work correctly
                        //with leap years - otherwise, date e.g. 29/02/2012
                        //would be automatically corrected to 28/02/2012

                        day = (day > cal.getActualMaximum(Calendar.DATE)) ? cal.getActualMaximum(Calendar.DATE) : day;
                        clean = String.format("%02d%02d%02d", day, mon, year);
                    }

                    clean = String.format("%s/%s/%s", clean.substring(0, 2),
                            clean.substring(2, 4),
                            clean.substring(4, 8));

                    sel = sel < 0 ? 0 : sel;
                    current = clean;
                    editTextDOB.setText(current);
                    editTextDOB.setSelection(sel < current.length() ? sel : current.length());

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        editTextDOB.addTextChangedListener(textWatcher);

    }



    public void openTimerDialog(final Button btnSelectTime)
    {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);

        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(MainRegistrationActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                String strSelectedMint;
                if(selectedMinute<10)
                {
                    strSelectedMint="0"+selectedMinute;
                }else
                {
                    strSelectedMint=String.valueOf(selectedMinute);
                }
                btnSelectTime.setText( selectedHour + ":" + strSelectedMint);
//                    strSelectedTime=selectedHour + ":" + selectedMinute;
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();

    }
    public void setRegisterUser()
    {

        StringRequest req = new StringRequest(Request.Method.POST, Constants.API_USER_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String res) {
                        try {
                            Log.v(TAG, "jigar the response user register " + res);


                            JSONObject response = new JSONObject(res);

//                            {"status":1,"msg":"Successfully Registered.","info":21933002}
                            String strMessage = response.getString(Constants.TAG_MSG);

                            String strStatus=response.getString(Constants.TAG_STATUS);
                            if(strStatus.equals("1")) {
                                String strRegisterId=response.getString(Constants.TAG_INFO);
                                Log.d(TAG, "jigar the new user register id is " + strRegisterId);
                                sharedPreference.save(getApplicationContext(),strRegisterId,Constants.STORED_REGISTER_ID);
                                Intent intent=new Intent(MainRegistrationActivity.this, MainViewProfileActivity.class);
                                startActivity(intent);
                                finish();
                                //                             Toast.makeText(MainRegistrationActivity.this,strMessage,Toast.LENGTH_LONG).show();
                            }else
                            {
                                //                              Toast.makeText(MainRegistrationActivity.this,strMessage,Toast.LENGTH_LONG).show();
                            }
//                            JSONArray jsonArrayInfo=response.getJSONArray(Constants.TAG_INFO);


                        } catch (JSONException e) {
                            Log.v(TAG, "jigar the json error user register " + e);

                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            Log.v(TAG, "jigar the null pointer user register " + e);

                            e.printStackTrace();
                        } catch (Exception e) {
                            Log.v(TAG, "jigar the exception in user register " + e);

                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Log.v(TAG, "jigar the volley error user register " + error);

            }


        }) {



            @Override
            public byte[] getBody() throws com.android.volley.AuthFailureError {
                String strValidData="AjsEFhsjcnshsuj@kjmjkmrtghy8rr";
                String newVal = strDOB.replaceAll("/" , "-");
                strDOB=newVal;
                Log.d(TAG,"jigar the new date of birth is final "+strDOB);
                String str = "{" +
                        "\""+Constants.TAG_NAME+"\" : \""+strUserName+"\",\"" +
                        ""+Constants.TAG_EMAIL_ID+"\" : \""+strEmailID+"\",\"" +
                        ""+Constants.TAG_GENDER+"\" : \""+strGender+"\",\"" +
                        ""+Constants.TAG_MOBILE_NO+"\" : \""+strMobileNumber+"\",\"" +
                        ""+Constants.TAG_DOB+"\" : \""+strDOB+"\",\"" +
                        ""+Constants.TAG_PASSWORD+"\" : \""+strPassword+"\",\"" +
                        ""+Constants.TAG_WEIGHT+"\" : \""+strUserWeight+"\",\"" +
                        ""+Constants.TAG_HEIGHT+"\" : \""+strUserHeight+"\",\"" +
                        ""+Constants.TAG_WORKOUT_START_TIME+"\" : \""+strWorkoutStartTime+"\",\"" +
                        ""+Constants.TAG_WORKOUT_END_TIME+"\" : \""+strWorkoutEndTime+"\",\"" +
                        ""+Constants.TAG_REST_START_TIME+"\" : \""+strRestStartTime+"\",\"" +
                        ""+Constants.TAG_REST_END_TIME+"\" : \""+strRestEndTime+"\",\"" +
                        ""+Constants.TAG_MEDICAL_CONDITION+"\" : \""+strMedicalCondition+"\",\"" +
                        ""+Constants.TAG_DAILY_ACTIVITY+"\" : \""+strDailyActivity+"\",\"" +
                        ""+Constants.TAG_VALID_DATA+"\" : \""+strValidData+"\",\"" +
                        ""+Constants.TAG_TYPE+"\" : \"1\"" +"}";
                //              Log.v(TAG, "jigar the set user register params=" + str);

                return str.getBytes();
            }

            public String getBodyContentType()
            {
                return "application/json; charset=utf-8";
            }


        };

        FitnessApplication.getInstance().addToRequestQueue(req, TAG);

    }



    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();

        List<String> Height = new ArrayList<String>();

        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);

        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);

        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);

        //     Toast.makeText(parent.getContext(), Height + item, Toast.LENGTH_LONG).show();

//
//        if (position == 1){
//
//            spinnerInch.setVisibility(View.VISIBLE);
//
//        } else if (position == 2){
//
//            spinnerHeight.setVisibility(View.GONE);
//        }



    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }




    private void setEnable() {


        String text = spinnerHeight.getSelectedItem().toString();
        if (text == "Other")
        {

            spinnerHeight.setEnabled(false);
        }
        else {

            spinnerInch.setEnabled(true);

        }

    }
}
