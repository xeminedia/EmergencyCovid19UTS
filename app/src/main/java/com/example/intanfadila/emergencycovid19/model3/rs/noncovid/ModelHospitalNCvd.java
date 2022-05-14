package com.example.intanfadila.emergencycovid19.model3.rs.noncovid;

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by INTAN FADILA on 5/14/2022.
 */
public class ModelHospitalNCvd {
    SerializedName("hospitals");
    lateinit var hospitals: List<ModelHospitalNCovid>;

    inner class ModelHospitalNCovid : Serializable {
        SerializedName("id");
        lateinit var id: String;

        SerializedName("name");
        lateinit var name: String;

        SerializedName("address");
        lateinit var address: String;

        SerializedName("phone");
        lateinit var phone: String;

        SerializedName("info");
        lateinit var info: String;
    }
}
