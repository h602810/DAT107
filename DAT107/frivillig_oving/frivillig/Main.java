package no.hvl.dat107.frivillig;

import static javax.swing.JOptionPane.*;

public class Main {
	public static void main(String[] args) {
		AnsattDAO dao = new AnsattDAO();
		
		String brukernavnTxt = showInputDialog("Oppgi brukernavn: ");
		Ansatt ansatt = dao.hentAnsattForBrukernavn(brukernavnTxt);
		System.out.println(ansatt);
		
	}
}
