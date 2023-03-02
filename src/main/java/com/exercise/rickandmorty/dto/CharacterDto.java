package com.exercise.rickandmorty.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CharacterDto implements Serializable {

	private static final long serialVersionUID = -386843052956335306L;
	
	private Long id;
	
	private String name;
	
	private List<String> episode;
	
	private String created;
	

}
