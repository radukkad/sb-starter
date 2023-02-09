package com.radukkad.sbstarter.blogs.repository;

import com.radukkad.sbstarter.blogs.dao.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findReviewByBlogId(int id);
}
