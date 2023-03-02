package com.exercise.rickandmorty.client;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoResponse implements Serializable {

	private static final long serialVersionUID = -2065388329081410745L;

	
	private Long count;
	
	private Long pages;
	
	private String next;
	
	private String prev;
	
	
}
