package com.example.smartinfusion;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartinfusion.controller.AdapterUrine;
import com.example.smartinfusion.controller.DataUrine;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UrineActivity extends AppCompatActivity {
    RecyclerView rvDataUrine;
    ProgressBar pbLoading;
    SearchView svUrine;
    LinearLayout dataKosong;
    List<DataUrine> list = new ArrayList<>();

    private static final String TAG = "Home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urine);
        String bedKey = getIntent().getStringExtra("keyname");

        rvDataUrine = findViewById(R.id.rv_data_urine);
        dataKosong = findViewById(R.id.data_kosong);
        svUrine = findViewById(R.id.sv_urine);
        rvDataUrine.setLayoutManager(new LinearLayoutManager(this));

        pbLoading = findViewById(R.id.pb_loading);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(bedKey);

//        bacaData();
        // Read from the database


        if(myRef != null){
            pbLoading.setVisibility(View.VISIBLE);
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    pbLoading.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                        DataUrine value = snapshot.getValue(DataUrine.class);
                        list.add(value);
                    }
                    rvDataUrine.setAdapter(new AdapterUrine(UrineActivity.this, list));
                    pbLoading.setVisibility(View.GONE);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });
        }else{
            rvDataUrine.setVisibility(View.GONE);
            dataKosong.setVisibility(View.VISIBLE);

        }

        if (svUrine != null){
            svUrine.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;
                }
            });
        }



    }

    private void search(String str) {
        ArrayList<DataUrine> myList = new ArrayList<>();
        for(DataUrine object : list){
            if(object.getTanggal().toLowerCase().contains(str.toLowerCase())){
                myList.add(object);
            }
        }
        AdapterUrine adapterUrine = new AdapterUrine(myList);
        rvDataUrine.setAdapter(adapterUrine);
    }

}

//    private void bacaData() {
//        // Read from the database
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                list.clear();
//                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    DataUrine value = snapshot.getValue(DataUrine.class);
//                    list.add(value);
//                }
//                rvDataUrine.setAdapter(new AdapterUrine(UrineActivity.this, list));
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
//    }
