package com.project.sairam;

public class Model1 {
    String id,profilename,time,imagepath;

    public Model1(String id ,String profilename, String time, String imagepath) {
        this.id = id;
        this.profilename = profilename;
        this.time = time;
        this.imagepath = imagepath;

    }

    public String getId(){
        return id;
    }

    public String getProfileName(){
        return profilename;
    }

    public String getTime(){
        return time;
    }

    public String getImagePath(){
        return imagepath;
    }
}
