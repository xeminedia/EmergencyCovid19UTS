package com.example.intanfadila.emergencycovid19.model1.provinsi;

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by INTAN FADILA on 5/14/2022.
 */
public class ModelProvinsiResult {
    SerializedName("provinces");
    lateinit var provinces: List<ModelProvinsi>;

    inner class ModelProvinsi : Serializable {
        SerializedName("id");
        lateinit var id: String;

        SerializedName("name");
        lateinit var name: String;
    }
}


