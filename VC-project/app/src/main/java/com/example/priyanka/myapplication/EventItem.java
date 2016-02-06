package com.example.priyanka.myapplication;

import java.io.Serializable;
import java.util.Date;


/**
 * Created by MadhuriKambalapalli on 2/5/16.
 */
public class EventItem implements Serializable
    {
        private String name;
        private String desc;
        private String details;
        private int image;
        private Date date;
        private String link;



   /* EventItem(String name,String desc,String image){
        this.name=name;
        this.desc=desc;
        this.image=image;
    }*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
