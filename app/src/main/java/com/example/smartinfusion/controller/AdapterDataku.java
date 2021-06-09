package com.example.smartinfusion.controller;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartinfusion.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

public class AdapterDataku extends RecyclerView.Adapter<AdapterDataku.ViewHolder> {
    //baru
    Context context;
    List<Dataku> list;

    //baru ubah dan hapus

    OnCallBack onCallBack;

    public void setOnCallBack(OnCallBack onCallBack) {
        this.onCallBack = onCallBack;
    }

    public AdapterDataku(Context context, List<Dataku> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //baru
        View view = LayoutInflater.from(context).inflate(R.layout.list_data_bed, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int volInfus1 = list.get(position).getInfusion_volume_1();
        int volUrine1 = list.get(position).getUrine_volume_1();
        int tpm1 = list.get(position).getDrops_rate_1();

        int volInfus2 = list.get(position).getInfusion_volume_2();
        int volUrine2 = list.get(position).getUrine_volume_2();
        int tpm2 = list.get(position).getDrops_rate_2();




        //baru
        holder.tvRuangan.setText(list.get(position).getRuangan());
        holder.volumeInfus1.setText(String.valueOf(list.get(position).getInfusion_volume_1())+" ml");
        holder.volumeInfus2.setText(String.valueOf(list.get(position).getInfusion_volume_2())+" ml");
        holder.lajuTetes1.setText(String.valueOf(list.get(position).getDrops_rate_1())+" tpm");
        holder.lajuTetes2.setText(String.valueOf(list.get(position).getDrops_rate_2())+" tpm");

        if (volInfus1!=0 || volUrine1!=0){
            holder.status1.setText("Aktif");
        }else if(volInfus1==0 || volUrine1==0){
            holder.status1.setText("Tidak Aktif");
        }if (volInfus2!=0){
            holder.status2.setText("Aktif");
        }else if(volInfus2==0){
            holder.status2.setText("Tidak Aktif");
        }


        int intake_1 = list.get(position).getCalibration_1()-list.get(position).getInfusion_volume_1();
        int intake_2 = list.get(position).getCalibration_2()-list.get(position).getInfusion_volume_2();

        if(intake_1>=list.get(position).getCalibration_1()){
            holder.intake1.setText("0 ml");
            holder.intake2.setText("0 ml");
        }else{
            holder.intake1.setText(String.valueOf(intake_1)+" ml");
            holder.intake2.setText(String.valueOf(intake_2)+" ml");
        }


        int curHour1 = list.get(position).getRestore_hour_1();
        int curMinute1 = list.get(position).getRestore_hour_1();

        if (curHour1!= 0 || curMinute1!=0){
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"));
            Date currentLocalTime = cal.getTime();
            DateFormat date = new SimpleDateFormat("HH");
            date.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"));

            String localTime = date.format(currentLocalTime);

            int myNum = 0;

            try {
                myNum = Integer.parseInt(localTime);
                int jam1 = myNum-list.get(position).getRestore_hour_1();
                holder.durasi1.setText(jam1+" jam");
            } catch(NumberFormatException nfe) {
            }
        }else if(curHour1== 0 || curMinute1==0){
            holder.durasi1.setText("0 jam");
        }

        int curHour2 = list.get(position).getRestore_hour_2();
        int curMinute2 = list.get(position).getRestore_hour_2();

        if (curHour2!= 0 || curMinute2!=0){
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"));
            Date currentLocalTime = cal.getTime();
            DateFormat date = new SimpleDateFormat("HH");
            date.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"));

            String localTime = date.format(currentLocalTime);

            int myNum = 0;

            try {
                myNum = Integer.parseInt(localTime);
                int jam1 = myNum-list.get(position).getRestore_hour_1();
                holder.durasi2.setText(jam1+" jam");
            } catch(NumberFormatException nfe) {
            }
        }else if(curHour1== 0 || curMinute1==0){
            holder.durasi2.setText("0 jam");
        }



        int jam2 = list.get(position).getRestore_hour_2();
        int menit1 = list.get(position).getRestore_minute_1();
        int menit2 = list.get(position).getRestore_minute_2();





        holder.urineBag1.setText(String.valueOf(list.get(position).getUrine_volume_1())+" ml");
        holder.urineBag2.setText(String.valueOf(list.get(position).getUrine_volume_2())+" ml");
        //baru untuk fungsi menghapus data
//        holder.btnHapus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onCallBack.onBtnHapus(list.get(position));
//            }
//        });

        //baru untuk fungsi menghapus data
        holder.btn_alarm_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallBack.onBtnAlarm1(list.get(position));
            }
        });
        holder.btn_alarm_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallBack.onBtnAlarm2(list.get(position));
            }
        });

        holder.log1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallBack.onLog1(list.get(position));
            }
        });

        holder.log2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallBack.onLog2(list.get(position));
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //baru
        TextView tvRuangan, volumeInfus1, volumeInfus2, lajuTetes1, lajuTetes2, intake1, intake2, durasi1, durasi2, urineBag1, urineBag2;
        LinearLayout btn_alarm_1,btn_alarm_2,btnHapus, content, log1,log2;
        ImageButton btn_expand,btn_fold;
        TextView status1,status2;
        RelativeLayout head;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //baru
            tvRuangan = itemView.findViewById(R.id.tv_ruangan);
            volumeInfus1 = itemView.findViewById(R.id.volume_infus_1);
            volumeInfus2 = itemView.findViewById(R.id.volume_infus_2);
            lajuTetes1 = itemView.findViewById(R.id.laju_tetes_1);
            lajuTetes2 = itemView.findViewById(R.id.laju_tetes_2);
            intake1 = itemView.findViewById(R.id.intake_1);
            intake2 = itemView.findViewById(R.id.intake_2);
            durasi1 = itemView.findViewById(R.id.durasi_1);
            durasi2 = itemView.findViewById(R.id.durasi_2);
            urineBag1 = itemView.findViewById(R.id.urine_bag_1);
            urineBag2 = itemView.findViewById(R.id.urine_bag_2);
//            btnHapus = itemView.findViewById(R.id.btn_hapus);
            btn_alarm_1 = itemView.findViewById(R.id.btn_alarm_1);
            btn_alarm_2 = itemView.findViewById(R.id.btn_alarm_2);
            log1 = itemView.findViewById(R.id.log_1);
            log2 = itemView.findViewById(R.id.log_2);
            btn_expand = itemView.findViewById(R.id.btn_expand);
            btn_fold = itemView.findViewById(R.id.btn_fold);
            content = itemView.findViewById(R.id.content);
            status1 = itemView.findViewById(R.id.status_1);
            status2 = itemView.findViewById(R.id.status_2);
//            head = itemView.findViewById(R.id.headerData);
//
//            head.setBackgroundColor(getRandomColorCode());

            btn_expand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    content.setVisibility(View.VISIBLE);
                    btn_expand.setVisibility(View.GONE);
                    btn_fold.setVisibility(View.VISIBLE);
                }
            });

            btn_fold.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    content.setVisibility(View.GONE);
                    btn_expand.setVisibility(View.VISIBLE);
                    btn_fold.setVisibility(View.GONE);
                }
            });
        }

    }

    //baru
    public interface OnCallBack{
        void onBtnAlarm1(Dataku dataku);
        void onBtnAlarm2(Dataku dataku);
        void onLog1(Dataku dataku);
        void onLog2(Dataku dataku);
    }
    public int getRandomColorCode(){

        Random random = new Random();

        return Color.argb(255, random.nextInt(256), random.nextInt(256),random.nextInt(256));

    }


}
