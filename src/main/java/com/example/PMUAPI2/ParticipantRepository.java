package com.example.PMUAPI2;

import java.time.LocalDate;
import java.util.List;

public interface ParticipantRepository {
	
	List<Participant> findParticipantByDateRaceAndReunion(LocalDate date, int race, int reunion);
	
}
