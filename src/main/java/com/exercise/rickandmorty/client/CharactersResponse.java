package com.exercise.rickandmorty.client;

import java.io.Serializable;
import java.util.List;

import com.exercise.rickandmorty.dto.CharacterDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CharactersResponse  implements Serializable {

	private static final long serialVersionUID = -4771009789171144041L;
	
	private InfoResponse info;
	private List<CharacterDto> results;
	
}
