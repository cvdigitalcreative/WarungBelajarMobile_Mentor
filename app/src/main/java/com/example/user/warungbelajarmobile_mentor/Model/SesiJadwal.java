package com.example.user.warungbelajarmobile_mentor.Model;

/**
 * Created by User on 05/01/2019.
 */

public class SesiJadwal {
    private String jam, status;

    public SesiJadwal(){}

    public SesiJadwal(String jam, String status){
        this.jam = jam;
        this.status = status;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
