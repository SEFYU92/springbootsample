package com.example.PMUAPI2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class PMUAPIParticipantRepository implements ParticipantRepository {

	private final RestTemplate restTemplate;
	private final ObjectMapper objectMapper;

	public PMUAPIParticipantRepository(RestTemplate restTemplate, ObjectMapper objectMapper) {

		this.restTemplate = restTemplate;
		this.objectMapper = objectMapper;

	}
	
	@Override
	public List<Participant> findParticipantByDateRaceAndReunion(LocalDate date, int race, int reunion) {
		
		try {
			List<Participant> participantList = new ArrayList<Participant>();
			String sdate = date.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
			
			String result = restTemplate.getForObject("https://online.turfinfo.api.pmu.fr/rest/client/1/programme/" + sdate
					+ "/R" + reunion + "/C" + race + "/participants?specialisation=INTERNET", String.class);
			JsonNode parentNode;
			parentNode = objectMapper.readTree(result).get("participants");
			if(parentNode.isArray()){
				
				for(JsonNode node : parentNode ) {
					participantList.add(new Participant(node.get("statut").asText(),node.get("sexe").asText()));
				}
			}
			return participantList;
		} catch (Exception e) {
			throw new IllegalStateException("an error has occured",e);
		} 
	}

}
