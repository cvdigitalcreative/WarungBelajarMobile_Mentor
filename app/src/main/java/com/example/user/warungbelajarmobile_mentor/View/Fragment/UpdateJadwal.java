package com.example.user.warungbelajarmobile_mentor.View.Fragment;


//import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.user.warungbelajarmobile_mentor.Model.SesiJadwal;
import com.example.user.warungbelajarmobile_mentor.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateJadwal extends Fragment {

    private Button btn_pesanJadwal;
    private CheckBox cb_SelasaSesi1, cb_SelasaSesi2, cb_SelasaSesi3, cb_SelasaSesi4,
            cb_RabuSesi1, cb_RabuSesi2, cb_RabuSesi3, cb_RabuSesi4,
            cb_KamisSesi1, cb_KamisSesi2, cb_KamisSesi3, cb_KamisSesi4,
            cb_JumatSesi1, cb_JumatSesi2, cb_JumatSesi3, cb_JumatSesi4,
            cb_SabtuSesi1, cb_SabtuSesi2, cb_SabtuSesi3, cb_SabtuSesi4,
            cb_MingguSesi1, cb_MingguSesi2, cb_MingguSesi3, cb_MingguSesi4;
    private DatabaseReference mDatabase;
    private String user;
    private ProgressDialog progressDialog;

    public UpdateJadwal() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_jadwal, container, false);

        receiveID();
        init(view);
        pesanJadwal();
        return view;
    }

    private void showProgressDialog(){
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Mohon Tunggu");
        progressDialog.show();
    }

    private void init(View view){
        btn_pesanJadwal = view.findViewById(R.id.btn_pesanJadwal);

        cb_SelasaSesi1 = view.findViewById(R.id.selasa_jam1);
        cb_SelasaSesi2 = view.findViewById(R.id.selasa_jam2);
        cb_SelasaSesi3 = view.findViewById(R.id.selasa_jam3);
        cb_SelasaSesi4 = view.findViewById(R.id.selasa_jam4);

        cb_RabuSesi1 = view.findViewById(R.id.rabu_jam1);
        cb_RabuSesi2 = view.findViewById(R.id.rabu_jam2);
        cb_RabuSesi3 = view.findViewById(R.id.rabu_jam3);
        cb_RabuSesi4 = view.findViewById(R.id.rabu_jam4);

        cb_KamisSesi1 = view.findViewById(R.id.kamis_jam1);
        cb_KamisSesi2 = view.findViewById(R.id.kamis_jam2);
        cb_KamisSesi3 = view.findViewById(R.id.kamis_jam3);
        cb_KamisSesi4 = view.findViewById(R.id.kamis_jam4);

        cb_JumatSesi1 = view.findViewById(R.id.jumat_jam1);
        cb_JumatSesi2 = view.findViewById(R.id.jumat_jam2);
        cb_JumatSesi3 = view.findViewById(R.id.jumat_jam3);
        cb_JumatSesi4 = view.findViewById(R.id.jumat_jam4);

        cb_SabtuSesi1 = view.findViewById(R.id.sabtu_jam1);
        cb_SabtuSesi2 = view.findViewById(R.id.sabtu_jam2);
        cb_SabtuSesi3 = view.findViewById(R.id.sabtu_jam3);
        cb_SabtuSesi4 = view.findViewById(R.id.sabtu_jam4);

        cb_MingguSesi1 = view.findViewById(R.id.minggu_jam1);
        cb_MingguSesi2 = view.findViewById(R.id.minggu_jam2);
        cb_MingguSesi3 = view.findViewById(R.id.minggu_jam3);
        cb_MingguSesi4 = view.findViewById(R.id.minggu_jam4);

        initAction();
    }

    private void initAction(){
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String status;

                //selasa
                status = dataSnapshot.child("selasa").child("sesi1").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_SelasaSesi1.setChecked(true);

                status = dataSnapshot.child("selasa").child("sesi2").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_SelasaSesi2.setChecked(true);

                status = dataSnapshot.child("selasa").child("sesi3").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_SelasaSesi3.setChecked(true);

                status = dataSnapshot.child("selasa").child("sesi4").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_SelasaSesi4.setChecked(true);

                //rabu
                status = dataSnapshot.child("rabu").child("sesi1").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_RabuSesi1.setChecked(true);

                status = dataSnapshot.child("rabu").child("sesi2").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_RabuSesi2.setChecked(true);

                status = dataSnapshot.child("rabu").child("sesi3").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_RabuSesi3.setChecked(true);

                status = dataSnapshot.child("rabu").child("sesi4").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_RabuSesi4.setChecked(true);

                //kamis
                status = dataSnapshot.child("kamis").child("sesi1").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_KamisSesi1.setChecked(true);

                status = dataSnapshot.child("kamis").child("sesi2").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_KamisSesi2.setChecked(true);

                status = dataSnapshot.child("kamis").child("sesi3").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_KamisSesi3.setChecked(true);

                status = dataSnapshot.child("kamis").child("sesi4").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_KamisSesi4.setChecked(true);

                //jumat
                status = dataSnapshot.child("jumat").child("sesi1").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_JumatSesi1.setChecked(true);

                status = dataSnapshot.child("jumat").child("sesi2").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_JumatSesi2.setChecked(true);

                status = dataSnapshot.child("jumat").child("sesi3").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_JumatSesi3.setChecked(true);

                status = dataSnapshot.child("jumat").child("sesi4").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_JumatSesi4.setChecked(true);

                //sabtu
                status = dataSnapshot.child("sabtu").child("sesi1").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_SabtuSesi1.setChecked(true);

                status = dataSnapshot.child("sabtu").child("sesi2").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_SabtuSesi2.setChecked(true);

                status = dataSnapshot.child("sabtu").child("sesi3").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_SabtuSesi3.setChecked(true);

                status = dataSnapshot.child("sabtu").child("sesi4").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_SabtuSesi4.setChecked(true);

                //minggu
                status = dataSnapshot.child("minggu").child("sesi1").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_MingguSesi1.setChecked(true);

                status = dataSnapshot.child("minggu").child("sesi2").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_MingguSesi2.setChecked(true);

                status = dataSnapshot.child("minggu").child("sesi3").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_MingguSesi3.setChecked(true);

                status = dataSnapshot.child("minggu").child("sesi4").child("status").getValue().toString();
                if(status.equals("Aktif"))
                    cb_MingguSesi4.setChecked(true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Gagal Menampilkan Data", Toast.LENGTH_LONG).show();
                return;
            }
        });
    }

    private void receiveID(){
        user = getArguments().getString("id_user");
        mDatabase = FirebaseDatabase.getInstance().getReference().child("mentor").child(user).child("jadwal_mentor");
    }

    private void pesanJadwal(){
        btn_pesanJadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateJadwalSelasa();
                updateJadwalRabu();
                updateJadwalKamis();
                updateJadwalJumat();
                updateJadwalSabtu();
                updateJadwalMinggu();
                Toast.makeText(getActivity(), "Sesi Jadwal Berhasil Diubah", Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }

    private void updateJadwalSelasa(){
        String jam, status;

        if(cb_SelasaSesi1.isChecked()){
            jam = cb_SelasaSesi1.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_SelasaSesi1.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi1 = new SesiJadwal();
        sesi1.setJam(jam);
        sesi1.setStatus(status);
        mDatabase.child("selasa").child("sesi1").setValue(sesi1);

        if(cb_SelasaSesi2.isChecked()){
            jam = cb_SelasaSesi2.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_SelasaSesi2.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi2 = new SesiJadwal();
        sesi2.setJam(jam);
        sesi2.setStatus(status);
        mDatabase.child("selasa").child("sesi2").setValue(sesi2);

        if(cb_SelasaSesi3.isChecked()){
            jam = cb_SelasaSesi3.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_SelasaSesi3.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi3 = new SesiJadwal();
        sesi3.setJam(jam);
        sesi3.setStatus(status);
        mDatabase.child("selasa").child("sesi3").setValue(sesi3);

        if(cb_SelasaSesi4.isChecked()){
            jam = cb_SelasaSesi4.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_SelasaSesi4.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi4 = new SesiJadwal();
        sesi4.setJam(jam);
        sesi4.setStatus(status);
        mDatabase.child("selasa").child("sesi4").setValue(sesi4);
    }

    private void updateJadwalRabu(){
        String jam, status;

        if(cb_RabuSesi1.isChecked()){
            jam = cb_RabuSesi1.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_RabuSesi1.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi1 = new SesiJadwal();
        sesi1.setJam(jam);
        sesi1.setStatus(status);
        mDatabase.child("rabu").child("sesi1").setValue(sesi1);

        if(cb_RabuSesi2.isChecked()){
            jam = cb_RabuSesi2.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_RabuSesi2.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi2 = new SesiJadwal();
        sesi2.setJam(jam);
        sesi2.setStatus(status);
        mDatabase.child("rabu").child("sesi2").setValue(sesi2);

        if(cb_RabuSesi3.isChecked()){
            jam = cb_RabuSesi3.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_RabuSesi3.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi3 = new SesiJadwal();
        sesi3.setJam(jam);
        sesi3.setStatus(status);
        mDatabase.child("rabu").child("sesi3").setValue(sesi3);

        if(cb_RabuSesi4.isChecked()){
            jam = cb_RabuSesi4.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_RabuSesi4.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi4 = new SesiJadwal();
        sesi4.setJam(jam);
        sesi4.setStatus(status);
        mDatabase.child("rabu").child("sesi4").setValue(sesi4);
    }

    private void updateJadwalKamis(){
        String jam, status;

        if(cb_KamisSesi1.isChecked()){
            jam = cb_KamisSesi1.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_KamisSesi1.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi1 = new SesiJadwal();
        sesi1.setJam(jam);
        sesi1.setStatus(status);
        mDatabase.child("kamis").child("sesi1").setValue(sesi1);

        if(cb_KamisSesi2.isChecked()){
            jam = cb_KamisSesi2.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_KamisSesi2.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi2 = new SesiJadwal();
        sesi2.setJam(jam);
        sesi2.setStatus(status);
        mDatabase.child("kamis").child("sesi2").setValue(sesi2);

        if(cb_KamisSesi3.isChecked()){
            jam = cb_KamisSesi3.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_KamisSesi3.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi3 = new SesiJadwal();
        sesi3.setJam(jam);
        sesi3.setStatus(status);
        mDatabase.child("kamis").child("sesi3").setValue(sesi3);

        if(cb_KamisSesi4.isChecked()){
            jam = cb_KamisSesi4.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_KamisSesi4.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi4 = new SesiJadwal();
        sesi4.setJam(jam);
        sesi4.setStatus(status);
        mDatabase.child("kamis").child("sesi4").setValue(sesi4);
    }

    private void updateJadwalJumat(){
        String jam, status;

        if(cb_JumatSesi1.isChecked()){
            jam = cb_JumatSesi1.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_JumatSesi1.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi1 = new SesiJadwal();
        sesi1.setJam(jam);
        sesi1.setStatus(status);
        mDatabase.child("jumat").child("sesi1").setValue(sesi1);

        if(cb_JumatSesi2.isChecked()){
            jam = cb_JumatSesi2.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_JumatSesi2.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi2 = new SesiJadwal();
        sesi2.setJam(jam);
        sesi2.setStatus(status);
        mDatabase.child("jumat").child("sesi2").setValue(sesi2);

        if(cb_JumatSesi3.isChecked()){
            jam = cb_JumatSesi3.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_JumatSesi3.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi3 = new SesiJadwal();
        sesi3.setJam(jam);
        sesi3.setStatus(status);
        mDatabase.child("jumat").child("sesi3").setValue(sesi3);

        if(cb_JumatSesi4.isChecked()){
            jam = cb_JumatSesi4.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_JumatSesi4.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi4 = new SesiJadwal();
        sesi4.setJam(jam);
        sesi4.setStatus(status);
        mDatabase.child("jumat").child("sesi4").setValue(sesi4);
    }

    private void updateJadwalSabtu(){
        String jam, status;

        if(cb_SabtuSesi1.isChecked()){
            jam = cb_SabtuSesi1.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_SabtuSesi1.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi1 = new SesiJadwal();
        sesi1.setJam(jam);
        sesi1.setStatus(status);
        mDatabase.child("sabtu").child("sesi1").setValue(sesi1);

        if(cb_SabtuSesi2.isChecked()){
            jam = cb_SabtuSesi2.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_SabtuSesi2.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi2 = new SesiJadwal();
        sesi2.setJam(jam);
        sesi2.setStatus(status);
        mDatabase.child("sabtu").child("sesi2").setValue(sesi2);

        if(cb_SabtuSesi3.isChecked()){
            jam = cb_SabtuSesi3.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_SabtuSesi3.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi3 = new SesiJadwal();
        sesi3.setJam(jam);
        sesi3.setStatus(status);
        mDatabase.child("sabtu").child("sesi3").setValue(sesi3);

        if(cb_SabtuSesi4.isChecked()){
            jam = cb_SabtuSesi4.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_SabtuSesi4.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi4 = new SesiJadwal();
        sesi4.setJam(jam);
        sesi4.setStatus(status);
        mDatabase.child("sabtu").child("sesi4").setValue(sesi4);
    }

    private void updateJadwalMinggu(){
        String jam, status;

        if(cb_MingguSesi1.isChecked()){
            jam = cb_MingguSesi1.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_MingguSesi1.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi1 = new SesiJadwal();
        sesi1.setJam(jam);
        sesi1.setStatus(status);
        mDatabase.child("minggu").child("sesi1").setValue(sesi1);

        if(cb_MingguSesi2.isChecked()){
            jam = cb_MingguSesi2.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_MingguSesi2.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi2 = new SesiJadwal();
        sesi2.setJam(jam);
        sesi2.setStatus(status);
        mDatabase.child("minggu").child("sesi2").setValue(sesi2);

        if(cb_MingguSesi3.isChecked()){
            jam = cb_MingguSesi3.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_MingguSesi3.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi3 = new SesiJadwal();
        sesi3.setJam(jam);
        sesi3.setStatus(status);
        mDatabase.child("minggu").child("sesi3").setValue(sesi3);

        if(cb_MingguSesi4.isChecked()){
            jam = cb_MingguSesi4.getText().toString().trim();
            status = "Aktif";
        }
        else{
            jam = cb_MingguSesi4.getText().toString().trim();
            status = "Tidak Aktif";
        }

        SesiJadwal sesi4 = new SesiJadwal();
        sesi4.setJam(jam);
        sesi4.setStatus(status);
        mDatabase.child("minggu").child("sesi4").setValue(sesi4);
    }

}
