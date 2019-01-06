package com.example.user.warungbelajarmobile_mentor.View.Fragment;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.user.warungbelajarmobile_mentor.Model.Jadwal;
import com.example.user.warungbelajarmobile_mentor.Model.JadwalKursusMentor;
import com.example.user.warungbelajarmobile_mentor.R;
import com.example.user.warungbelajarmobile_mentor.View.Adapter.RecycleviewAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class JadwalNgajar extends Fragment {
    private RecyclerView rv_jadwal_ngajar;
    private DatabaseReference mDatabase;
    private String user;
    private List<JadwalKursusMentor> list;

    public JadwalNgajar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jadwal_ngajar, container, false);

        receiveID();
        init(view);
        jadwalKursusMentor();
        return view;
    }

    public void init(View view){
        rv_jadwal_ngajar = view.findViewById(R.id.rv_jadwal_ngajar);
        rv_jadwal_ngajar.setHasFixedSize(true);
        LinearLayoutManager MyLinearLayoutManager = new LinearLayoutManager(getActivity());
        rv_jadwal_ngajar.setLayoutManager(MyLinearLayoutManager);
    }

    private void receiveID(){
        user = getArguments().getString("id_user");
        mDatabase = FirebaseDatabase.getInstance().getReference().child("mentor").child(user).child("jadwal_kursus_mentor");
    }

    private void jadwalKursusMentor(){
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    JadwalKursusMentor listdata = new JadwalKursusMentor();
                    String jenis_kursus = dataSnapshot1.child("jenis_kursus").getValue().toString();
                    String paket = dataSnapshot1.child("paket").getValue().toString();
                    String batch = dataSnapshot1.child("batch").getValue().toString();
                    String hari1 = dataSnapshot1.child("jadwal").child("hari1").toString();
                    String jam1 = dataSnapshot1.child("jadwal").child("jam1").toString();
                    String hari2 = dataSnapshot1.child("jadwal").child("hari2").toString();
                    String jam2 = dataSnapshot1.child("jadwal").child("jam2").toString();
                    Jadwal jadwal = new Jadwal();
                    jadwal.setHari1(hari1);
                    jadwal.setJam_pertama(jam1);
                    jadwal.setHari2(hari2);
                    jadwal.setJam_kedua(jam2);
                    listdata.setPaket(paket);
                    listdata.setJenis_kursus(jenis_kursus);
                    listdata.setBatch(batch);
                    listdata.setJadwal(jadwal);
                }
                RecycleviewAdapter recycler = new RecycleviewAdapter(list);
                RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getActivity());
                rv_jadwal_ngajar.setLayoutManager(layoutmanager);
                rv_jadwal_ngajar.setItemAnimator( new DefaultItemAnimator());
                rv_jadwal_ngajar.setAdapter(recycler);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Gagal Menampilkan Data", Toast.LENGTH_LONG).show();
                return;
            }
        });
    }
}
