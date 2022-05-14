package com.example.intanfadila.emergencycovid19.view.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.intanfadila.emergencycovid19.R;
import com.example.intanfadila.emergencycovid19.model.kota.ModelKotaResult.ModelKota;
import com.example.intanfadila.emergencycovid19.utils.Constant;
import com.example.intanfadila.emergencycovid19.view.adapter.KotaAdapter;
import com.example.intanfadila.emergencycovid19.viewmodel.PrimaryViewModel;
import java.android.synthetic.main.activity_kota.*;
import java.util.*;

/**
 * Created by INTAN FADILA on 5/13/2022.
 */
public class KotaActivity {
    lateinit var primaryViewModel: PrimaryViewModel;
    lateinit var kotaAdapter: KotaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kota);

        setSupportActionBar(toolbar);
        assert(supportActionBar != null);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowTitleEnabled(false);

        tvTitle.setText(Constant.provinsiName);
        linearNoData.setVisibility(View.GONE);

        kotaAdapter = KotaAdapter(this);
        rvDaftarKota.setLayoutManager(LinearLayoutManager(this));
        rvDaftarKota.setAdapter(kotaAdapter);
        rvDaftarKota.setHasFixedSize(true);

        //viewmodel
        primaryViewModel = ViewModelProvider(this, NewInstanceFactory()).get(PrimaryViewModel::class.java);
        primaryViewModel.setKota(Constant.provinsiId);
        progressBar.setVisibility(View.VISIBLE);
        primaryViewModel.getKota().observe(this, Observer<ArrayList<ModelKota?>> { modelKota: ArrayList<ModelKota?> ->
        if (modelKota.size != 0) {
            kotaAdapter.setKotaAdapter(modelKota);
        } else {
            progressBar.setVisibility(View.GONE);
            linearNoData.setVisibility(View.VISIBLE);
            rvDaftarKota.setVisibility(View.GONE);
        }
        progressBar.setVisibility(View.GONE);
        });

    }

    @Override
    protected void onOptionsItemSelected(MenuItem item)Boolean {
        if (item.itemId == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

