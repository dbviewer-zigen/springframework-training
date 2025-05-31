package com.example.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitConfig
@WebAppConfiguration // WebApplicationContextをテストに統合
// @ContextConfiguration("classpath:applicationContext.xml")
// @ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(locations = { "classpath:test-applicationContext.xml" })
public class TodoControllerTest {

        @Autowired
        private WebApplicationContext wac;

        private MockMvc mockMvc;

        @BeforeEach
        public void setup() {
                this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        }

        @Test
        public void testGetDefault() throws Exception {
                // mockMvc.perform(get("/")
                // .param("description", "Test TODO")
                // .param("completed", "false"))
                // .andExpect(status().is3xxRedirection())
                // .andExpect(redirectedUrl("/todos"));

                // root
                mockMvc.perform(get("/"))
                                .andExpect(status().isOk())
                                .andExpect(view().name("hello"))
                                .andExpect(model().attributeExists("message"))
                                .andExpect(model().attribute("message", "Hello World"));

        }

        @Test
        public void testCreateTodo() throws Exception {
                mockMvc.perform(post("/todos/create")
                                .param("description", "Test TODO")
                                .param("completed", "false"))
                                .andExpect(status().is3xxRedirection())
                                .andExpect(redirectedUrl("/todos"));
        }

        @Test
        public void testGetTodo() throws Exception {
                mockMvc.perform(post("/todos/create")
                                .param("description", "Test TODO")
                                .param("completed", "false"))
                                .andExpect(status().is3xxRedirection());

                mockMvc.perform(get("/todos/1"))
                                .andExpect(status().isOk())
                                .andExpect(view().name("todoDetails"))
                                .andExpect(model().attributeExists("todo"));
        }

        @Test
        public void testUpdateTodo() throws Exception {
                mockMvc.perform(post("/todos/create")
                                .param("description", "Test TODO")
                                .param("completed", "false"))
                                .andExpect(status().is3xxRedirection());

                mockMvc.perform(post("/todos/update/1")
                                .param("description", "Updated TODO")
                                .param("completed", "true"))
                                .andExpect(status().is3xxRedirection())
                                .andExpect(redirectedUrl("/todos"));
        }

        @Test
        public void testDeleteTodo() throws Exception {
                mockMvc.perform(post("/todos/create")
                                .param("description", "Test TODO")
                                .param("completed", "false"))
                                .andExpect(status().is3xxRedirection());

                mockMvc.perform(get("/todos/delete/1"))
                                .andExpect(status().is3xxRedirection())
                                .andExpect(redirectedUrl("/todos"));
        }
}
