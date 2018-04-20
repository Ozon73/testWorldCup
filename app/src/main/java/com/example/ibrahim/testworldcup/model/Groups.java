package com.example.ibrahim.testworldcup.model;

/**
 * Created by ibrahim on 14/04/18.
 */

public class Groups {
    private String name,team1,team2,team3,team4,flag1,flag2,flag3,flag4;
    private  long  id,res1,res2,res3,res4,po1,po2,po3,po4;

    public Groups (long id, String name, String team1, String team2, String team3, String team4, String flag1, String flag2, String flag3, String flag4, long res1, long res2, long res3, long res4, long po1, long po2, long po3, long po4) {
       this.name=name;
       this.id=id;
        this.team1 = team1;
        this.team2 = team2;
        this.team3 = team3;
        this.team4 = team4;
        this.flag1 = flag1;
        this.flag2 = flag2;
        this.flag3 = flag3;
        this.flag4 = flag4;
        this.res1 = res1;
        this.res2 = res2;
        this.res3 = res3;
        this.res4 = res4;
        this.po1 = po1;
        this.po2 = po2;
        this.po3 = po3;
        this.po4 = po4;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getTeam1 () {
        return team1;
    }

    public void setTeam1 (String team1) {
        this.team1 = team1;
    }

    public String getTeam2 () {
        return team2;
    }

    public void setTeam2 (String team2) {
        this.team2 = team2;
    }

    public String getTeam3 () {
        return team3;
    }

    public void setTeam3 (String team3) {
        this.team3 = team3;
    }

    public String getTeam4 () {
        return team4;
    }

    public void setTeam4 (String team4) {
        this.team4 = team4;
    }

    public String getFlag1 () {
        return flag1;
    }

    public void setFlag1 (String flag1) {
        this.flag1 = flag1;
    }

    public String getFlag2 () {
        return flag2;
    }

    public void setFlag2 (String flag2) {
        this.flag2 = flag2;
    }

    public String getFlag3 () {
        return flag3;
    }

    public void setFlag3 (String flag3) {
        this.flag3 = flag3;
    }

    public String getFlag4 () {
        return flag4;
    }

    public void setFlag4 (String flag4) {
        this.flag4 = flag4;
    }

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public long getRes1 () {
        return res1;
    }

    public void setRes1 (long res1) {
        this.res1 = res1;
    }

    public long getRes2 () {
        return res2;
    }

    public void setRes2 (long res2) {
        this.res2 = res2;
    }

    public long getRes3 () {
        return res3;
    }

    public void setRes3 (long res3) {
        this.res3 = res3;
    }

    public long getRes4 () {
        return res4;
    }

    public void setRes4 (long res4) {
        this.res4 = res4;
    }

    public long getPo1 () {
        return po1;
    }

    public void setPo1 (long po1) {
        this.po1 = po1;
    }

    public long getPo2 () {
        return po2;
    }

    public void setPo2 (long po2) {
        this.po2 = po2;
    }

    public long getPo3 () {
        return po3;
    }

    public void setPo3 (long po3) {
        this.po3 = po3;
    }

    public long getPo4 () {
        return po4;
    }

    public void setPo4 (long po4) {
        this.po4 = po4;
    }
}
