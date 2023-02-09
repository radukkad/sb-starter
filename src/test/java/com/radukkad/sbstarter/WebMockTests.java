package com.radukkad.sbstarter;


import com.radukkad.sbstarter.blogs.controller.UserController;
import com.radukkad.sbstarter.blogs.dto.UserModel;
import com.radukkad.sbstarter.blogs.repository.UserRepository;
import com.radukkad.sbstarter.blogs.service.BlogServiceImpl;
import com.radukkad.sbstarter.blogs.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class WebMockTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserRepository userRepository;
    @MockBean
    UserServiceImpl userService;

    @MockBean
    BlogServiceImpl blogService;

    @Test
    public void userServiceShouldReturn200OK() throws Exception {
        when(userService.findUserbyId(1)).thenReturn(new UserModel("radukkad", "Rajesh"));
        this.mockMvc.perform(get("/user/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Rajesh")));
    }

}
