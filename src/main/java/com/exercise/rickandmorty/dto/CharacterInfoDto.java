package com.exercise.rickandmorty.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CharacterInfoDto implements Serializable {

	private static final long serialVersionUID = -1946526500822117159L;
	
	@JsonIgnore
	private Long id;
	
	private String name;
	
	private List<String> episodes;
	
	@JsonProperty("first_appearance")
	private String firstAppearance;

}
