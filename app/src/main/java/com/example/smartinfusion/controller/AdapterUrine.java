package com.example.smartinfusion.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartinfusion.R;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AdapterUrine extends RecyclerView.Adapter<AdapterUrine.ViewHolder> {
    Context context;
    List<DataUrine> list;

    public AdapterUrine(Context context, List<DataUrine> list) {
        this.context = context;
        this.list = list;
    }

    public AdapterUrine(ArrayList<DataUrine> myList) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_data_urine,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String volumeAsString = Integer.toString(list.get(position).getVolume());
        holder.volumeUrineDetail.setText(volumeAsString+" ml");
        holder.tvJam.setText(list.get(position).getJam());
        holder.tvTanggal.setText(list.get(position).getTanggal());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView volumeUrineDetail, tvTanggal, tvJam;
        ImageButton ibEdit, ibDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            volumeUrineDetail = itemView.findViewById(R.id.volume_urine_detail);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvJam = itemView.findViewById(R.id.tv_jam);

        }
    }
}
