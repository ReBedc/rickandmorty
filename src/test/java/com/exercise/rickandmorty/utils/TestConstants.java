package com.exercise.rickandmorty.utils;

import java.util.List;

import com.exercise.rickandmorty.client.CharactersResponse;
import com.exercise.rickandmorty.client.InfoResponse;
import com.exercise.rickandmorty.dto.CharacterDto;
import com.exercise.rickandmorty.dto.CharacterInfoDto;
import com.exercise.rickandmorty.dto.EpisodeDto;

public class TestConstants {
	
	public static CharacterDto characterDto = CharacterDto.builder().id(6L)
			.name("Abadango Cluster Princess").created("2017-11-04T19:50:28.250Z")
			.episode(List.of("https://rickandmortyapi.com/api/episode/27")).build();
	
	public static CharactersResponse charactersResponse = CharactersResponse.builder()
			.info(InfoResponse.builder().count(1L).pages(1L).build())
			.results(List.of(characterDto)).build();
	
	public static EpisodeDto episodeDto = EpisodeDto.builder()
			.id(27L).name("Rest and Ricklaxation").airDate("August 27, 2017")
			.created("2017-11-10T12:56:36.515Z").build();
	
	public static CharacterInfoDto characterInfoDto = CharacterInfoDto.builder()
			.name("Abadango Cluster Princess").firstAppearance("August 27, 2017")
			.episodes(List.of("Rest and Ricklaxation")).build();
	
	public static String characterName = "Abadango Cluster Princess";
	public static String nameOfNotExistingCharacter = "Not Existing Character";
	public static List<Integer> episodesIdsList = List.of(27);


}
