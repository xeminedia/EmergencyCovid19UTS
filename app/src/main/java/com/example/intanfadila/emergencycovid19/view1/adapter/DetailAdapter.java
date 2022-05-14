package com.example.intanfadila.emergencycovid19.view1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.intanfadila.emergencycovid19.R;
import com.example.intanfadila.emergencycovid19.model.detail.ModelDetailResult.ModelData.BedDetail;
import java.android.synthetic.main.list_item_hospitals_detail.view.*;
import java.util.*;

/**
 * Created by INTAN FADILA on 5/13/2022.
 */
public class DetailAdapter {
    private void modelDetailResultArrayList: MutableList<BedDetail> = ArrayList();

    void setDetailAdapter(items: ArrayList<BedDetail>) {
        modelDetailResultArrayList.clear();
        modelDetailResultArrayList.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    protected void onCreateViewHolder(ViewGroup parent, Int viewType) ProvinsiViewHolder {
        val view = LayoutInflater.from(parent.context);
                .inflate(R.layout.list_item_hospitals_detail, parent, false);
        return ProvinsiViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(ProvinsiViewHolder holder, Int position) {

        //set data to share & intent
        holder.tvTimeUpdate.text = modelDetailResultArrayList[position].time;
        holder.tvTitle.text = modelDetailResultArrayList[position].stats.title;
        holder.tvBedAvailability.text = modelDetailResultArrayList[position].stats.bedAvailable;
        holder.tvBedEmpty.text = modelDetailResultArrayList[position].stats.bedEmpty;
        holder.tvQueue.text = modelDetailResultArrayList[position].stats.queue;
    }

    @Override
    protected void getItemCount(): Int {
        return modelDetailResultArrayList.size;
    }

    class ProvinsiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cvDetailRs: CardView;
        var tvTitle: TextView;
        var tvBedAvailability: TextView;
        var tvBedEmpty: TextView;
        var tvQueue: TextView;
        var tvTimeUpdate: TextView;

        init {
            cvDetailRs = itemView.cvDetailRs;
            tvTitle = itemView.tvTitle;
            tvBedAvailability = itemView.tvBedAvailability;
            tvBedEmpty = itemView.tvBedEmpty;
            tvQueue = itemView.tvQueue;
            tvTimeUpdate = itemView.tvTimeUpdate;
        }
    }

}
