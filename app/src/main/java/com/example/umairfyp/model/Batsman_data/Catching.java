package com.example.umairfyp.model.Batsman_data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Catching {

    @SerializedName("stumped")
    @Expose
    private Integer stumped;
    @SerializedName("runout")
    @Expose
    private Integer runout;
    @SerializedName("catch")
    @Expose
    private Integer _catch;
    @SerializedName("catcher")
    @Expose
    private Catcher__1 catcher;

    public Integer getStumped() {
        return stumped;
    }

    public void setStumped(Integer stumped) {
        this.stumped = stumped;
    }

    public Integer getRunout() {
        return runout;
    }

    public void setRunout(Integer runout) {
        this.runout = runout;
    }

    public Integer getCatch() {
        return _catch;
    }

    public void setCatch(Integer _catch) {
        this._catch = _catch;
    }

    public Catcher__1 getCatcher() {
        return catcher;
    }

    public void setCatcher(Catcher__1 catcher) {
        this.catcher = catcher;
    }

}