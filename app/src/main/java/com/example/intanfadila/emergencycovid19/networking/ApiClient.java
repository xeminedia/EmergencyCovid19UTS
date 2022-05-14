package com.example.intanfadila.emergencycovid19.networking;

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by INTAN FADILA on 5/14/2022.
 */
public class ApiClient {
    companion object {
        private const val BASE_URL = "https://rs-bed-covid-api.vercel.app/api/";
        void getClient(): ApiInterface {
            val retrofit = Retrofit.Builder();
                    .baseUrl(BASE_URL);
                    .addConverterFactory(GsonConverterFactory.create());
                    .build();
            return retrofit.create(ApiInterface::class.java);
        }
    }
}
