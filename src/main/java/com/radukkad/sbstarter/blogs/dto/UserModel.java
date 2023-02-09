package com.radukkad.sbstarter.blogs.dto;

import java.io.Serializable;
import java.util.List;

public class UserModel implements Serializable {

    int id;
    String logon;
    String name;

    List<BlogModel> blogs;

    public String getLogon() {
        return logon;
    }
    public void setLogon(String logon) {
        this.logon = logon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserModel(){

    }
    public UserModel(String logon, String name) {
        this.logon = logon;
        this.name = name;
    }

    public List<BlogModel> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<BlogModel> blogs) {
        this.blogs = blogs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
