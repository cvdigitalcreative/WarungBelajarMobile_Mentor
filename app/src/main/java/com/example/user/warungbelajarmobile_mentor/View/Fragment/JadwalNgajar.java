package com.example.user.warungbelajarmobile_mentor.View.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.warungbelajarmobile_mentor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JadwalNgajar extends Fragment {
    private RecyclerView rv_jadwal_ngajar;

    public JadwalNgajar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jadwal_ngajar, container, false);

        init(view);


        return view;
    }

    public void init(View view){
        rv_jadwal_ngajar = view.findViewById(R.id.rv_jadwal_ngajar);
        rv_jadwal_ngajar.setHasFixedSize(true);
        LinearLayoutManager MyLinearLayoutManager = new LinearLayoutManager(getActivity());
        rv_jadwal_ngajar.setLayoutManager(MyLinearLayoutManager);


    }
}
