package com.exercise.rickandmorty.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EpisodeDto implements Serializable, Comparable<EpisodeDto> {

	private static final long serialVersionUID = 538071994973621419L;
	
	private Long id;
	
	private String name;
	
	@JsonProperty("air_date")
	private String airDate;
	
	private String created;
	
	
	
	@Override
	public int compareTo(EpisodeDto o) {
	    // Setting the date in MMMM format
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
	    try {
			Date date1 = dateFormat.parse(airDate);
			Date date2 = dateFormat.parse(o.getAirDate());
			return date1.before(date2)? -1 : 1;
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	    
	}
	
}
