/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.s1.attackerstory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AttackerStoryApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void customerHomepageWhenNoUserThenRedirectedToLoginPage() throws Exception {
        this.mockMvc.perform(get("/customer/home"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void adminHomepageWhenNoUserThenRedirectedToLoginPage() throws Exception {
        this.mockMvc.perform(get("/admin/home"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void loginWhenRoleCustomerThenRedirectedToCustomerHomepage() throws Exception {
        this.mockMvc.perform(formLogin().user("ria@example.com"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/customer/home"))
                .andExpect(authenticated().withRoles("CUSTOMER"));
    }

    @Test
    public void loginWhenRoleAdminThenRedirectedToAdminHomepage() throws Exception {
        this.mockMvc.perform(formLogin().user("mary@marketing.com"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/home"))
                .andExpect(authenticated().withRoles("ADMIN"));
    }

    @Test
    @WithUserDetails("mary@marketing.com")
    public void adminHomepageWhenRoleAdminThenOk() throws Exception {
        this.mockMvc.perform(get("/admin/home"))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails("ria@example.com")
    public void customerHomepageWhenRoleCustomerThenOk() throws Exception {
        this.mockMvc.perform(get("/customer/home"))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails("henri@hacker.com")
    public void adminHomepageWhenRoleUserThenForbidden() throws Exception {
        this.mockMvc.perform(get("/admin/home"))
                .andExpect(status().isForbidden());
    }
}
