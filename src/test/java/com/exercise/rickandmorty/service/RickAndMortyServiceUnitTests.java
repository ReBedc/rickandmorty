package com.exercise.rickandmorty.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.HttpClientErrorException;

import com.exercise.rickandmorty.client.RickAndMortyApiClient;
import com.exercise.rickandmorty.utils.TestConstants;

@ExtendWith(MockitoExtension.class)
public class RickAndMortyServiceUnitTests {
	
	@Mock
	RickAndMortyApiClient rickAndMortyApiClient;
	
	@InjectMocks
	RickAndMortyService rickAndMortyService;
	
	@Test
    void testGetCharacterInfo() {
		
		when(rickAndMortyApiClient.getCharacterByName(TestConstants.characterName))
			.thenReturn(TestConstants.charactersResponse);

		lenient().doReturn(List.of(TestConstants.episodeDto))
			.when(rickAndMortyApiClient).getMultipleEpisodes(TestConstants.episodesIdsList);
		
		rickAndMortyService.getCharacterInfo(TestConstants.characterName);
		
		verify(rickAndMortyApiClient, times(1)).getCharacterByName(TestConstants.characterName);
		verify(rickAndMortyApiClient, times(1)).getMultipleEpisodes(TestConstants.episodesIdsList);
		
    }

	@Test
    void testGetCharacterInfo_whenCharacterNotFound() {
		
		when(rickAndMortyApiClient.getCharacterByName(TestConstants.nameOfNotExistingCharacter))
			.thenThrow(HttpClientErrorException.class);
		
	    assertThrows(HttpClientErrorException.class, () -> {
	    	rickAndMortyService.getCharacterInfo(TestConstants.nameOfNotExistingCharacter);
	    });
		
    }
}
