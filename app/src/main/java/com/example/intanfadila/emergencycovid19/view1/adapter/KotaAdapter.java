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
import com.example.intanfadila.emergencycovid19.model.kota.ModelKotaResult.ModelKota;
import com.example.intanfadila.emergencycovid19.utils.Constant;
import com.example.intanfadila.emergencycovid19.view.activities.HospitalsActivity;
import com.example.intanfadila.emergencycovid19.view.adapter.KotaAdapter.KotaViewHolder;
import java.android.synthetic.main.list_item_kota.view.*;
import java.util.*;


/**
 * Created by INTAN FADILA on 5/13/2022.
 */
public class KotaAdapter {
    private void modelKotaArrayList = ArrayList<ModelKota>();

    void setKotaAdapter(items: ArrayList<ModelKota>) {
        modelKotaArrayList.clear();
        modelKotaArrayList.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    protected void onCreateViewHolder(ViewGroup parent, Int viewType) KotaViewHolder {
        val view = LayoutInflater.from(parent.context);
                .inflate(R.layout.list_item_kota, parent, false);
        return KotaViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(KotaViewHolder holder, Int position) {

        //set data to share & intent
        holder.tvKota.text = modelKotaArrayList[position].name;

        holder.cvDaftarKota.setOnClickListener {
            Constant.kotaId = modelKotaArrayList[position].id;
            Constant.kotaName = modelKotaArrayList[position].name;
            val intent = Intent(context, HospitalsActivity::class.java);
            context.startActivity(intent);
        }
    }

    @Override
    protected void getItemCount(): Int {
        return modelKotaArrayList.size;
    }

    class KotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cvDaftarKota: CardView;
        var tvKota: TextView;

        init {
            cvDaftarKota = itemView.cvDaftarKota;
            tvKota = itemView.tvKota;
        }
    }
}

