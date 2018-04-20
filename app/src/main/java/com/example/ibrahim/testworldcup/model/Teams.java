package com.example.ibrahim.testworldcup.model;

/**
 * Created by ibrahim on 07/04/18.
 */

public class Teams {
    long  id;
    String name;
    String ar_name;
    long res;
    long po;
    String flag;//
    String iso2;

    public Teams (long id, String name, String ar_name, long res, long po, String flag, String iso2) {
        this.id = id;
        this.name = name;
        this.ar_name = ar_name;
        this.res = res;
        this.po = po;
        this.flag = flag;
        this.iso2 = iso2;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getAr_name () {
        return ar_name;
    }

    public void setAr_name (String ar_name) {
        this.ar_name = ar_name;
    }

    public long getRes () {
        return res;
    }

    public void setRes (long res) {
        this.res = res;
    }

    public long getPo () {
        return po;
    }

    public void setPo (long po) {
        this.po = po;
    }

    public String getIso2 () {
        return iso2;
    }

    public void setIso2 (String iso2) {
        this.iso2 = iso2;
    }

    public String getFlag () {
        return flag;
    }

    public void setFlag (String flag) {
        this.flag = flag;
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }
}
