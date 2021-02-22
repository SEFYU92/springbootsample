package com.example.PMUAPI2;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface GenderDistributionService {

	Map<String, Integer> findGenderDistributionbyDateRaceAndReunion(LocalDate date, int race, int reunion);
	
}
