package com.example.ibrahim.testworldcup.model;

public class Matches {
    long id;



    private   String type;
    private String date;
    private String finished;
    private  String home_team;
    private  String away_team;
    private String home_team_flag;
    private String away_team_flag;
    private String city;
    private String lat;
    private String lng;

    public Matches (long id,String type, String date, String finished, String home_team, String away_team, String home_team_flag, String away_team_flag, String city, String lat, String lng, String channels) {
        this.id=id;
        this.type = type;
        this.date = date;
        this.finished = finished;
        this.home_team = home_team;
        this.away_team = away_team;
        this.home_team_flag = home_team_flag;
        this.away_team_flag = away_team_flag;
        this.city = city;
        this.lat = lat;
        this.lng = lng;
        this.channels = channels;
    }
    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }
    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public String getFinished () {
        return finished;
    }

    public void setFinished (String finished) {
        this.finished = finished;
    }

    public String getHome_team () {
        return home_team;
    }

    public void setHome_team (String home_team) {
        this.home_team = home_team;
    }

    public String getAway_team () {
        return away_team;
    }

    public void setAway_team (String away_team) {
        this.away_team = away_team;
    }

    public String getHome_team_flag () {
        return home_team_flag;
    }

    public void setHome_team_flag (String home_team_flag) {
        this.home_team_flag = home_team_flag;
    }

    public String getAway_team_flag () {
        return away_team_flag;
    }

    public void setAway_team_flag (String away_team_flag) {
        this.away_team_flag = away_team_flag;
    }

    public String getCity () {
        return city;
    }

    public void setCity (String city) {
        this.city = city;
    }

    public String getLat () {
        return lat;
    }

    public void setLat (String lat) {
        this.lat = lat;
    }

    public String getLng () {
        return lng;
    }

    public void setLng (String lng) {
        this.lng = lng;
    }

    public String getChannels () {
        return channels;
    }

    public void setChannels (String channels) {
        this.channels = channels;
    }

    private  String channels;



}
