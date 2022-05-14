package com.example.intanfadila.emergencycovid19.models.kota;

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by INTAN FADILA on 5/14/2022.
 */
public class ModelKotaResult {
    SerializedName("cities");
    lateinit var cities: List<ModelKota>;

    inner class ModelKota : Serializable {
        SerializedName("id");
        lateinit var id: String;

        SerializedName("name");
        lateinit var name: String;
    }
}
