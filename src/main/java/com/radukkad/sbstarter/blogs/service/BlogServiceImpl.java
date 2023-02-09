package com.radukkad.sbstarter.blogs.service;

import com.radukkad.sbstarter.blogs.repository.BlogRepository;
import com.radukkad.sbstarter.blogs.dao.Blog;
import com.radukkad.sbstarter.blogs.dto.BlogModel;
import com.radukkad.sbstarter.blogs.dao.User;
import com.radukkad.sbstarter.blogs.dto.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements  BlogService {
    @Autowired
    BlogRepository blogRepository;

    public BlogModel getBlogById(int id) {
        BlogModel blogModel = null;
        Optional<Blog> blog = blogRepository.findById(id);
        if(blog.isPresent()) {
            blogModel = new BlogModel();
            blogModel.setContent(blog.get().getContent());
        }
        return blogModel;
    }

    public List<BlogModel> getBlogs(){
        List<BlogModel> returnList = new ArrayList<BlogModel>();
        List<Blog> blogs = blogRepository.findAll();
        for(int i=0; i< blogs.size(); i++) {
            BlogModel model = new BlogModel(blogs.get(i).getTitle(), blogs.get(i).getContent());
            UserModel userModel = new UserModel(blogs.get(i).getOwner().getLogon(),blogs.get(i).getOwner().getName() );
            model.setAuthor(userModel);
            returnList.add(model);
        }
        return  returnList;
    }


    public List<BlogModel> getBlogsByUser(int userId){
        List<BlogModel> returnList = new ArrayList<BlogModel>();
        User inputUser = new User();
        inputUser.setId(userId);
        List<Blog> blogs = blogRepository.findBlogsByOwner(inputUser);
        for(int i=0; i< blogs.size(); i++) {
            BlogModel model = new BlogModel(blogs.get(i).getTitle(), blogs.get(i).getContent());
            returnList.add(model);
        }
        return  returnList;
    }

}
