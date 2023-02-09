package com.radukkad.sbstarter.blogs.repository;

import com.radukkad.sbstarter.blogs.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

}
