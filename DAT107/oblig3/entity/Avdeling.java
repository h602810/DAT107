package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Avdeling {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdelingsId;
	
	private String avdelingsNavn;
	
	@OneToMany(mappedBy="avdeling")
	private List<Ansatt> ansatte = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "sjefsId")
	private Ansatt sjef;
	
	public Avdeling() {
		
	}

	public Avdeling(String avdelingsNavn, List<Ansatt> ansatte, Ansatt sjef) {
		this.avdelingsNavn = avdelingsNavn;
		this.ansatte = ansatte;
		this.sjef = sjef;
	}
	
	
}
