package com.exercise.rickandmorty.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exercise.rickandmorty.service.RickAndMortyService;
import com.exercise.rickandmorty.utils.TestConstants;


@ExtendWith(MockitoExtension.class)
public class RickAndMortyControllerUnitTest {
	
	@Mock
	RickAndMortyService rickAndMortyService;
	
	@InjectMocks
	RickAndMortyController rickAndMortyController;
	
	@Test
    void testGetCharacterInfo() {		
		
		when(rickAndMortyService.getCharacterInfo(TestConstants.characterName))
			.thenReturn(TestConstants.characterInfoDto);
		
		rickAndMortyController.getCharacterInfo(TestConstants.characterName);
		
		verify(rickAndMortyService, times(1)).getCharacterInfo(TestConstants.characterName);
		
    }

	
	
}
