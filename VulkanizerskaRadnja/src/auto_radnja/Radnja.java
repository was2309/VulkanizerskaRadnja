package auto_radnja;

import java.util.List;

import auto_radnja.gume.AutoGuma;

/**
 * Predstavlja radnju sa automobilskim gumama.
 * 
 * Ima osnovne operacije unosa gume, pretrage gume i operaciju koja vraca sve gume.
 * 
 * @author Vasilije
 *
 */
public interface Radnja {
	
	/**
	 * Dodaje gumu u radnju.
	 * 
	 * Dodaje gumu u radnju samo guma vec ne postoji u radnji i ako guma nije null.
	 * Nema duplikata guma.
	 * @param a guma koju treba dodati u radnju
	 * @throws java.lang.NullPointerException ako je uneta guma null
	 * @throws java.lang.RuntimeException ako uneta guma vec postoji u radnji
	 * 
	 * @see auto_radnja.gume.AutoGuma
	 */
	void dodajGumu(AutoGuma a);
	
	/**
	 * Pronalazi gume po zadatoj vrednosti marke i modela.
	 * 
	 * Operacija koja vraca informacije o gumama koje su pronadjene u radnji na osnovu marke i modela, ako naziv marke i modela nije null.
	 * 
	 * @param markaModel naziv marke i modela guma
	 * @return Lista koja sadrzi sve pronadjene gume po kriterijumu naziva marke i modela guma
	 * 
	 * @throws java.lang.NullPointerException ako je uneti naziv marke i modela null
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);
	
	/**
	 * Vraca sve gume koje postoje u radnji
	 * 
	 * @return Listu svih guma iz radnje
	 */
	List<AutoGuma> vratiSveGume();
}
