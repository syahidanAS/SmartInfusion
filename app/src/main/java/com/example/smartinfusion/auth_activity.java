package com.example.smartinfusion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class auth_activity extends AppCompatActivity {
    private EditText nip, password;
    private Button btn_login;
    Switch sw_login;
    ProgressBar pbAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_activity);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        nip = findViewById(R.id.nip);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        sw_login = findViewById(R.id.sw_login);
        pbAuth = findViewById(R.id.pb_auth);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                databaseReference.child("authentication").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String input1 = nip.getText().toString();
                        String input2 = password.getText().toString();
                        pbAuth.setVisibility(View.VISIBLE);
                        if (snapshot.child(input1).exists()){
                           if(snapshot.child(input1).child("password").getValue(String.class).equals(input2)){
                               if(sw_login.isChecked()){
                                   if (snapshot.child(input1).child("as").getValue(String.class).equals("admin")){
                                       preferences.setDataLogin(auth_activity.this, true);
                                       preferences.setDataAs(auth_activity.this,"admin");
                                       startActivity(new Intent(auth_activity.this, AdminActivity.class));

                                   }else if (snapshot.child(input1).child("as").getValue(String.class).equals("user")){
                                       preferences.setDataLogin(auth_activity.this, true);
                                       preferences.setDataAs(auth_activity.this,"user");
                                       startActivity(new Intent(auth_activity.this, MainActivity.class));
                                   }
                               }else {
                                   if (snapshot.child(input1).child("as").getValue(String.class).equals("admin")){
                                       preferences.setDataLogin(auth_activity.this, false);
                                       startActivity(new Intent(auth_activity.this, AdminActivity.class));

                                   }else if (snapshot.child(input1).child("as").getValue(String.class).equals("user")){
                                       preferences.setDataLogin(auth_activity.this, false);
                                       startActivity(new Intent(auth_activity.this, MainActivity.class));
                                   }

                               }

                           }else{
                               Toast.makeText(auth_activity.this, "Kata sandi tidak terdaftar", Toast.LENGTH_SHORT).show();
                           }
                        }else{
                            Toast.makeText(auth_activity.this, "Data tidak tersedia", Toast.LENGTH_SHORT).show();
                        }
                        pbAuth.setVisibility(View.GONE);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(preferences.getDataLogin(this)){
            if(preferences.getDataAs(this).equals("admin")){
                startActivity(new Intent(auth_activity.this, AdminActivity.class));
                finish();
            }else if(preferences.getDataAs(this).equals("user")){
                startActivity(new Intent(auth_activity.this, MainActivity.class));
                finish();
            }
        }
    }

    public void onLoginClick(View view){
        startActivity(new Intent(this, RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
    }
}