package bankomat;

import java.util.Scanner;

public class BankomatTest {

	public static void main(String[] args) {
		Bankomat korisnik = new Bankomat();
		Scanner input = new Scanner(System.in);
		int izbor = -1;
		do {
			Bankomat.ispisiPocetniMeni();

			izbor = input.nextInt();
			switch (izbor) {
			case 0:
				System.out.println("kraj");
				break;
			case 1:
				int logInBrojRacuna = 0;
				while (!korisnik.doesExist(logInBrojRacuna)) {
					System.out.println("Unesi svoj broj raèuna:");
					int unosRacun = input.nextInt();
					if (korisnik.doesExist(unosRacun)) {
						logInBrojRacuna = unosRacun;
						Bankomat.ispisiMeni();

						switch (input.nextInt()) {
						case 1:
							korisnik.ispisiInformacije(unosRacun);
							break;
						case 2:
							int sourceAcc = logInBrojRacuna;
							int targetAcc = 0;
							double balance = korisnik.stanjeRacuna(sourceAcc);
							double transferIznos = 0;
							while (transferIznos <= 0) {
								System.out.println("Unesi iznos koji zelis prebaciti: ");
								transferIznos = input.nextDouble();
								if (transferIznos <= balance) {
									while (!korisnik.doesExist(targetAcc)) {
										System.out.println("Unesi broj racuna na koji zelis prebaciti sredstva: ");
										int unosTarget = input.nextInt();
										if (korisnik.doesExist(unosTarget)) {
											targetAcc = unosTarget;
											korisnik.uvecajStanje(targetAcc, transferIznos);
											korisnik.umanjiStanje(sourceAcc, transferIznos);
											System.out.println(
													"Uspjesno ste prebacili sredstva.\nVase novo stanje na racunu iznosi: "
															+ korisnik.stanjeRacuna(sourceAcc) + " KM.\n");
										} else
											System.out.println("Ne mozes prebaciti sredstva, taj raèun ne postoji.");

									}
								} else {
									System.out.println("Nemate dovoljno sredstava na raèunu.");
								}
							}

						}
					} else {
						System.out.println("Uneseni broj racuna ne postoji u bazi.\n");

					}
				}
				break;
			case 2:
				String unosIme = " ";
				while (!korisnik.isValidName(unosIme)) {
					System.out.println("Unesi ime:");
					unosIme = input.next();
					if (korisnik.isValidName(unosIme)) {
						double unosStanje = -1;
						while (unosStanje < 0) {
							System.out.println("Unesi stanje racuna:");
							unosStanje = input.nextDouble();
							if (unosStanje > 0) {
								System.out.println("\tUspjesno ste registrovani.\n\t* * * Vasi podaci: ");
								korisnik.dodajUBazu(unosIme, unosStanje);

							} else
								System.out.println("Stanje na raèunu mora biti vece od nule.");
						}
					} else
						System.out.println("Ime se mora sastojati samo od slova.");
				}

				break;

			default:
				System.out.println("Pogresan unos!");
			}

		} while (izbor != 0);
		// System.out.println(korisnik.getBaza());
		input.close();
	}

}
