package com.exercise.rickandmorty.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.exercise.rickandmorty.dto.EpisodeDto;
import com.exercise.rickandmorty.utils.TestConstants;

@ExtendWith(MockitoExtension.class)
public class RickAndMortyApiClientUnitTest {
	
	private static final String BASEURL = "https://rickandmortyapi.com/api";

	@Mock
	RestTemplate restTemplate;
	
	@InjectMocks
	RickAndMortyApiClient rickAndMortyApiClient;
	
	@Test
    void testGetCharacterByName() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<?> entity = new HttpEntity<>(headers);
		UriComponents builder = UriComponentsBuilder.fromUriString(BASEURL + "/character/")
                .queryParam("name", TestConstants.characterName).build();
		
        ResponseEntity<CharactersResponse> myEntity = new ResponseEntity<CharactersResponse>(TestConstants.charactersResponse, HttpStatus.ACCEPTED);

		when(restTemplate.exchange(
		            builder.toUriString(),
		            HttpMethod.GET,
		            entity,
		            CharactersResponse.class,
		            new ParameterizedTypeReference<>() {})
		        ).thenReturn(myEntity);
		
		assertEquals(TestConstants.charactersResponse, 
				rickAndMortyApiClient.getCharacterByName(TestConstants.characterName));
    }

	@Test
    void testGetMultipleEpisodes() {	
		
		when(restTemplate.getForObject(
					BASEURL + "/episode/"+ TestConstants.episodesIdsList.toString(),
					EpisodeDto[].class)
		        ).thenReturn(new EpisodeDto[] {TestConstants.episodeDto});
		
		
		assertEquals(List.of(TestConstants.episodeDto), 
				rickAndMortyApiClient.getMultipleEpisodes(TestConstants.episodesIdsList));
    }
}
