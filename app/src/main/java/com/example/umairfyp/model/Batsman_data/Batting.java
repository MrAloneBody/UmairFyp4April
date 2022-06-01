package com.example.umairfyp.model.Batsman_data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Batting {

    @SerializedName("batsman")
    @Expose
    private Batsman batsman;
    @SerializedName("dismissal")
    @Expose
    private String dismissal;
    @SerializedName("bowler")
    @Expose
    private Bowler bowler;
    @SerializedName("catcher")
    @Expose
    private Catcher catcher;
    @SerializedName("dismissal-text")
    @Expose
    private String dismissalText;
    @SerializedName("r")
    @Expose
    private Integer r;
    @SerializedName("b")
    @Expose
    private Integer b;
    @SerializedName("4s")
    @Expose
    private Integer _4s;
    @SerializedName("6s")
    @Expose
    private Integer _6s;
    @SerializedName("sr")
    @Expose
    private Double sr;

    public Batsman getBatsman() {
        return batsman;
    }

    public void setBatsman(Batsman batsman) {
        this.batsman = batsman;
    }

    public String getDismissal() {
        return dismissal;
    }

    public void setDismissal(String dismissal) {
        this.dismissal = dismissal;
    }

    public Bowler getBowler() {
        return bowler;
    }

    public void setBowler(Bowler bowler) {
        this.bowler = bowler;
    }

    public Catcher getCatcher() {
        return catcher;
    }

    public void setCatcher(Catcher catcher) {
        this.catcher = catcher;
    }

    public String getDismissalText() {
        return dismissalText;
    }

    public void setDismissalText(String dismissalText) {
        this.dismissalText = dismissalText;
    }

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

    public Integer get4s() {
        return _4s;
    }

    public void set4s(Integer _4s) {
        this._4s = _4s;
    }

    public Integer get6s() {
        return _6s;
    }

    public void set6s(Integer _6s) {
        this._6s = _6s;
    }

    public Double getSr() {
        return sr;
    }

    public void setSr(Double sr) {
        this.sr = sr;
    }

}