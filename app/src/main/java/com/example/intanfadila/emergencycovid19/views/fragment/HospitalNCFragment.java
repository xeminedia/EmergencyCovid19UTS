package com.example.intanfadila.emergencycovid19.views.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.intanfadila.emergencycovid19.R;
import com.example.intanfadila.emergencycovid19.model.rs.noncovid.ModelHospitalNCvd.ModelHospitalNCovid;
import com.example.intanfadila.emergencycovid19.utils.Constant;
import com.example.intanfadila.emergencycovid19.view.adapter.HospitalsNCAdapter;
import com.example.intanfadila.emergencycovid19.viewmodel.PrimaryViewModel;
import java.android.synthetic.main.fragment_hospitals.*;
import java.util.*;


/**
 * Created by INTAN FADILA on 5/13/2022.
 */
public class HospitalNCFragment {
    lateinit var primaryViewModel: PrimaryViewModel;
    lateinit var hospitalsNCAdapter: HospitalsNCAdapter;

    @Override
    protected void onCreateView(LayoutInflater inflater,
                                ViewGroup container, Bundle savedInstanceState) View {
        return inflater.inflate(R.layout.fragment_hospitals, container, false);
    }

    @Override
    protected void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hospitalsNCAdapter = HospitalsNCAdapter(context);
        rvDaftarRs.setLayoutManager(LinearLayoutManager(context));
        rvDaftarRs.setAdapter(hospitalsNCAdapter);
        rvDaftarRs.setHasFixedSize(true);
        linearNoData.setVisibility(View.GONE);

        //viewmodel
        primaryViewModel = ViewModelProvider(this,
                NewInstanceFactory()).get(PrimaryViewModel::class.java);
        primaryViewModel.setHospitalsNonCovid(Constant.provinsiId, Constant.kotaId);
        progressBar.setVisibility(View.VISIBLE);
        primaryViewModel.getHospitalsNonCovid().observe(viewLifecycleOwner, Observer<ArrayList<ModelHospitalNCovid?>> { modelHospital: ArrayList<ModelHospitalNCovid?> ->
        if (modelHospital.size != 0) {
            hospitalsNCAdapter.setHospitalAdapter(modelHospital);
        } else {
            progressBar.setVisibility(View.GONE);
            linearNoData.setVisibility(View.VISIBLE);
            rvDaftarRs.setVisibility(View.GONE);
        }
        progressBar.setVisibility(View.GONE);
        })
    }

}
