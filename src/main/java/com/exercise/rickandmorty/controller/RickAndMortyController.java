package com.exercise.rickandmorty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.rickandmorty.dto.CharacterInfoDto;
import com.exercise.rickandmorty.service.RickAndMortyService;

@RestController
public class RickAndMortyController {
	
	@Autowired
	private RickAndMortyService rickAndMortyService;
	
	/**
	 * Endpoint to look up a character's information including the name, first appearance
	 *  in the serie and episodes where the character appears.
	 * 
	 * @param name
	 * @return CharacterInfoDto Information of the character searched for by name.
	 */
	@GetMapping("/search-character-appearance") 
	public CharacterInfoDto getCharacterInfo(@RequestParam String name) {
		return rickAndMortyService.getCharacterInfo(name);
	}

}
