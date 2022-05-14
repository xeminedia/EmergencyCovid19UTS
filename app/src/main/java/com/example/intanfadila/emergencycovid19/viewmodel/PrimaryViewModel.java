package com.example.intanfadila.emergencycovid19.viewmodel;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.intanfadila.emergencycovid19.model.detail.ModelDetailResult;
import com.example.intanfadila.emergencycovid19.model.detail.ModelDetailResult.ModelData.BedDetail;
import com.example.intanfadila.emergencycovid19.model.detail.ModelLocationResult;
import com.example.intanfadila.emergencycovid19.model.kota.ModelKotaResult;
import com.example.intanfadila.emergencycovid19.model.kota.ModelKotaResult.ModelKota;
import com.example.intanfadila.emergencycovid19.model.provinsi.ModelProvinsiResult;
import com.example.intanfadila.emergencycovid19.model.provinsi.ModelProvinsiResult.ModelProvinsi;
import com.example.intanfadila.emergencycovid19.model.rs.covid.ModelHospitalCvd;
import com.example.intanfadila.emergencycovid19.model.rs.covid.ModelHospitalCvd.ModelHospitalC;
import com.example.intanfadila.emergencycovid19.model.rs.noncovid.ModelHospitalNCvd;
import com.example.intanfadila.emergencycovid19.model.rs.noncovid.ModelHospitalNCvd.ModelHospitalNCovid;
import com.example.intanfadila.emergencycovid19.networking.ApiClient;
import com.example.intanfadila.emergencycovid19.networking.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.*;

/**
 * Created by INTAN FADILA on 5/14/2022.
 */
public class PrimaryViewModel {
    private void modelProvinsiMutableLiveData = MutableLiveData<ArrayList<ModelProvinsi>>();
    private void modelKotaMutableLiveData = MutableLiveData<ArrayList<ModelKota>>();
    private void modelHospitalCovidMutableLiveData = MutableLiveData<ArrayList<ModelHospitalC>>();
    private void modelHospitalNonCovidMutableLiveData = MutableLiveData<ArrayList<ModelHospitalNCovid>>();
    private void modelDataMutableLiveData = MutableLiveData<ArrayList<BedDetail>>();
    private void modelLocationMutableLiveData = MutableLiveData<ModelLocationResult.ModelData>();

