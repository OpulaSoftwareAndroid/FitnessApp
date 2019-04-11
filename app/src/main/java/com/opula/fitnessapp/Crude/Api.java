package com.opula.fitnessapp.Crude;


import com.opula.fitnessapp.POJOClasses.DietPlanListModel.DietplanList;
import com.opula.fitnessapp.POJOClasses.Foodlist.Breakfast;
import com.opula.fitnessapp.POJOClasses.MentorListModel.MentorMemberList;
import com.opula.fitnessapp.POJOClasses.MentorTypeListModel.MentorTypeList;
import com.opula.fitnessapp.POJOClasses.UserDetailsModel.UserDetailPOJO;
import com.opula.fitnessapp.POJOClasses.buyPlan.Buyplan;
import com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.PlanScheduleModel;
import com.opula.fitnessapp.POJOClasses.subscribe.Subscribe;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

@SuppressWarnings("All")
public interface Api {

  //  @POST("DietPlanList.php")
//    Call<CountryList> getCountry(@Body Map<String, String> params);


    @POST("UserDetailByID.php")
    Call<UserDetailPOJO> getUserDetailByID(@Body Map<String, String> params);

    @POST("MentorList.php")
    Call<MentorMemberList> getMentorList(@Body Map<String, String> params);

//    @POST("MentorTypeList.php")
//    Call<MentorTypeList> getMentorTypeList(@Body Map<String, String> params);



    @POST("DietPlanList.php")
    Call<DietplanList> getDietplanList(@Body Map<String, String> params);


    @POST("FoodList.php")
    Call<Breakfast> getBreakfast(@Body Map<String, String> param);

    @POST("SubscribeList.php")
    Call<Subscribe> getSubscribe(@Body Map<String, String> param);

    @POST("MentorList.php")
    Call<MentorMemberList> GetMentorList(@Body Map<String, String> params);

    Call<MentorMemberList> getMentorMemberList(Map<String, String> params);

    Call<MentorTypeList> getcallAPIGetMentorTypeList(Map<String, String> params);

    @POST("MentorTypeList.php")
    Call<MentorTypeList> getMentorTypeList(@Body Map<String, String> params);

    @POST("BuyPlan.php")
    Call<Buyplan> GetBuyplan(@Body Map<String, String> params);

    @POST("PlanScheduleList.php")
    Call<PlanScheduleModel> GetPlanSchedule(@Body Map<String, String> optioMap);

//    @POST("MentorTypeList.php")
//    Call<MentorMemberList> getMentorMemberList(@Body Map<String, String> optioMap);



//
//    @Multipart
//    @POST("UpdateProfile.php")
//    Call<CommanResponse> edit_personal(@Part MultipartBody.Part image,
//                                       @Part("FullName") RequestBody department,
//                                       @Part("RegisterId") RequestBody subject,
//                                       @Part("MobileNo") RequestBody message,
//                                       @Part("ValidData") RequestBody project_id,
//                                       @Part("Type") RequestBody register_id,
//                                       @Part("CountryCode") RequestBody country_code);
//
//
//
//    @POST("UpdateContact.php")
//    Call<CommanResponse> edit_contact(@Body Map<String, String> params);
//
//    @POST("ChangePassword.php")
//    Call<CommanResponse> edit_password(@Body Map<String, String> params);
//
//    @POST("TransactionPassword.php")
//    Call<CommanResponse> edit_transaction_password(@Body Map<String, String> params);
//
//    @POST("SendOtherTransaction.php")
//    Call<Send> sendNYECoin(@Body Map<String, String> params);
//
//    @POST("ReceiveOtherTransaction.php")
//    Call<CommanResponse> receivebitalgo(@Body Map<String, String> params);
//
//    @POST("ReceiveOtherTransactionCoin.php")
//    Call<CommanResponse> receiveOtherTransactionCoin(@Body Map<String, String> params);
//
//    @POST("ReceiveOtherTransactionMultiple.php")
//    Call<CommanResponse> receiveOtherTransactionMultiple(@Body Map<String, String> params);
//
//    @Multipart
//    @POST("CreateTicket.php")
//    Call<CommanResponse> create_ticket(@Part MultipartBody.Part image,
//                                       @Part("Subject") RequestBody subject,
//                                       @Part("RegisterId") RequestBody regid,
//                                       @Part("Message") RequestBody message,
//                                       @Part("ValidData") RequestBody validdata,
//                                       @Part("Type") RequestBody type);
//
//    @Multipart
//    @POST("KYCUpdate.php")
//    Call<CommanResponse> insert_kyc_document(@Part MultipartBody.Part image,
//                                             @Part("RegisterId") RequestBody regid,
//                                             @Part("FullName") RequestBody fullname,
//                                             @Part("DocumentType") RequestBody documenttype,
//                                             @Part("DocumentNumber") RequestBody documentnumber,
//                                             @Part("DocumentExpiredDate") RequestBody documentexpireddate,
//                                             @Part("ValidData") RequestBody validdata,
//                                             @Part("Type") RequestBody type);
//
//    @POST("TransactionHistory.php")
//    Call<TransactionInfo> transactionhistory(@Body Map<String, String> params);
//
//    @POST("TicketHistory.php")
//    Call<TicketInfo> tickethistory(@Body Map<String, String> params);
//
//    @Multipart
//    @POST("ReplyTicket.php")
//    Call<CommanResponse> reply_ticket(@Part MultipartBody.Part image,
//                                      @Part("RegisterId") RequestBody regid,
//                                      @Part("Message") RequestBody message,
//                                      @Part("ValidData") RequestBody validdata,
//                                      @Part("TicketNumber") RequestBody number,
//                                      @Part("Type") RequestBody type);
//
//    @POST("AllTicketHistory.php")
//    Call<AllTicketInfo> alltickethistory(@Body Map<String, String> params);
//
//    @POST("CityList.php")
//    Call<CityList> getCity(@Body Map<String, String> params);
//
//    @POST("StateList.php")
//    Call<StateList> getState(@Body Map<String, String> params);
//
//    @GET("AndroidVersion.php")
//    Call<CommanResponse> getVersion();
}
