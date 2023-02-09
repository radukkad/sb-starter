package com.radukkad.sbstarter.blogs.dto;

import java.io.Serializable;

public class ReviewModel implements Serializable {

    private String coment;
    private UserModel reviewer;
    private BlogModel article;

    public ReviewModel(String comment) {
        this.coment = comment;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public UserModel getReviewer() {
        return reviewer;
    }

    public void setReviewer(UserModel reviewer) {
        this.reviewer = reviewer;
    }

    public BlogModel getArticle() {
        return article;
    }

    public void setArticle(BlogModel article) {
        this.article = article;
    }
}