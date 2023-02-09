package com.radukkad.sbstarter.blogs.service;

import com.radukkad.sbstarter.blogs.dao.Review;
import com.radukkad.sbstarter.blogs.dto.ReviewModel;
import com.radukkad.sbstarter.blogs.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl  implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public List<ReviewModel> findReviewsByBlog(int blogId) {
        List<Review> reviews = reviewRepository.findReviewByBlogId(blogId);
        List<ReviewModel> reviewList = new ArrayList<ReviewModel>();
        for(int i=0; i < reviews.size(); i++) {
            reviewList.add(new ReviewModel(reviews.get(i).getComment()));
        }
        return reviewList;
    }
}
