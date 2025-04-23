package de.ait.javalessons.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPublicEndpointShouldBeAccessible() throws Exception{
        mockMvc.perform(get("/employees/public/info"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .string((containsString("User info, public information"))));
    }

//    @Test
//    void testPrivateEndpointShouldNotBeAccessible() throws Exception{
//        mockMvc.perform(get("/employees/user/info"))
//                .andExpect(status().is3xxRedirection());
//    }
}
