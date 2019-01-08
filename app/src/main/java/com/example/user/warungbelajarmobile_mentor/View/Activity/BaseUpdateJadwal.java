package com.example.user.warungbelajarmobile_mentor.View.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.user.warungbelajarmobile_mentor.R;
import com.example.user.warungbelajarmobile_mentor.View.Fragment.*;

public class BaseUpdateJadwal extends AppCompatActivity{

    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_update_jadwal);

        receiveID();
        goToUpdateJadwal();
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
