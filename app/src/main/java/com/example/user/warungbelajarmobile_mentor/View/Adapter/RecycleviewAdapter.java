package com.example.user.warungbelajarmobile_mentor.View.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.example.user.warungbelajarmobile_mentor.Model.JadwalKursusMentor;
import com.example.user.warungbelajarmobile_mentor.R;

/**
 * Created by User on 06/01/2019.
 */

public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.MyHolder> {
    List<JadwalKursusMentor> listdata;

    public RecycleviewAdapter(List<JadwalKursusMentor> listdata) {
        this.listdata = listdata;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_jadwal_ngajar, parent, false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(MyHolder holder, int position) {
        JadwalKursusMentor data = listdata.get(position);
        holder.tv_namaKursus.setText(data.getJenis_kursus());
        holder.tv_jenisKursus.setText(data.getPaket());
        holder.tv_batch.setText(data.getBatch());
        holder.tv_hari1.setText(data.getJadwal().getHari1());
        holder.tv_jam1.setText(data.getJadwal().getJam_pertama());
        holder.tv_hari2.setText(data.getJadwal().getHari2());
        holder.tv_jam2.setText(data.getJadwal().getJam_kedua());
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {
        TextView tv_namaKursus, tv_jenisKursus, tv_batch, tv_hari1, tv_jam1, tv_hari2, tv_jam2;

        public MyHolder(View itemView) {
            super(itemView);
            tv_namaKursus = itemView.findViewById(R.id.tv_namaKursus);
            tv_jenisKursus = itemView.findViewById(R.id.tv_jenisKursus);
            tv_batch = itemView.findViewById(R.id.tv_batch);
            tv_hari1 = itemView.findViewById(R.id.tv_hari1);
            tv_jam1 = itemView.findViewById(R.id.tv_jam1);
            tv_hari2 = itemView.findViewById(R.id.tv_hari2);
            tv_jam2 = itemView.findViewById(R.id.tv_jam2);
        }
    }
}
