package no.hvl.dat107.frivillig;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "oving_jpa")
public class Ansatt {
	
	@Id private String brukernavn;	// PK
	private String fornavn;
	private String etternavn;
	private LocalDate ansattDato;
	private String stilling;
	private int maanedslonn;
	
	@Override
	public String toString() {
		return "Ansatt [brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn=" + etternavn
				+ ", ansattDato=" + ansattDato + ", stilling=" + stilling + ", maanedslonn=" + maanedslonn + "]";
	}
}
