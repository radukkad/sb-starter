package com.radukkad.sbstarter.blogs.controller;

import com.radukkad.sbstarter.blogs.dto.ReviewModel;
import com.radukkad.sbstarter.blogs.repository.BlogRepository;
import com.radukkad.sbstarter.blogs.dao.Blog;
import com.radukkad.sbstarter.blogs.dto.BlogModel;
import com.radukkad.sbstarter.blogs.service.BlogService;
import com.radukkad.sbstarter.blogs.service.BlogServiceImpl;
import com.radukkad.sbstarter.blogs.service.ReviewService;
import com.radukkad.sbstarter.blogs.service.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    BlogService blogService;

    @Autowired
    ReviewService reviewService;

    @GetMapping("/blog")
    public ResponseEntity<List<BlogModel>> getBlogs(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(blogService.getBlogs());
    }

    @GetMapping("/blog/{id}/reviews")
    public ResponseEntity<BlogModel> getBlogReviews(@PathVariable int id){
        BlogModel blogModel = blogService.getBlogById(id);
        List<ReviewModel> reviews = reviewService.findReviewsByBlog(id);
        blogModel.setReviews(reviews);
        return ResponseEntity.status(HttpStatus.OK)
                .body(blogModel);
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return blogRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Blog body){
        return blogRepository.save(body);
    }
}