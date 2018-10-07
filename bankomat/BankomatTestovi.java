package bankomat;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BankomatTestovi {
	Bankomat korisnik = new Bankomat();
	ArrayList<String> baza = new ArrayList<>();
	int brojRacuna;
	String ime;
	double stanjeR;
	private static final double DELTA = 1e-15;

	@Before
	public void setUp() {
		korisnik.dodajUBazu("miki maus", 100);
		brojRacuna = korisnik.getBrojRacuna();

	}

	@Test
	public void shouldReturnTrueWhenAccountDoesExist() {
		boolean result = korisnik.doesExist(brojRacuna);
		assertEquals(true, result);
	}

	@Test
	public void shouldReturnFalseWhenAccountDoesNotExist() {
		boolean result = korisnik.doesExist(123);
		assertEquals(false, result);
	}

	@Test
	public void shouldReturnTrueWhenNameIsValid() {
		boolean result = korisnik.isValidName("NekoIme");
		assertEquals(true, result);
	}

	@Test
	public void shouldReturnFalseWhenNameIsInvalid() {
		boolean result = korisnik.isValidName("56 ");
		assertEquals(false, result);
	}

	@Test
	public void shouldReturn100WhenBalanceIs100() {
		double result = korisnik.stanjeRacuna(brojRacuna);
		assertEquals(100.00, result, DELTA);
	}

	@Test
	public void shouldReturn75WhenBalanceIs100() {
		double result = korisnik.umanjiStanje(brojRacuna, 25);
		assertEquals(75, result, DELTA);
	}

	@Test
	public void shouldReturn120WhenBalanceIs100() {
		double result = korisnik.uvecajStanje(brojRacuna, 20);
		assertEquals(120, result, DELTA);
	}
}
