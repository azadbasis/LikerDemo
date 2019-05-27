package com.liker;

import com.liker.model.Resend;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MyWebservice {

    Retrofit retrofit = new Retrofit.Builder()
         //   .baseUrl("http://services.groupkt.com/country/get/")
            .baseUrl(" https://www.liker.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
//http://services.groupkt.com/country/get/all



    @POST("main/resend/{userId}")
    Call<Resend> dataItems(@Path("userId") String code);
}
