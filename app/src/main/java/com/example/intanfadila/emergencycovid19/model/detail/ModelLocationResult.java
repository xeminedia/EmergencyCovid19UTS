package com.example.intanfadila.emergencycovid19.model.detail;

import com.google.gson.annotations.SerializedName

/**
 * Created by INTAN FADILA on 5/14/2022.
 */
public class ModelLocationResult {
    SerializedName("data");
    lateinit var data: ModelData;

    inner class ModelData {
        SerializedName("id");
        lateinit var id: String;

        SerializedName("name");
        lateinit var name: String;

        SerializedName("address");
        lateinit var address: String;

        SerializedName("lat");
        lateinit var lat: String;

        SerializedName("long");
        lateinit var long: String;

        SerializedName("gmaps");
        lateinit var gmaps: String;
    }

}
