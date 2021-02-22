package com.example.PMUAPI2;

public class Participant {
	
	final private String statut;
	
	final private String sexe;

	public String getStatut() {
		return statut;
	}

	public String getSexe() {
		return sexe;
	}

	public Participant(String statut, String sexe) {
		this.statut = statut;
		this.sexe = sexe;
	}
	
}
