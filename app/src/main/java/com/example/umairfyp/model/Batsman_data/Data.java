package com.example.umairfyp.model.Batsman_data;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("matchType")
    @Expose
    private String matchType;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("venue")
    @Expose
    private String venue;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("dateTimeGMT")
    @Expose
    private String dateTimeGMT;
    @SerializedName("teams")
    @Expose
    private List<String> teams = null;
    @SerializedName("score")
    @Expose
    private List<Score> score = null;
    @SerializedName("tossWinner")
    @Expose
    private String tossWinner;
    @SerializedName("tossChoice")
    @Expose
    private String tossChoice;
    @SerializedName("matchWinner")
    @Expose
    private String matchWinner;
    @SerializedName("series_id")
    @Expose
    private String seriesId;
    @SerializedName("scorecard")
    @Expose
    private List<Scorecard> scorecard = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateTimeGMT() {
        return dateTimeGMT;
    }

    public void setDateTimeGMT(String dateTimeGMT) {
        this.dateTimeGMT = dateTimeGMT;
    }

    public List<String> getTeams() {
        return teams;
    }

    public void setTeams(List<String> teams) {
        this.teams = teams;
    }

    public List<Score> getScore() {
        return score;
    }

    public void setScore(List<Score> score) {
        this.score = score;
    }

    public String getTossWinner() {
        return tossWinner;
    }

    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }

    public String getTossChoice() {
        return tossChoice;
    }

    public void setTossChoice(String tossChoice) {
        this.tossChoice = tossChoice;
    }

    public String getMatchWinner() {
        return matchWinner;
    }

    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public List<Scorecard> getScorecard() {
        return scorecard;
    }

    public void setScorecard(List<Scorecard> scorecard) {
        this.scorecard = scorecard;
    }

}