package com.example22.lenovo.admin;

import com.example22.lenovo.admin.notif.MyResponse;
import com.example22.lenovo.admin.notif.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @Headers({
            "content-Type:application/json",
            "Authorization:key=AAAAwzWoZ10:APA91bEdht2eUUBUu1tScPwGLIJ6ViAjiAJLUuEQB17wxwmUgteigdDoaJ6ejaG6W2Dabfm0Xu7GQRZgYSdgQ2HPo5Ie_hTDR4adrFnMS_QI1Ntg_Wftl1BeKAE7Egk6aWdxsJUkfNS1"
    })
    @POST("fcm/send")

    Call<MyResponse> sendNotif(@Body Sender sender);


    @FormUrlEncoded
    @POST("insert_request")
    Call<ResponseSignUp> actionRequest(@Field("iduser") String iduser,
                                       @Field("idjp") String idjp,
                                       @Field("lat") String lat,
                                       @Field("lon") String lon,
                                       @Field("alamat") String alamat,
                                       @Field("hp") String hp,
                                       @Field("ket") String ket);

    @GET("packet_private")
    Call<ResponsePaket> actionGetPacket();

    @FormUrlEncoded
    @POST("register")
    Call<ResponseSignUp> actionSignUp(
            @Field("name") String name,
            @Field("password") String password,
            @Field("hp") String hp,
            @Field("email") String email,
            @Field("jk") String jk,
            @Field("mapel1") String mapel1,
            @Field("mapel2") String mapel2,
            @Field("mapel3") String mapel3
    );

    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> actionLogin(
            @Field("hp") String hp,
            @Field("pass") String password
    );

}