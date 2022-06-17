package com.example.umairfyp.model.Batsman_data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model_Batsman {

    @SerializedName("apikey")
    @Expose
    private String apikey;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("info")
    @Expose
    private Info info;

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}