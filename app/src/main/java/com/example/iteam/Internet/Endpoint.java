package com.example.iteam.Internet;

import com.example.iteam.Model.MyResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Endpoint {

    @FormUrlEncoded
    @POST("register")
    Call<MyResponse> daftar(
            @Field("nama") String name,
            @Field("email") String alamat,
            @Field("hp") String phone

    );

}
