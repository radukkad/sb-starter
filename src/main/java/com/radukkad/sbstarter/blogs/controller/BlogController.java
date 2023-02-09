package com.radukkad.sbstarter.blogs.controller;

import com.radukkad.sbstarter.blogs.dto.ReviewModel;
import com.radukkad.sbstarter.blogs.dto.BlogModel;
import com.radukkad.sbstarter.blogs.service.BlogService;
import com.radukkad.sbstarter.blogs.service.ReviewService;
import org.hibernate.query.QueryParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    ReviewService reviewService;

    @GetMapping("/blog")
    public ResponseEntity<List<BlogModel>> getBlogs(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(blogService.getBlogs());
    }

    @GetMapping("/blog/{submittedOn}")
    public ResponseEntity<List<BlogModel>> findBlogsByDate(@PathVariable String submittedOn) throws ParseException {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
                Date inputDate = formatter.parse(submittedOn);
                List<BlogModel> blogList = blogService.findBlogsByDate(inputDate);
        return ResponseEntity.status(HttpStatus.OK).body(blogList);
    }


    @GetMapping("/blog/{id}/reviews")
    public ResponseEntity<BlogModel> getBlogReviews(@PathVariable int id){
        BlogModel blogModel = blogService.getBlogById(id);
        List<ReviewModel> reviews = reviewService.findReviewsByBlog(id);
        blogModel.setReviews(reviews);
        return ResponseEntity.status(HttpStatus.OK)
                .body(blogModel);
    }


//    @PostMapping("/blog/search")
//    public List<Blog> search(@RequestBody Map<String, String> body){
//        String searchTerm = body.get("text");
//        return blogRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
//    }

    @PostMapping("/blog")
    public BlogModel create(@RequestBody BlogModel body){
        return blogService.createBlog(body);
    }
}