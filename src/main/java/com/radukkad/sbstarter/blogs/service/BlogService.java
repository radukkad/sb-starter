package com.radukkad.sbstarter.blogs.service;

import com.radukkad.sbstarter.blogs.dto.BlogModel;

import java.util.List;

public interface BlogService {
    public BlogModel getBlogById(int id);
    public List<BlogModel> getBlogs();
    public List<BlogModel> getBlogsByUser(int userId);
}
