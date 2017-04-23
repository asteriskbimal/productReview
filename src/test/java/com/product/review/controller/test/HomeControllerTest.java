package com.product.review.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.product.review.cors.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class HomeControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@org.junit.Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void getHome() throws Exception {
		this.mockMvc.perform(get("/"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("/WEB-INF/views/home.jsp"));
	}

	@Test
	public void postEmptyData() throws Exception {
		this.mockMvc.perform(post("/"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(model().attributeHasFieldErrors("formDTO", "messageFromUser"))
			.andExpect(forwardedUrl("/WEB-INF/views/home.jsp"));
	}

	@Test
	public void postSomething() throws Exception {

		this.mockMvc.perform(post("/").param("messageFromUser", "hello"))
			.andDo(print())
			.andExpect(status().isMovedPermanently()) // 302 redirect
			.andExpect(model().hasNoErrors())
			.andExpect(flash().attributeExists("message"))
			.andExpect(redirectedUrl("/"));
	}
}