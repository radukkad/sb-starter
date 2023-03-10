package com.radukkad.sbstarter.blogs.repository;

import com.radukkad.sbstarter.blogs.dao.Blog;
import com.radukkad.sbstarter.blogs.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    // custom query to search to blog post by title or content
    List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);

    List<Blog> findBlogsByOwner(User owner);

    @Query(value = "SELECT * FROM blog where submittedon = ?1", nativeQuery = true)
    List<Blog> findBlogsByDate(Date submittedon);
}
