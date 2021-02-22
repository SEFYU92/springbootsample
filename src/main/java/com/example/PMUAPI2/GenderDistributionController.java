package com.example.PMUAPI2;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenderDistributionController {

	private final GenderDistributionService service ;
	
	public GenderDistributionController(GenderDistributionService service) {
		this.service = service;
	}



	@GetMapping("/gender-distribution/{date}/R{race}/C{reunion}")
	Map<String, Integer> getGenderDistributionbyDateReunionAndRace(@DateTimeFormat(pattern = "ddMMyyyy") @PathVariable LocalDate date,@PathVariable int race,@PathVariable int reunion){
	
		return service.findGenderDistributionbyDateRaceAndReunion(date, race, reunion);
		
	}
	
}
