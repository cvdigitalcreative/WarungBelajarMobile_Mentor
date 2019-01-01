package com.example.user.warungbelajarmobile_mentor.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.user.warungbelajarmobile_mentor.R;

public class MenuUtama extends AppCompatActivity{
    private Button btn_updateJadwal, btn_jadwalMengajar, btn_profile;
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        user = getIntent().getStringExtra("id_user");
        init();
        updateJadwal();
        jadwalMengajar();
        viewProfile();
    }

    private void init(){
        btn_updateJadwal = findViewById(R.id.btn_updateJadwal);
        btn_jadwalMengajar = findViewById(R.id.btn_jadwalMengajar);
        btn_profile = findViewById(R.id.btn_profile);
    }

    private void updateJadwal(){
        btn_updateJadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, BaseUpdateJadwal.class);
                intent.putExtra("id_user", user);
                startActivity(intent);
            }
        });
    }

    private void jadwalMengajar(){
        btn_jadwalMengajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, BaseJadwalNgajar.class);
                intent.putExtra("id_user", user);
                startActivity(intent);
            }
        });
    }

    private void viewProfile(){
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, Profile.class);
                intent.putExtra("id_user", user);
                startActivity(intent);
            }
        });
    }

}
