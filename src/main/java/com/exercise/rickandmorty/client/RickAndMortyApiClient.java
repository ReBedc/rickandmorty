package com.exercise.rickandmorty.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.exercise.rickandmorty.dto.EpisodeDto;


@Component
public class RickAndMortyApiClient {
	
	private static final String BASEURL = "https://rickandmortyapi.com/api";
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	/**
	 * API call to search for characters by name
	 * https://rickandmortyapi.com/documentation/#filter-characters
	 * 
	 * @param name
	 * @return CharactersResponse Response from API with characters found
	 */
	public CharactersResponse getCharacterByName(String name) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		UriComponents builder = UriComponentsBuilder.fromUriString(BASEURL + "/character/")
                .queryParam("name", name).build();

		ResponseEntity<CharactersResponse> response = restTemplate.exchange(
				builder.toUriString(), 
				HttpMethod.GET, 
				entity, 
				CharactersResponse.class, 
				new ParameterizedTypeReference<>() {});

		return response.getBody();
	}

	
	/**
	 * API call to get information about episodes with parameters IDs
	 * https://rickandmortyapi.com/documentation/#get-multiple-episodes
	 * 
	 * @param episodeIds
	 * @return List<EpisodeDto>  Response list from API with episodes info
	 */
	public List<EpisodeDto> getMultipleEpisodes(List<Integer> episodeIds) {
		
		EpisodeDto[] episodes =  restTemplate.getForObject(
				BASEURL + "/episode/"+ episodeIds.toString(),EpisodeDto[].class);
		return Arrays.asList(episodes);
	}

}
