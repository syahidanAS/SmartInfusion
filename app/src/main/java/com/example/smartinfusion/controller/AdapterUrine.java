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

public class AdapterUrine extends RecyclerView.Adapter<AdapterUrine.MyViewHolder>{
    ArrayList<DataUrine>list;
    public AdapterUrine(ArrayList<DataUrine>list){
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data_urine, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUrine.MyViewHolder holder, int position) {
        holder.tvVolumeUrine.setText(String.valueOf(list.get(position).getVolume())+" ml");
        holder.tvTanggal.setText(list.get(position).getTanggal());
        holder.tvJam.setText(list.get(position).getJam());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTanggal, tvJam, tvVolumeUrine;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvJam = itemView.findViewById(R.id.tv_jam);
            tvVolumeUrine = itemView.findViewById(R.id.volume_urine_detail);
        }
    }

}
