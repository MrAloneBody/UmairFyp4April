package com.example.umairfyp;

public class Model {

    String id,team1,team2,matchtype,matchstatus,date,score;

    //constructor


    public Model(String id, String team1, String team2, String matchtype, String matchstatus, String date) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.matchtype = matchtype;
        this.matchstatus = matchstatus;
        this.date = date;
    }

    //getters


    public String getId() {
        return id;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getMatchtype() {
        return matchtype;
    }

    public String getMatchstatus() {
        return matchstatus;
    }

    public String getDate() {
        return date;
    }

    public String getScore() { return score; }
}
