package com.crio.coderhack.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.crio.coderhack.entities.User;
import com.crio.coderhack.repositories.UserRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testGetAllUsers() throws Exception {
        mockMvc.perform(get("/users"))
            .andExpect(status().isOk());
    }

    // @Test
    // public void testGetUserById() throws Exception {
    //     when(userRepository.findByUserId(anyString())).thenReturn(new User("username", "userId"));

    //     mockMvc.perform(get("/users/userId"))
    //         .andExpect(status().isOk())
    //         .andExpect(content().json("{\"username\":\"username\",\"userId\":\"userId\"}"));
    // }

    @Test
    public void testRegisterUser() throws Exception {
        mockMvc.perform(post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"username\":\"username\",\"userId\":\"userId\"}"))
            .andExpect(status().isOk());
    }

    // @Test
    // public void testUpdateUserScore() throws Exception {
    //     mockMvc.perform(put("/users/userId")
    //         .contentType(MediaType.APPLICATION_JSON)
    //         .content("{\"score\":10}"))
    //         .andExpect(status().isOk());
    // }

    // @Test
    // public void testDeleteUser() throws Exception {
    //     mockMvc.perform(delete("/users/userId"))
    //         .andExpect(status().isOk());
    // }
}