package com.example.user.warungbelajarmobile_mentor.View.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.warungbelajarmobile_mentor.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity{
    private String id_user;
    private TextView tv_name, tv_number;
    private ImageView iv_qr_code;
    private DatabaseReference ref;
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ivBack = (ImageView) findViewById(R.id.ivBack);
        setContentView(R.layout.activity_profile);

        receiveID();
        init();
        viewProfile();

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void viewProfile(){
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String nama = dataSnapshot.child(id_user).child("profile_mentor").child("nama").getValue().toString();
                String nomor = dataSnapshot.child(id_user).child("profile_mentor").child("nomor").getValue().toString();

                tv_name.setText(nama);
                tv_number.setText(nomor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void receiveID(){
        id_user = getIntent().getStringExtra("id_user");
        ref = FirebaseDatabase.getInstance().getReference("mentor");
    }

    private void init(){
        tv_name = findViewById(R.id.tv_name);
        tv_number = findViewById(R.id.tv_number);
    }
}
