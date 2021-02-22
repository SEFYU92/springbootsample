package com.example.PMUAPI2;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,classes = Pmuapi2Application.class)
@AutoConfigureMockMvc
class Pmuapi2ApplicationTests {
	
	@Autowired
	MockMvc mvc;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void GenderDistributionControllerTest() {
		try {
			mvc.perform(get("/gender-distribution/18092020/R5/C6").contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
			  .andExpect(content()
			  .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			  .andExpect(jsonPath("$.FEMELLES").value(3))
			  .andExpect(jsonPath("$.HONGRES").value(5));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
