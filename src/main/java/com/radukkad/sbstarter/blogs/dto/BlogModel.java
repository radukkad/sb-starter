package com.radukkad.sbstarter.blogs.dto;

import java.util.List;

public class BlogModel {
    String title;
    String content;
    UserModel author;

    List<ReviewModel> reviews;

    public BlogModel() {

    }

    public BlogModel(String title, String content) {
        this.content = content;
        this.title = title;
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

    public UserModel getAuthor() {
        return author;
    }

    public void setAuthor(UserModel author) {
        this.author = author;
    }

    public List<ReviewModel> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewModel> reviews) {
        this.reviews = reviews;
    }
}