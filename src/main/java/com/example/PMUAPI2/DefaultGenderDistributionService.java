package com.example.PMUAPI2;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class DefaultGenderDistributionService implements GenderDistributionService {

	private final ParticipantRepository repository;
	
	
	public DefaultGenderDistributionService(ParticipantRepository repository) {
		this.repository = repository;
	}


	@Override
	public Map<String, Integer> findGenderDistributionbyDateRaceAndReunion(LocalDate date, int race, int reunion) {
		
	return repository.findParticipantByDateRaceAndReunion(date, race, reunion).stream().filter(x -> x.getStatut().equals("PARTANT"))
	.collect(Collectors.groupingBy(Participant::getSexe, Collectors.summingInt((x)->1)));

	}

}
