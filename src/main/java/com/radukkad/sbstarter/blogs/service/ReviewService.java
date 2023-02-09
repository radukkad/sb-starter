package com.radukkad.sbstarter.blogs.service;

import com.radukkad.sbstarter.blogs.dto.ReviewModel;

import java.util.List;

public interface ReviewService {
    public List<ReviewModel> findReviewsByBlog(int blogId) ;
}
