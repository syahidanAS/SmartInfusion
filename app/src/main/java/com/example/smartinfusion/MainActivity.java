package com.example.smartinfusion;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartinfusion.controller.AdapterDataku;
import com.example.smartinfusion.controller.Dataku;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab_tambah;
    RecyclerView rv_data;
    ProgressBar pbHome;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    String[] kode_ruangan = {"-MYmk4f1q48ia57dNDvc",
            "-MYmk6tboYphayDJ5oNF",
            "-MYmk8WKJWzADLW5eLg4",
            "-MYmkAhmVFa6dxzW-SmA",
            "-MYmkD5Nj7k_OR97wVGj",
            "-MYmkNxdjR45KcG7gwp7",
            "-MYmkPn8ZimMi4JefIDG",
            "-MYmkRlKRYTgDEIMhurC",
            "-MYmkTF6atjje6JvsmBc",
            "-MYmkUobDJ2psX7DSH8G",
            "-MYmkWVW7A-taZrdWGKN",
            "-MYmkXyPBoFhu3u7f-M-",
            "-MYmkZn2Ney32f3y1yjz"};
    DatabaseReference myRef = database.getReference("RUANG_MAWAR");
    DatabaseReference mawar_1 = database.getReference("RUANG_MAWAR/"+kode_ruangan[0]);
    DatabaseReference mawar_2 = database.getReference("RUANG_MAWAR/"+kode_ruangan[1]);
    DatabaseReference mawar_3 = database.getReference("RUANG_MAWAR/"+kode_ruangan[2]);
    DatabaseReference mawar_4 = database.getReference("RUANG_MAWAR/"+kode_ruangan[3]);
    DatabaseReference mawar_5 = database.getReference("RUANG_MAWAR/"+kode_ruangan[4]);
    DatabaseReference mawar_6 = database.getReference("RUANG_MAWAR/"+kode_ruangan[5]);
    DatabaseReference mawar_7 = database.getReference("RUANG_MAWAR/"+kode_ruangan[6]);
    DatabaseReference mawar_8 = database.getReference("RUANG_MAWAR/"+kode_ruangan[7]);
    DatabaseReference mawar_9 = database.getReference("RUANG_MAWAR/"+kode_ruangan[8]);
    DatabaseReference mawar_10 = database.getReference("RUANG_MAWAR/"+kode_ruangan[9]);
    DatabaseReference mawar_11 = database.getReference("RUANG_MAWAR/"+kode_ruangan[10]);
    DatabaseReference mawar_12 = database.getReference("RUANG_MAWAR/"+kode_ruangan[11]);
    DatabaseReference mawar_13 = database.getReference("RUANG_MAWAR/"+kode_ruangan[12]);



    List<Dataku> list = new ArrayList<>();
    private static final String TAG = "Home";

    AdapterDataku adapterDataku;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pbHome = findViewById(R.id.pb_home);


        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification",
                    "My Notification", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        mawar_1.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
              Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
              String ruangan = (String) map.get("ruangan");

              long infusion_volume_1 = (long) map.get("infusion_volume_1");
              long infusion_alarm_1 = (long) map.get("infusion_alarm_1");
              long infusion_volume_2 = (long) map.get("infusion_volume_2");
              long infusion_alarm_2 = (long) map.get("infusion_alarm_2");


              int n1 = (int)infusion_volume_1;
              int a1 = (int)infusion_alarm_1;
              int n2 = (int)infusion_volume_2;
              int a2 = (int)infusion_alarm_2;

              if(n1 < a1){
                  String bed = "Bed 1";
                  showNotification(ruangan, bed);
              }else if(n2<a2){
                  String bed = "Bed 2";
                  showNotification(ruangan, bed);
              }

          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {

          }
      });
        mawar_2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                String ruangan = (String) map.get("ruangan");

                long infusion_volume_1 = (long) map.get("infusion_volume_1");
                long infusion_alarm_1 = (long) map.get("infusion_alarm_1");
                long infusion_volume_2 = (long) map.get("infusion_volume_2");
                long infusion_alarm_2 = (long) map.get("infusion_alarm_2");


                int n1 = (int)infusion_volume_1;
                int a1 = (int)infusion_alarm_1;
                int n2 = (int)infusion_volume_2;
                int a2 = (int)infusion_alarm_2;

                if(n1 < a1){
                    String bed = "Bed 1";
                    showNotification(ruangan, bed);
                }else if(n2<a2){
                    String bed = "Bed 2";
                    showNotification(ruangan, bed);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mawar_3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                String ruangan = (String) map.get("ruangan");

                long infusion_volume_1 = (long) map.get("infusion_volume_1");
                long infusion_alarm_1 = (long) map.get("infusion_alarm_1");
                long infusion_volume_2 = (long) map.get("infusion_volume_2");
                long infusion_alarm_2 = (long) map.get("infusion_alarm_2");


                int n1 = (int)infusion_volume_1;
                int a1 = (int)infusion_alarm_1;
                int n2 = (int)infusion_volume_2;
                int a2 = (int)infusion_alarm_2;

                if(n1 < a1){
                    String bed = "Bed 1";
                    showNotification(ruangan, bed);
                }else if(n2<a2){
                    String bed = "Bed 2";
                    showNotification(ruangan, bed);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mawar_4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                String ruangan = (String) map.get("ruangan");

                long infusion_volume_1 = (long) map.get("infusion_volume_1");
                long infusion_alarm_1 = (long) map.get("infusion_alarm_1");
                long infusion_volume_2 = (long) map.get("infusion_volume_2");
                long infusion_alarm_2 = (long) map.get("infusion_alarm_2");


                int n1 = (int)infusion_volume_1;
                int a1 = (int)infusion_alarm_1;
                int n2 = (int)infusion_volume_2;
                int a2 = (int)infusion_alarm_2;

                if(n1 < a1){
                    String bed = "Bed 1";
                    showNotification(ruangan, bed);
                }else if(n2<a2){
                    String bed = "Bed 2";
                    showNotification(ruangan, bed);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mawar_5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                String ruangan = (String) map.get("ruangan");

                long infusion_volume_1 = (long) map.get("infusion_volume_1");
                long infusion_alarm_1 = (long) map.get("infusion_alarm_1");
                long infusion_volume_2 = (long) map.get("infusion_volume_2");
                long infusion_alarm_2 = (long) map.get("infusion_alarm_2");


                int n1 = (int)infusion_volume_1;
                int a1 = (int)infusion_alarm_1;
                int n2 = (int)infusion_volume_2;
                int a2 = (int)infusion_alarm_2;

                if(n1 < a1){
                    String bed = "Bed 1";
                    showNotification(ruangan, bed);
                }else if(n2<a2){
                    String bed = "Bed 2";
                    showNotification(ruangan, bed);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mawar_6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                String ruangan = (String) map.get("ruangan");

                long infusion_volume_1 = (long) map.get("infusion_volume_1");
                long infusion_alarm_1 = (long) map.get("infusion_alarm_1");
                long infusion_volume_2 = (long) map.get("infusion_volume_2");
                long infusion_alarm_2 = (long) map.get("infusion_alarm_2");


                int n1 = (int)infusion_volume_1;
                int a1 = (int)infusion_alarm_1;
                int n2 = (int)infusion_volume_2;
                int a2 = (int)infusion_alarm_2;

                if(n1 < a1){
                    String bed = "Bed 1";
                    showNotification(ruangan, bed);
                }else if(n2<a2){
                    String bed = "Bed 2";
                    showNotification(ruangan, bed);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mawar_7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                String ruangan = (String) map.get("ruangan");

                long infusion_volume_1 = (long) map.get("infusion_volume_1");
                long infusion_alarm_1 = (long) map.get("infusion_alarm_1");
                long infusion_volume_2 = (long) map.get("infusion_volume_2");
                long infusion_alarm_2 = (long) map.get("infusion_alarm_2");


                int n1 = (int)infusion_volume_1;
                int a1 = (int)infusion_alarm_1;
                int n2 = (int)infusion_volume_2;
                int a2 = (int)infusion_alarm_2;

                if(n1 < a1){
                    String bed = "Bed 1";
                    showNotification(ruangan, bed);
                }else if(n2<a2){
                    String bed = "Bed 2";
                    showNotification(ruangan, bed);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mawar_8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                String ruangan = (String) map.get("ruangan");

                long infusion_volume_1 = (long) map.get("infusion_volume_1");
                long infusion_alarm_1 = (long) map.get("infusion_alarm_1");
                long infusion_volume_2 = (long) map.get("infusion_volume_2");
                long infusion_alarm_2 = (long) map.get("infusion_alarm_2");


                int n1 = (int)infusion_volume_1;
                int a1 = (int)infusion_alarm_1;
                int n2 = (int)infusion_volume_2;
                int a2 = (int)infusion_alarm_2;

                if(n1 < a1){
                    String bed = "Bed 1";
                    showNotification(ruangan, bed);
                }else if(n2<a2){
                    String bed = "Bed 2";
                    showNotification(ruangan, bed);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mawar_9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                String ruangan = (String) map.get("ruangan");

                long infusion_volume_1 = (long) map.get("infusion_volume_1");
                long infusion_alarm_1 = (long) map.get("infusion_alarm_1");
                long infusion_volume_2 = (long) map.get("infusion_volume_2");
                long infusion_alarm_2 = (long) map.get("infusion_alarm_2");


                int n1 = (int)infusion_volume_1;
                int a1 = (int)infusion_alarm_1;
                int n2 = (int)infusion_volume_2;
                int a2 = (int)infusion_alarm_2;

                if(n1 < a1){
                    String bed = "Bed 1";
                    showNotification(ruangan, bed);
                }else if(n2<a2){
                    String bed = "Bed 2";
                    showNotification(ruangan, bed);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mawar_10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                String ruangan = (String) map.get("ruangan");

                long infusion_volume_1 = (long) map.get("infusion_volume_1");
                long infusion_alarm_1 = (long) map.get("infusion_alarm_1");
                long infusion_volume_2 = (long) map.get("infusion_volume_2");
                long infusion_alarm_2 = (long) map.get("infusion_alarm_2");


                int n1 = (int)infusion_volume_1;
                int a1 = (int)infusion_alarm_1;
                int n2 = (int)infusion_volume_2;
                int a2 = (int)infusion_alarm_2;

                if(n1 < a1){
                    String bed = "Bed 1";
                    showNotification(ruangan, bed);
                }else if(n2<a2){
                    String bed = "Bed 2";
                    showNotification(ruangan, bed);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mawar_11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                String ruangan = (String) map.get("ruangan");

                long infusion_volume_1 = (long) map.get("infusion_volume_1");
                long infusion_alarm_1 = (long) map.get("infusion_alarm_1");
                long infusion_volume_2 = (long) map.get("infusion_volume_2");
                long infusion_alarm_2 = (long) map.get("infusion_alarm_2");


                int n1 = (int)infusion_volume_1;
                int a1 = (int)infusion_alarm_1;
                int n2 = (int)infusion_volume_2;
                int a2 = (int)infusion_alarm_2;

                if(n1 < a1){
                    String bed = "Bed 1";
                    showNotification(ruangan, bed);
                }else if(n2<a2){
                    String bed = "Bed 2";
                    showNotification(ruangan, bed);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mawar_12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                String ruangan = (String) map.get("ruangan");

                long infusion_volume_1 = (long) map.get("infusion_volume_1");
                long infusion_alarm_1 = (long) map.get("infusion_alarm_1");
                long infusion_volume_2 = (long) map.get("infusion_volume_2");
                long infusion_alarm_2 = (long) map.get("infusion_alarm_2");


                int n1 = (int)infusion_volume_1;
                int a1 = (int)infusion_alarm_1;
                int n2 = (int)infusion_volume_2;
                int a2 = (int)infusion_alarm_2;

                if(n1 < a1){
                    String bed = "Bed 1";
                    showNotification(ruangan, bed);
                }else if(n2<a2){
                    String bed = "Bed 2";
                    showNotification(ruangan, bed);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mawar_13.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                String ruangan = (String) map.get("ruangan");

                long infusion_volume_1 = (long) map.get("infusion_volume_1");
                long infusion_alarm_1 = (long) map.get("infusion_alarm_1");
                long infusion_volume_2 = (long) map.get("infusion_volume_2");
                long infusion_alarm_2 = (long) map.get("infusion_alarm_2");


                int n1 = (int)infusion_volume_1;
                int a1 = (int)infusion_alarm_1;
                int n2 = (int)infusion_volume_2;
                int a2 = (int)infusion_alarm_2;

                if(n1 < a1){
                    String bed = "Bed 1";
                    showNotification(ruangan, bed);
                }else if(n2<a2){
                    String bed = "Bed 2";
                    showNotification(ruangan, bed);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        fab_tambah = findViewById(R.id.fab_tambah);
        rv_data = findViewById(R.id.rv_data);

        rv_data.setLayoutManager(new LinearLayoutManager(this));

//        fab_tambah.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDialogTambahData();
//            }
//            public void onClick(View v){
//                startActivity(new Intent(MainActivity.this, UrineActivity.class));
//            }
//        });

        bacaData();


    }

    private void bacaData() {
        pbHome.setVisibility(View.VISIBLE);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Dataku value = snapshot.getValue(Dataku.class);
                    list.add(value);
                }
                adapterDataku = new AdapterDataku(MainActivity.this, list);
                rv_data.setAdapter(adapterDataku);
                setClick();
                pbHome.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
    }

    private void setClick() {
        adapterDataku.setOnCallBack(new AdapterDataku.OnCallBack() {
            @Override
            public void onLog1(Dataku dataku) {
                showUrineBagDetailBedSatu(dataku);
            }

            public void onLog2(Dataku dataku) {
                showUrineBagDetailBedDua(dataku);
            }

            @Override
            public void onBtnAlarm1(Dataku dataku) {
                showEditAlarm1(dataku);
            }

            public void onBtnAlarm2(Dataku dataku){
                showEditAlarm2(dataku);
            }


        });


    }

    private void showEditAlarm1(Dataku dataku) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_detail);

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(Objects.requireNonNull(dialog.getWindow()).getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);

        ImageButton btnClose = dialog.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                bacaData();
            }
        });
        Switch switch_1 = dialog.findViewById(R.id.sw_status);
        EditText infusion_alarm_1 = dialog.findViewById(R.id.infusion_alarm);
        EditText urine_alarm_1 = dialog.findViewById(R.id.urine_alarm);
        EditText calibrationVal = dialog.findViewById(R.id.calibration_val);
        Button btn_update =dialog.findViewById(R.id.btn_update);
        TextView title_1 = dialog.findViewById(R.id.title_1);

        Boolean switchState = switch_1.isChecked();


        title_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterDataku.notifyDataSetChanged();
            }
        });
        title_1.setText(dataku.getRuangan()+"/Bed 1");

        if (dataku.getStatus_1() == 1){
            switch_1.setChecked(true);

        }else{
            switch_1.setChecked(false);
        }

        switch_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    infusion_alarm_1.setVisibility(View.VISIBLE);
                    urine_alarm_1.setVisibility(View.VISIBLE);
                    btn_update.setVisibility(View.VISIBLE);
                }else{
                    infusion_alarm_1.setVisibility(View.GONE);
                    urine_alarm_1.setVisibility(View.GONE);
                    btn_update.setVisibility(View.GONE);
                }
            }
        });



        infusion_alarm_1.setText(String.valueOf(dataku.getInfusion_alarm_1()));
        urine_alarm_1.setText(String.valueOf(dataku.getUrine_alarm_1()));
        calibrationVal.setText(String.valueOf(dataku.getCalibration_1()));



        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(infusion_alarm_1.getText())){
                    infusion_alarm_1.setError("Sisa cairan infus harus diisi!");
                }else if(TextUtils.isEmpty(urine_alarm_1.getText())){
                    urine_alarm_1.setError("Batas volume urine bag harus diisi!");
                }
                else{
                    String ai = infusion_alarm_1.getText().toString();
                    String au = urine_alarm_1.getText().toString();
                    String calval = calibrationVal.getText().toString();

                    int alarm_infus = Integer.parseInt(ai);
                    int alarm_urine = Integer.parseInt(au);
                    int calibration = Integer.parseInt(calval);

                    editData1(dataku,calibration,alarm_infus,alarm_urine);
                    dialog.dismiss();
                }
            }
        });
        dialog.show();



    }

    private void showEditAlarm2(Dataku dataku) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_detail);

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(Objects.requireNonNull(dialog.getWindow()).getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);

        ImageButton btnClose = dialog.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                bacaData();
            }
        });
        Switch switch_1 = dialog.findViewById(R.id.sw_status);
        EditText infusion_alarm_1 = dialog.findViewById(R.id.infusion_alarm);
        EditText urine_alarm_1 = dialog.findViewById(R.id.urine_alarm);
        EditText calibrationVal = dialog.findViewById(R.id.calibration_val);
        Button btn_update =dialog.findViewById(R.id.btn_update);
        TextView title_1 = dialog.findViewById(R.id.title_1);


        Boolean switchState = switch_1.isChecked();


        title_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterDataku.notifyDataSetChanged();
            }
        });
        title_1.setText(dataku.getRuangan()+"/Bed 2");

        if (dataku.getStatus_2() == 1){
            switch_1.setChecked(true);

        }else{
            switch_1.setChecked(false);
        }

        switch_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    infusion_alarm_1.setVisibility(View.VISIBLE);
                    urine_alarm_1.setVisibility(View.VISIBLE);
                    btn_update.setVisibility(View.VISIBLE);
                }else{
                    infusion_alarm_1.setVisibility(View.GONE);
                    urine_alarm_1.setVisibility(View.GONE);
                    btn_update.setVisibility(View.GONE);
                }
            }
        });



        infusion_alarm_1.setText(String.valueOf(dataku.getInfusion_alarm_2()));
        urine_alarm_1.setText(String.valueOf(dataku.getUrine_alarm_2()));
        calibrationVal.setText(String.valueOf(dataku.getCalibration_2()));



        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(infusion_alarm_1.getText())){
                    infusion_alarm_1.setError("Sisa cairan infus harus diisi!");
                }else if(TextUtils.isEmpty(urine_alarm_1.getText())){
                    urine_alarm_1.setError("Batas volume urine bag harus diisi!");
                }
                else{
                    String ai = infusion_alarm_1.getText().toString();
                    String au = urine_alarm_1.getText().toString();
                    String calval = calibrationVal.getText().toString();

                    int alarm_infus = Integer.parseInt(ai);
                    int alarm_urine = Integer.parseInt(au);
                    int calibration = Integer.parseInt(calval);

                    editData2(dataku,calibration,alarm_infus,alarm_urine);
                    dialog.dismiss();
                }
            }
        });
        dialog.show();

    }

    private void showUrineBagDetailBedSatu(Dataku dataku) {
        String kodenya = dataku.getKunci();

        if (kodenya.equals(kode_ruangan[0])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_1_1");
            intent.putExtra("bedname", "Bed 1");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[1])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_1_2");
            intent.putExtra("bedname", "Bed 1");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[2])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_1_3");
            intent.putExtra("bedname", "Bed 1");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[3])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_1_4");
            intent.putExtra("bedname", "Bed 1");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[4])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_1_5");
            intent.putExtra("bedname", "Bed 1");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[5])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_1_6");
            intent.putExtra("bedname", "Bed 1");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[6])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_1_7");
            intent.putExtra("bedname", "Bed 1");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[7])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_1_8");
            intent.putExtra("bedname", "Bed 1");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[8])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_1_9");
            intent.putExtra("bedname", "Bed 1");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[9])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_1_10");
            intent.putExtra("bedname", "Bed 1");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[10])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_1_11");
            intent.putExtra("bedname", "Bed 1");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[11])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_1_12");
            intent.putExtra("bedname", "Bed 1");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[12])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_1_13");
            intent.putExtra("bedname", "Bed 1");
            startActivity(intent);
        }

    }

    private void showUrineBagDetailBedDua(Dataku dataku) {
        String kodenya = dataku.getKunci();
        if (kodenya.equals(kode_ruangan[0])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_2_1");
            intent.putExtra("bedname", "Bed 2");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[1])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_2_2");
            intent.putExtra("bedname", "Bed 2");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[2])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_2_3");
            intent.putExtra("bedname", "Bed 2");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[3])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_2_4");
            intent.putExtra("bedname", "Bed 2");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[4])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_2_5");
            intent.putExtra("bedname", "Bed 2");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[5])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_2_6");
            intent.putExtra("bedname", "Bed 2");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[6])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_2_7");
            intent.putExtra("bedname", "Bed 2");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[7])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_2_8");
            intent.putExtra("bedname", "Bed 2");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[8])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_2_9");
            intent.putExtra("bedname", "Bed 2");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[9])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_2_10");
            intent.putExtra("bedname", "Bed 2");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[10])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_2_11");
            intent.putExtra("bedname", "Bed 2");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[11])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_2_12");
            intent.putExtra("bedname", "Bed 2");
            startActivity(intent);
        }else if(kodenya.equals(kode_ruangan[12])){
            Intent intent = new Intent(MainActivity.this, UrineActivity.class);
            intent.putExtra("keyname", "urinebag_2_13");
            intent.putExtra("bedname", "Bed 2");
            startActivity(intent);
        }

    }

    private void editSwitch2(Dataku dataku, int a) {
        myRef.child(dataku.getKunci()).child("status_2").setValue(a);
    }

    private void editData1(Dataku dataku,int calibration, int alarm_infus,int alarm_urine) {
        myRef.child(dataku.getKunci()).child("infusion_alarm_1").setValue(alarm_infus);
        myRef.child(dataku.getKunci()).child("urine_alarm_1").setValue(alarm_urine);
        myRef.child(dataku.getKunci()).child("calibration_1").setValue(calibration);
        Toast.makeText(getApplicationContext(), " berhasil memperbaharui data!", Toast.LENGTH_SHORT).show();
    }
    private void editData2(Dataku dataku,int calibration,int alarm_infus,int alarm_urine) {
        myRef.child(dataku.getKunci()).child("infusion_alarm_2").setValue(alarm_infus);
        myRef.child(dataku.getKunci()).child("urine_alarm_2").setValue(alarm_urine);
        myRef.child(dataku.getKunci()).child("calibration_2").setValue(calibration);
        Toast.makeText(getApplicationContext(), " berhasil memperbaharui data!", Toast.LENGTH_SHORT).show();
    }

    private void hapusData(Dataku dataku) {
        myRef.child(dataku.getKunci()).removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(getApplicationContext(),dataku.getRuangan()+" berhasil dihapus!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showDialogTambahData() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_tambah_data);

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(Objects.requireNonNull(dialog.getWindow()).getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);

        ImageButton tblKeluar = dialog.findViewById(R.id.btn_close);
        tblKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        EditText room_name = dialog.findViewById(R.id.room_name);
//        EditText infus_level = dialog.findViewById(R.id.infus_level);
//        EditText drips_rate = dialog.findViewById(R.id.drips_rate);
//        EditText refil_time = dialog.findViewById(R.id.refil_time);
//        EditText urine_bag = dialog.findViewById(R.id.urine_bag);
        Button btn_simpan = dialog.findViewById(R.id.btn_simpan);

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(room_name.getText())){
                    room_name.setError("Nama ruangan harus diisi!");
                }else{
                    String ruangan = room_name.getText().toString();
                    int status_1=0;
                    int status_2=0;
                    int calibration_1=0;
                    int calibration_2=0;
                    long curtime_1=0;
                    long curtime_2=0;
                    int infusion_volume_1=0;
                    int infusion_volume_2=0;
                    int drops_rate_1=0;
                    int drops_rate_2=0;
                    int urine_volume_1=0;
                    int urine_volume_2=0;
                    int restore_hour_1=0;
                    int restore_hour_2=0;
                    int restore_minute_1=0;
                    int restore_minute_2=0;
                    int infusion_alarm_1=0;
                    int infusion_alarm_2=0;
                    int urine_alarm_1=0;
                    int urine_alarm_2=0;
                    simpanData(
                            ruangan,
                            status_1,
                            status_2,
                            calibration_1,
                            calibration_2,
                            curtime_1,
                            curtime_2,
                            infusion_volume_1,
                            infusion_volume_2,
                            drops_rate_1,
                            drops_rate_2,
                            urine_volume_1,
                            urine_volume_2,
                            restore_hour_1, restore_hour_2,
                            restore_minute_1,
                            restore_minute_2,
                            infusion_alarm_1,
                            infusion_alarm_2,
                            urine_alarm_1,
                            urine_alarm_2
                    );
                    dialog.dismiss();
                }
            }
        });
        dialog.show();

    }

    private void simpanData(String ruangan,
                            int status_1,
                            int status_2,
                            int calibration_1,
                            int calibration_2,
                            long curtime_1,
                            long curtime_2,
                            int infusion_volume_1,
                            int infusion_volume_2,
                            int drops_rate_1,
                            int drops_rate_2,
                            int urine_volume_1,
                            int urine_volume_2,
                            int restore_hour_1,
                            int restore_hour_2,
                            int restore_minute_1,
                            int restore_minute_2,
                            int infusion_alarm_1,
                            int infusion_alarm_2,
                            int urine_alarm_1,
                            int urine_alarm_2) {
        String kunci = myRef.push().getKey();
        Dataku dataku = new Dataku(
                kunci,
                ruangan,
                status_1,
                status_2,
                calibration_1,
                calibration_2,
                curtime_1,
                curtime_2,
                infusion_volume_1,
                infusion_volume_2,
                drops_rate_1,
                drops_rate_2,
                urine_volume_1,
                urine_volume_2,
                restore_hour_1, restore_hour_2,
                restore_minute_1,
                restore_minute_2,
                infusion_alarm_1,
                infusion_alarm_2,
                urine_alarm_1,
                urine_alarm_2);

        myRef.child(kunci).setValue(dataku).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(), "Berhasil menambahkan data...", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showNotification(String ruangan, String bed){


        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        final PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "My Notification");
        builder.setContentTitle("Pemberitahuan untuk Ruang "+ruangan);
        builder.setContentText("Mohon segera ganti cairan infus di "+bed+"!");
        builder.setSmallIcon(R.drawable.infusion);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
        managerCompat.notify(1,builder.build());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.about){
            Toast.makeText(this, "ini adalah about", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.setting) {
            Toast.makeText(this, "ini adalah setting", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.logout) {
            startActivity(new Intent(MainActivity.this, auth_activity.class));
            preferences.clearData(this);
            finish();
        }

        return true;
    }
}