package main;

import static javax.swing.JOptionPane.*;

import java.time.LocalDate;

import dao.AnsattDAO;
import entity.Ansatt;

public class MainAnsatt {
	public static void main(String[] args) {
		AnsattDAO dao = new AnsattDAO();
		
		// Test for soekAnsattForBrukernavn - funker
		System.out.println("soekAnsattForBrukernavn metode:");
		String brukernavnTxt = showInputDialog("Oppgi brukernavn: ");
		Ansatt ansatt1 = dao.soekAnsattForBrukernavn(brukernavnTxt);		
		ansatt1.skrivUt();
		
		System.out.println();
		
		// Test for finnAnsattMedId - funker
		System.out.println("finnAnsattMedId metode:");
		int id = Integer.parseInt(showInputDialog("Oppgi ansattid: "));
		Ansatt ansatt2 = dao.finnAnsattMedId(id);		
		System.out.println(ansatt2);
		
		System.out.println();
		
		// Test for listAlleAnsatte - funker
		System.out.println("listAlleAnsatte metode:");
		System.out.println(dao.finnAlleAnsatte());
		
		System.out.println();

		// Test for oppdaterStillingOgLonn - funker
//		dao.oppdaterStillingOgLonn(1, "Lagerkoordinator", 32000);
		
		// Test for registrerNyAnsatt - funker
//		System.out.println("registrerNyAnsatt metode:");
//		Ansatt nyAnsatt = new Ansatt("SIKJ", "Sindre", "Kjelsrud", LocalDate.parse("2020-01-28"), "Lagermedarbeider", 20000);
//		dao.registrerNyAnsatt(nyAnsatt);
		
	}
}
