package com.example.intanfadila.emergencycovid19.networking;

import com.example.intanfadila.emergencycovid19.model.detail.ModelDetailResult;
import com.example.intanfadila.emergencycovid19.model.detail.ModelLocationResult;
import com.example.intanfadila.emergencycovid19.model.kota.ModelKotaResult;
import com.example.intanfadila.emergencycovid19.model.provinsi.ModelProvinsiResult;
import com.example.intanfadila.emergencycovid19.model.rs.covid.ModelHospitalCvd;
import com.example.intanfadila.emergencycovid19.model.rs.noncovid.ModelHospitalNCvd;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by INTAN FADILA on 5/14/2022.
 */
public class interface ApiInterface {
    GET("get-provinces");
    void getListProvinces() : Call<ModelProvinsiResult>;

    GET("get-cities?");
    void getListCity(Query("provinceid") provinceid: String;
    ): Call<ModelKotaResult>;

    GET("get-hospitals?");
    void getListHospitalsCovid(
            Query("provinceid") provinceid: String,;
            Query("cityid") cityid: String,;
            Query("type") type: String;
    ): Call<ModelHospitalCvd>;

    GET("get-hospitals?");
    void getListHospitalsNonCovid(
            Query("provinceid") provinceid: String,;
            Query("cityid") cityid: String,;
            Query("type") type: String;
    ): Call<ModelHospitalNCvd>;

    GET("get-bed-detail?");
    void getListDetails(
            Query("hospitalid") hospitalid: String,;
            Query("type") type: String;
    ): Call<ModelDetailResult>;

    GET("get-hospital-map?");
    void getMapLocation(
            Query("hospitalid") hospitalid: String;
    ): Call<ModelLocationResult>;
}
