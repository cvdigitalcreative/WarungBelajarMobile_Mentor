package com.example.user.warungbelajarmobile_mentor.View.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.example.user.warungbelajarmobile_mentor.R;
import com.example.user.warungbelajarmobile_mentor.View.Fragment.JadwalNgajar;

public class BaseJadwalNgajar extends AppCompatActivity{

    private String user;
    private ImageView ivBack;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ivBack = (ImageView) findViewById(R.id.ivBack);
        setContentView(R.layout.activity_base_jadwal_ngajar);

        receiveID();
        goToJadwalNgajar();

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void receiveID(){
        user = getIntent().getStringExtra("id_user");
    }

    private void goToJadwalNgajar(){
        Bundle bundle = new Bundle();
        bundle.putString("id_user", user);

        JadwalNgajar jadwalNgajar = new JadwalNgajar();
        jadwalNgajar.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.container_fragment_jadwal_ngajar, jadwalNgajar, "jadwal_ngajar").commit();
    }
}
