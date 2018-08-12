package bankomat;

import java.util.ArrayList;

public class Bankomat {

	private ArrayList<String> baza = new ArrayList<>();
	private int brojRacuna;

	Bankomat() {
	}

	Bankomat(ArrayList<String> baza) {
		this.baza = baza;
	}

	public ArrayList<String> getBaza() {
		return baza;
	}

	public void setBaza(ArrayList<String> baza) {
		this.baza = baza;
	}

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public void dodajUBazu(String ime, double stanje) {
		do {
			brojRacuna = (int) (100000 + Math.random() * 900000);
		} while (baza.contains(String.valueOf(brojRacuna)));
		baza.add(String.valueOf(brojRacuna));
		int i = baza.indexOf(String.valueOf(brojRacuna));
		baza.add(i + 1, ime);
		baza.add(i + 2, String.valueOf(stanje));
		ispisiInformacije(brojRacuna);
	}

	public void ispisiInformacije(int brojRacuna) {
		int i = baza.indexOf(String.valueOf(brojRacuna));
		System.out.println("\tIme korisnika racuna: " + baza.get(i + 1));
		System.out.println("\tBroj partije: " + baza.get(i));
		System.out.println("\tStanje na raèunu iznosi: " + baza.get(i + 2) + " KM.\n");
	}

	public boolean doesExist(int unosBroj) {
		String s = String.valueOf(unosBroj);
		if (baza.contains(s))
			return true;
		return false;
	}

	public boolean isValidName(String s) {
		return s.matches("[a-zA-Z]+");
	}

	static void ispisiPocetniMeni() {
		System.out.println("Izaberi 1 ili 2 ili 0:");
		System.out.println("1. Log in\n2. Registracija\n0. Kraj");
	}

	static void ispisiMeni() {
		System.out.println("Izaberi opciju:");
		System.out.println("1. Informacije o stanju na racunu\n2. Transfer");
	}

	public double stanjeRacuna(int brojRacuna) {
		int i = baza.indexOf(String.valueOf(brojRacuna));
		String stanje = baza.get(i + 2);
		double stanjeR = Double.parseDouble(stanje);
		return stanjeR;
	}

	public double umanjiStanje(int brojRacuna, double iznos) {
		int i = baza.indexOf(String.valueOf(brojRacuna));
		double stanjeR = Double.parseDouble(baza.get(i + 2)) - iznos;
		baza.add(i + 2, String.valueOf(stanjeR));
		return stanjeR;
	}

	public double uvecajStanje(int brojRacuna, double iznos) {
		int i = baza.indexOf(String.valueOf(brojRacuna));
		double stanjeR = Double.parseDouble(baza.get(i + 2)) + iznos;
		baza.add(i + 2, String.valueOf(stanjeR));
		return stanjeR;
	}
}
