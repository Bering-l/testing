package ru.techno.testing.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {

    MockMvc mockMvc;
    @BeforeEach
    void setMockMvc(final ApplicationContext applicationContext) {
        this.mockMvc = applicationContext.getBean(MockMvc.class);
    }

    @Test
    void showHomePageTest() throws Exception {
        this.mockMvc.perform(get("/homepage"))
                .andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "example@gmail.com", roles = {"CANDIDATE"})
    void showTestCreationWithAuthorityRoleCandidate() throws Exception {
        this.mockMvc.perform(get("/create_test"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "example@gmail.com", roles = {"CANDIDATE"})
    void showUserAuthorityWithPassword() throws Exception {
        this.mockMvc.perform(get("/test"))
                .andExpect(status().isOk());
    }
}
