package com.example.umairfyp.model.Batsman_data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Totals {

    @SerializedName("R")
    @Expose
    private Integer r;
    @SerializedName("O")
    @Expose
    private Double o;
    @SerializedName("W")
    @Expose
    private Integer w;
    @SerializedName("RR")
    @Expose
    private Double rr;

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public Double getO() {
        return o;
    }

    public void setO(Double o) {
        this.o = o;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Double getRr() {
        return rr;
    }

    public void setRr(Double rr) {
        this.rr = rr;
    }

}