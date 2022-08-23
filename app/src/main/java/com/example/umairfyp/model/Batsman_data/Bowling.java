package com.example.umairfyp.model.Batsman_data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bowling {

    @SerializedName("bowler")
    @Expose
    private Bowler__1 bowler;
    @SerializedName("o")
    @Expose
    private Float o;
    @SerializedName("m")
    @Expose
    private Integer m;
    @SerializedName("r")
    @Expose
    private Integer r;
    @SerializedName("w")
    @Expose
    private Integer w;
    @SerializedName("nb")
    @Expose
    private Integer nb;
    @SerializedName("wd")
    @Expose
    private Integer wd;
    @SerializedName("eco")
    @Expose
    private Double eco;

    public Bowler__1 getBowler() {
        return bowler;
    }

    public void setBowler(Bowler__1 bowler) {
        this.bowler = bowler;
    }

    public Float getO() {
        return o;
    }

    public void setO(Float o) {
        this.o = o;
    }

    public Integer getM() {
        return m;
    }

    public void setM(Integer m) {
        this.m = m;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Integer getNb() {
        return nb;
    }

    public void setNb(Integer nb) {
        this.nb = nb;
    }

    public Integer getWd() {
        return wd;
    }

    public void setWd(Integer wd) {
        this.wd = wd;
    }

    public Double getEco() {
        return eco;
    }

    public void setEco(Double eco) {
        this.eco = eco;
    }

}