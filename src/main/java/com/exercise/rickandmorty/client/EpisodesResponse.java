package com.exercise.rickandmorty.client;

import java.io.Serializable;
import java.util.List;

import com.exercise.rickandmorty.dto.EpisodeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpisodesResponse implements Serializable {

	private static final long serialVersionUID = 6673963204792677238L;
	
	private List<EpisodeDto> episodes;

}
