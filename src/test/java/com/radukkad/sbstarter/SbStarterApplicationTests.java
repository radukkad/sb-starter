package com.radukkad.sbstarter;

import com.radukkad.sbstarter.blogs.controller.BlogController;
import com.radukkad.sbstarter.blogs.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SbStarterApplicationTests {

	@Autowired
	UserController userController;
	@Autowired
	BlogController blogController;

	@Test
	void contextLoads() {
		assertThat(userController).isNotNull();
		assertThat(blogController).isNotNull();
	}

}
