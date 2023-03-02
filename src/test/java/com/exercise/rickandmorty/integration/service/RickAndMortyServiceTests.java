package com.exercise.rickandmorty.integration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exercise.rickandmorty.service.RickAndMortyService;
import com.exercise.rickandmorty.utils.TestConstants;

@SpringBootTest
public class RickAndMortyServiceTests {
	
	@Autowired
	RickAndMortyService rickAndMortyService;
	
	@Test
    void testGetCharacterInfo() {
		assertEquals(TestConstants.characterInfoDto, 
				rickAndMortyService.getCharacterInfo(TestConstants.characterName));
    }

	@Test
    void testGetCharacterInfo_whenCharacterNotFound() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			rickAndMortyService.getCharacterInfo(TestConstants.nameOfNotExistingCharacter);
	    });
		String expectedMessage = "404 Not Found: \"{\"error\":\"There is nothing here\"}\"";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
    }
}
