package com.exercise.rickandmorty.service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.rickandmorty.client.CharactersResponse;
import com.exercise.rickandmorty.client.RickAndMortyApiClient;
import com.exercise.rickandmorty.dto.CharacterInfoDto;
import com.exercise.rickandmorty.dto.EpisodeDto;

@Service
public class RickAndMortyService {
	
	@Autowired
	private RickAndMortyApiClient rickAndMortyApiClient;
	
	
	/**
	 * Principal service called from the controller that includes 
	 *  all logic to look up the required information.
	 *  
	 *  1. Filter characters by name calling Rick and Morty API.
	 *  2. Unify all the episodes from characters obtained in the first API call.
	 *  3. Get episodes' information from the list formatted above calling Rick and Morty API.
	 *  4. Order episodes by air date using EpisodeDto comparator and a set.
	 *  5. Collect all the information required from above phases.
	 * 
	 * @param name
	 * @return CharacterInfoDto Information of the character searched for by name.
	 */
	public CharacterInfoDto getCharacterInfo(String name) {
		// get character filtering by name
		CharactersResponse charactersResponse = rickAndMortyApiClient.getCharacterByName(name);
		
		Set<Integer> episodesIs = new HashSet<>();
		
		// all episodes of all characters
		charactersResponse.getResults().forEach(character -> episodesIs.addAll(
				character.getEpisode().stream()	
					.map(ep -> Integer.valueOf(ep.split("/")[ep.split("/").length-1]))
					.sorted(Comparator.naturalOrder())
					.collect(Collectors.toList())
				));
		
		// get episodes info where appears the character obtained 
		List<EpisodeDto> episodesList = rickAndMortyApiClient.getMultipleEpisodes(
				episodesIs.stream().collect(Collectors.toList()));
		
		// order episodes to look for the first episode 
		TreeSet<EpisodeDto> orderedEpisodes = null;
		if (!episodesList.isEmpty()) {
			orderedEpisodes = new TreeSet<>(episodesList);
		}

		// format result information
		CharacterInfoDto characterInfoDto = new CharacterInfoDto();
		characterInfoDto.setName(charactersResponse.getResults().get(0).getName());
		characterInfoDto.setEpisodes(episodesList.stream().map(e -> e.getName()).collect(Collectors.toList()));
		characterInfoDto.setFirstAppearance(orderedEpisodes != null?orderedEpisodes.first().getAirDate():null);

		return characterInfoDto;
	}

}
