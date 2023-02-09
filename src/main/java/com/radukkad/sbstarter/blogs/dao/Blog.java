package com.radukkad.sbstarter.blogs.dao;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name ="writer")
    private User owner;

    private String title;
    private String content;

    private Date submittedon;

    public Blog() {  }

    public Blog(String title, String content) {
        this.setTitle(title);
        this.setContent(content);
    }

    public Blog(int id, String title, String content) {
        this.setId(id);
        this.setTitle(title);
        this.setContent(content);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + " '" +
        ", content='" + content + "'" +
        '}';
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getSubmittedon() {
        return submittedon;
    }

    public void setSubmittedon(Date submittedon) {
        this.submittedon = submittedon;
    }
}