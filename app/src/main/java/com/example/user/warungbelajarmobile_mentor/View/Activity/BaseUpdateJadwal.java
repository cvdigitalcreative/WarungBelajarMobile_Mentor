package com.example.user.warungbelajarmobile_mentor.View.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.user.warungbelajarmobile_mentor.R;
import com.example.user.warungbelajarmobile_mentor.View.Fragment.*;

public class BaseUpdateJadwal extends AppCompatActivity{

    private String user;
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_update_jadwal);

        init();
        receiveID();
        sentoHome();
        goToUpdateJadwal();
    }

    private void init(){
        ivBack = findViewById(R.id.ivBack);
        user = getIntent().getStringExtra("id_user");
    }

    private void sentoHome() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseUpdateJadwal.this, MenuUtama.class);
                intent.putExtra("id_user", user);
                startActivity(intent);
            }
        });
    }

    private void receiveID(){
        user = getIntent().getStringExtra("id_user");
    }

    private void goToUpdateJadwal(){
        Bundle bundle = new Bundle();
        bundle.putString("id_user",user);

        UpdateJadwal updateJadwal = new UpdateJadwal();
        updateJadwal.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.container_fragment_update_jadwal, updateJadwal, "update_jadwal").commit();
    }


}
