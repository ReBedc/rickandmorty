package com.exercise.rickandmorty.integration.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.exercise.rickandmorty.client.RickAndMortyApiClient;
import com.exercise.rickandmorty.controller.RickAndMortyController;
import com.exercise.rickandmorty.service.RickAndMortyService;
import com.exercise.rickandmorty.utils.TestConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.net.SocketConnector.ExceptionHandler;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {RickAndMortyController.class, RickAndMortyService.class, 
		RickAndMortyApiClient.class, RestTemplate.class, ExceptionHandler.class})
@WebMvcTest
public class RickAndMortyControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	ObjectMapper mapper = new ObjectMapper();

	
	
	@Test
	public void testGetCharacterInfo() throws Exception {
		testGetCharacterInfo(TestConstants.characterName);
	}
	
	
	private void testGetCharacterInfo(String name) throws Exception {
		
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
        		.get("http://localhost:3456/search-character-appearance")
                .param("name",name)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String resultGetCharacterInfo = result.getResponse().getContentAsString();
        assertNotNull(resultGetCharacterInfo);
        assertEquals(mapper.writeValueAsString(TestConstants.characterInfoDto), resultGetCharacterInfo);
    }
	
}
