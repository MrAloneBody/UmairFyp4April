package com.example.umairfyp.model.Batsman_data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Extras {

    @SerializedName("r")
    @Expose
    private Integer r;
    @SerializedName("b")
    @Expose
    private Integer b;
    @SerializedName("lb")
    @Expose
    private Integer lb;
    @SerializedName("w")
    @Expose
    private Integer w;
    @SerializedName("nb")
    @Expose
    private Integer nb;
    @SerializedName("p")
    @Expose
    private Integer p;

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getLb() {
        return lb;
    }

    public void setLb(Integer lb) {
        this.lb = lb;
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

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

}