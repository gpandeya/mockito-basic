package com.rnd.unittesting.unittesting.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void dummyItem_basic() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders
					.get("/dummy-item")
					.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
						.andExpect(status().isOk())
						.andExpect(content().json(
								"{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
						.andReturn();
		
		//JSONAssert.assertEquals(expected, actual, strict);
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}

}