    //method provinsi
    void setProvinsi() {
        val apiService: ApiInterface = ApiClient.getClient();
        val call = apiService.getListProvinces();
        call.enqueue(object : Callback<ModelProvinsiResult> {
            @Override
            protected void onResponse(call: Call<ModelProvinsiResult>,;
            response: Response<ModelProvinsiResult>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString());
                } else if (response.body() != null) {
                    val items = ArrayList(response.body().provinces);
                    modelProvinsiMutableLiveData.postValue(items);
                }
            }

            @Override
            protected void onFailure(call: Call<ModelProvinsiResult>, t: Throwable) {
                Log.e("failure", t.toString());
            }
        });
    }

    //method kota
    void setKota(ProvinsiId: String) {
        val apiService: ApiInterface = ApiClient.getClient();
        val call = apiService.getListCity(ProvinsiId);
        call.enqueue(object : Callback<ModelKotaResult> {
            @Override
            protected void onResponse(call: Call<ModelKotaResult>, response: Response<ModelKotaResult>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString());
                } else if (response.body() != null) {
                    val items = ArrayList(response.body().cities);
                    modelKotaMutableLiveData.postValue(items);
                }
            }

            @Override
            protected void onFailure(call: Call<ModelKotaResult>, t: Throwable) {
                Log.e("failure", t.toString());
            }
        });
    }

    //method rs covid
    public void setModelHospitalCovidMutableLiveData(void modelHospitalCovidMutableLiveData) {
        this.modelHospitalCovidMutableLiveData = modelHospitalCovidMutableLiveData;
    }setHospitalsCovid(ProvinsiId: String, KotaId: String) {
        val apiService: ApiInterface = ApiClient.getClient();
        val call = apiService.getListHospitalsCovid(ProvinsiId, KotaId, "1");
        call.enqueue(object : Callback<ModelHospitalCvd> {
            @Override
            protected void onResponse(call: Call<ModelHospitalCvd>, response: Response<ModelHospitalCvd>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString());
                } else if (response.body() != null) {
                    val items = ArrayList(response.body().hospitals);
                    modelHospitalCovidMutableLiveData.postValue(items);
                }
            }

            @Override
            protected void onFailure(call: Call<ModelHospitalCvd>, t: Throwable) {
                Log.e("failure", t.toString());
            }
        });
    }

    //method rs non covid
    public void setModelHospitalNonCovidMutableLiveData(void modelHospitalNonCovidMutableLiveData) {
        this.modelHospitalNonCovidMutableLiveData = modelHospitalNonCovidMutableLiveData;
    }setHospitalsNonCovid(ProvinsiId: String, KotaId: String) {
        val apiService: ApiInterface = ApiClient.getClient();
        val call = apiService.getListHospitalsNonCovid(ProvinsiId, KotaId, "2");
        call.enqueue(object : Callback<ModelHospitalNCvd> {
            @Override
            protected void onResponse(call: Call<ModelHospitalNCvd>, response: Response<ModelHospitalNCvd>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString());
                } else if (response.body() != null) {
                    val items = ArrayList(response.body().hospitals);
                    modelHospitalNonCovidMutableLiveData.postValue(items);
                }
            }

            @Override
            protected void onFailure(call: Call<ModelHospitalNCvd>, t: Throwable) {
                Log.e("failure", t.toString());
            }
        });
    }

    //method detail rs covid
    void setDetailsCovid(HospitalId: String) {
        val apiService: ApiInterface = ApiClient.getClient();
        val call = apiService.getListDetails(HospitalId, "1");
        call.enqueue(object : Callback<ModelDetailResult> {
            @Override
            protected void onResponse(call: Call<ModelDetailResult>, response: Response<ModelDetailResult>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString());
                } else if (response.body() != null) {
                    val items = ArrayList(response.body().data.bedDetail);
                    modelDataMutableLiveData.postValue(items);
                }
            }

            @Override
            protected void onFailure(call: Call<ModelDetailResult>, t: Throwable) {
                Log.e("failure", t.toString());
            }
        });
    }

    //method detail rs non covid
    void setDetailsNonCovid(HospitalId: String) {
        val apiService: ApiInterface = ApiClient.getClient();
        val call = apiService.getListDetails(HospitalId, "2");
        call.enqueue(object : Callback<ModelDetailResult> {
            @Override
            protected void onResponse(call: Call<ModelDetailResult>, response: Response<ModelDetailResult>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString());
                } else if (response.body() != null) {
                    val items = ArrayList(response.body().data.bedDetail);
                    modelDataMutableLiveData.postValue(items);
                }
            }

            @Override
            protected void onFailure(call: Call<ModelDetailResult>, t: Throwable) {
                Log.e("failure", t.toString());
            }
        });
    }

    //method map lokasi
    public void getModelLocationMutableLiveData() {
        return modelLocationMutableLiveData;
    }setLocation(HospitalId: String) {
        val apiService: ApiInterface = ApiClient.getClient();
        val call = apiService.getMapLocation(HospitalId);
        call.enqueue(object : Callback<ModelLocationResult> {
            @Override
            protected void onResponse(call: Call<ModelLocationResult>,;
            response: Response<ModelLocationResult>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString());
                } else if (response.body() != null) {
                    modelLocationMutableLiveData.postValue(response.body().data);
                }
            }

            @Override
            protected void onFailure(call: Call<ModelLocationResult>, t: Throwable) {
                Log.e("failure", t.toString());
            }
        });
    }

    public void getModelProvinsiMutableLiveData() {
        return modelProvinsiMutableLiveData;
    }

    getProvinsi(): LiveData<ArrayList<ModelProvinsi>> = modelProvinsiMutableLiveData;

    public void getModelKotaMutableLiveData() {
        return modelKotaMutableLiveData;
    }

    getKota(): LiveData<ArrayList<ModelKota>> = modelKotaMutableLiveData;

    public void getModelHospitalCovidMutableLiveData() {
        return modelHospitalCovidMutableLiveData;
    }

    getHospitalsCovid(): LiveData<ArrayList<ModelHospitalC>> = modelHospitalCovidMutableLiveData;

    public void getModelHospitalNonCovidMutableLiveData() {
        return modelHospitalNonCovidMutableLiveData;
    }

    getHospitalsNonCovid(): LiveData<ArrayList<ModelHospitalNCovid>> = modelHospitalNonCovidMutableLiveData;

    void getDetailsCovid(): LiveData<ArrayList<BedDetail>> = modelDataMutableLiveData;

    void getDetailsNonCovid(): LiveData<ArrayList<BedDetail>> = modelDataMutableLiveData;

    public void setModelLocationMutableLiveData(void modelLocationMutableLiveData) {
        this.modelLocationMutableLiveData = modelLocationMutableLiveData;
    }

    getLocation(): LiveData<ModelLocationResult.ModelData> = modelLocationMutableLiveData;
}








