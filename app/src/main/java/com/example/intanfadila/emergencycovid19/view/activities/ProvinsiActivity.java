package com.example.intanfadila.emergencycovid19.view.activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.intanfadila.emergencycovid19.R;
import com.example.intanfadila.emergencycovid19.model.provinsi.ModelProvinsiResult.ModelProvinsi;
import com.example.intanfadila.emergencycovid19.view.adapter.ProvinsiAdapter;
import com.example.intanfadila.emergencycovid19.viewmodel.PrimaryViewModel;
import java.android.synthetic.main.activity_provinsi.*;
import java.util.*;


/**
 * Created by INTAN FADILA on 5/13/2022.
 */
public class ProvinsiActivity {
    lateinit var primaryViewModel: PrimaryViewModel;
    lateinit var provinsiAdapter: ProvinsiAdapter;
    var REQ_PERMISSION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provinsi);

        setStatusBar();
        setPermission();

        linearNoData.setVisibility(View.GONE);

        provinsiAdapter = ProvinsiAdapter(this);
        rvDaftarProvinsi.setLayoutManager(LinearLayoutManager(this));
        rvDaftarProvinsi.setAdapter(provinsiAdapter);
        rvDaftarProvinsi.setHasFixedSize(true);

        //viewmodel
        getProvinsiViewModel();
    }

    public void getProvinsiViewModel() {
        primaryViewModel = ViewModelProvider(this,
                NewInstanceFactory()).get(PrimaryViewModel::class.java);
        primaryViewModel.setProvinsi();
        progressBar.visibility = View.VISIBLE
        primaryViewModel.getProvinsi().observe(this, Observer<ArrayList<ModelProvinsi?>> { modelProvinsi: ArrayList<ModelProvinsi?> ->
        if (modelProvinsi.size != 0) {
            provinsiAdapter.setProvinsiAdapter(modelProvinsi);
        } else {
            progressBar.visibility = View.GONE;
            linearNoData.visibility = View.VISIBLE;
            rvDaftarProvinsi.visibility = View.GONE;
        }
        progressBar.visibility = View.GONE;
        });

    }

    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or;
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            window.statusBarColor = Color.TRANSPARENT;
        }
    }

    private void setPermission() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED;
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION), REQ_PERMISSION);
            return;
        }
    }

    @Override
    protected void onRequestPermissionsResult(Int requestCode ,
                                              Array<String> permissions , IntArray grantResults ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (grantResult in grantResults) {
            if (grantResult == PackageManager.PERMISSION_GRANTED) {
                val intent = intent;
                finish();
                startActivity(intent);
            }
        }
    }
    @Override
    protected void onActivityResult(Int requestCode, Int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_PERMISSION && resultCode == RESULT_OK) {
            getProvinsiViewModel();
        }
    }

    companion object {
        public void setWindowFlag(Activity activity:, Int bits, Boolean on) {
            val window = activity.window;
            val layoutParams = window.attributes;
            if (on) {
                layoutParams.flags = layoutParams.flags or bits;
            } else {
                layoutParams.flags = layoutParams.flags and bits.inv();
            }
            window.attributes = layoutParams;
        }
    }
}
