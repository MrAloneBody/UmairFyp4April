package com.example.umairfyp.model.Batsman_data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Scorecard {

    @SerializedName("batting")
    @Expose
    private List<Batting> batting = null;
    @SerializedName("bowling")
    @Expose
    private List<Bowling> bowling = null;
    @SerializedName("catching")
    @Expose
    private List<Catching> catching = null;
    @SerializedName("extras")
    @Expose
    private Extras extras;
    @SerializedName("totals")
    @Expose
    private Totals totals;
    @SerializedName("inning")
    @Expose
    private String inning;

    public List<Batting> getBatting() {
        return batting;
    }

    public void setBatting(List<Batting> batting) {
        this.batting = batting;
    }

    public List<Bowling> getBowling() {
        return bowling;
    }

    public void setBowling(List<Bowling> bowling) {
        this.bowling = bowling;
    }

    public List<Catching> getCatching() {
        return catching;
    }

    public void setCatching(List<Catching> catching) {
        this.catching = catching;
    }

    public Extras getExtras() {
        return extras;
    }

    public void setExtras(Extras extras) {
        this.extras = extras;
    }

    public Totals getTotals() {
        return totals;
    }

    public void setTotals(Totals totals) {
        this.totals = totals;
    }

    public String getInning() {
        return inning;
    }

    public void setInning(String inning) {
        this.inning = inning;
    }

}