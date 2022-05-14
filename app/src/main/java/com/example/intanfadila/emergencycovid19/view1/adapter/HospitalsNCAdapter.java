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
import com.example.intanfadila.emergencycovid19.model.rs.noncovid.ModelHospitalNCvd.ModelHospitalNCovid;
import com.example.intanfadila.emergencycovid19.utils.Constant;
import com.example.intanfadila.emergencycovid19.view.activities.DetailHospitalsActivity;
import java.android.synthetic.main.list_item_hospitals_noncovid.view.*;
import java.util.*;

/**
 * Created by INTAN FADILA on 5/14/2022.
 */
public class HospitalsNCAdapter {
    RecyclerView.Adapter<HospitalsNCAdapter.HospitalsViewHolder>() {

        private void modelHospitalNCovidArrayList = ArrayList<ModelHospitalNCovid>();

        void setHospitalAdapter(items: ArrayList<ModelHospitalNCovid>) {
            modelHospitalNCovidArrayList.clear();
            modelHospitalNCovidArrayList.addAll(items);
            notifyDataSetChanged();
        }

        @Override
        protected void onCreateViewHolder(ViewGroup parent, Int viewType) HospitalsViewHolder {
            val view = LayoutInflater.from(parent.context);
                    .inflate(R.layout.list_item_hospitals_noncovid, parent, false);
            return HospitalsViewHolder(view);
        }

        @Override
        protected void onBindViewHolder(HospitalsViewHolder holder, Int position) {

            //set data to share & intent
            holder.tvName.text = modelHospitalNCovidArrayList[position].name;
            holder.tvAddress.text = modelHospitalNCovidArrayList[position].address;
            holder.tvTimeUpdate.text = modelHospitalNCovidArrayList[position].info;

            if (modelHospitalNCovidArrayList[position].phone == null) {
                holder.tvPhone.text = "-";
            } else if (modelHospitalNCovidArrayList[position].phone == modelHospitalNCovidArrayList[position].phone) {
                holder.tvPhone.text = modelHospitalNCovidArrayList[position].phone;
            }

            holder.cvDaftarRs.setOnClickListener {
                Constant.hospitalId = modelHospitalNCovidArrayList[position].id;
                Constant.hospitalName = modelHospitalNCovidArrayList[position].name;
                Constant.phoneNumber = modelHospitalNCovidArrayList[position].phone.toString();
                val intent = Intent(context, DetailHospitalsActivity::class.java);
                context.startActivity(intent);
            }
        }

        @Override
        protected void getItemCount() Int {
            return modelHospitalNCovidArrayList.size;
        }

        class HospitalsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var cvDaftarRs: CardView;
            var tvName: TextView;
            var tvAddress: TextView;
            var tvPhone: TextView;
            var tvTimeUpdate: TextView;

            init {
                cvDaftarRs = itemView.cvDaftarRs;
                tvName = itemView.tvName;
                tvAddress = itemView.tvAddress;
                tvPhone = itemView.tvPhone;
                tvTimeUpdate = itemView.tvTimeUpdate;
            }
        }
}
