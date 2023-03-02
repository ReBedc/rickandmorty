package com.exercise.rickandmorty.integration.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exercise.rickandmorty.client.RickAndMortyApiClient;
import com.exercise.rickandmorty.utils.TestConstants;

@SpringBootTest
public class RickAndMortyApiClientTest {

	@Autowired
	private RickAndMortyApiClient rickAndMortyApiClient;
	
	
	@Test
    void testGetCharacterByName() {
		assertEquals(TestConstants.charactersResponse, 
				rickAndMortyApiClient.getCharacterByName(TestConstants.characterName));
    }

	@Test
    void testGetMultipleEpisodes() {
		
		assertEquals(List.of(TestConstants.episodeDto), 
				rickAndMortyApiClient.getMultipleEpisodes(TestConstants.episodesIdsList));
    }
}
