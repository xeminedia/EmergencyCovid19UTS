package com.example.intanfadila.emergencycovid19.view1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.intanfadila.emergencycovid19.R;
import com.example.intanfadila.emergencycovid19.model.provinsi.ModelProvinsiResult.ModelProvinsi;
import com.example.intanfadila.emergencycovid19.utils.Constant;
import com.example.intanfadila.emergencycovid19.view.activities.KotaActivity;
import java.android.synthetic.main.list_item_provinsi.view.*;
import java.util.*;

/**
 * Created by INTAN FADILA on 5/13/2022.
 */
public class ProvinsiAdapter {
    RecyclerView.Adapter<ProvinsiAdapter.ProvinsiViewHolder>() {

        private val modelProvinsiArrayList = ArrayList<ModelProvinsi>();

        void setProvinsiAdapter(items: ArrayList<ModelProvinsi>) {
            modelProvinsiArrayList.clear();
            modelProvinsiArrayList.addAll(items);
            notifyDataSetChanged();
        }

        @Override
        protected void onCreateViewHolder(ViewGroup parent, Int viewType) ProvinsiViewHolder {
            val view = LayoutInflater.from(parent.context);
                    .inflate(R.layout.list_item_provinsi, parent, false);
            return ProvinsiViewHolder(view);
        }

        @Override
        protected void onBindViewHolder(ProvinsiViewHolder holder, Int position) {

            //set data to share & intent
            holder.tvProvinsi.text = modelProvinsiArrayList[position].name;

            holder.cvDaftarProvinsi.setOnClickListener {
                Constant.provinsiId = modelProvinsiArrayList[position].id;
                Constant.provinsiName = modelProvinsiArrayList[position].name;
                val intent = Intent(context, KotaActivity::class.java);
                context.startActivity(intent);
            }
        }
}
