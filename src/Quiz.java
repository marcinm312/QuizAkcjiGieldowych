import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {

		while (true) {

			ArrayList<String> daneAkcji = new ArrayList<String>();
			odczytDanych(daneAkcji);

			String tempLine = null;
			String[] tempWektorStr = null;

			ArrayList<Akcja> listaAkcji = new ArrayList<Akcja>();
			for (int i = 0; i < daneAkcji.size(); i++) {
				tempLine = daneAkcji.get(i);
				tempWektorStr = tempLine.split(":");
				Akcja tempAkcja = new Akcja(tempWektorStr[0], tempWektorStr[1], tempWektorStr[2],
						Double.parseDouble(tempWektorStr[3]));

				listaAkcji.add(i, tempAkcja);
			}

			int punktacja = 0;
			int sumaPunktow = 0;
			for (int x = 0; x < listaAkcji.size(); x++) {
				System.out.println("\nPodaj gie³dowy skrót spó³ki " + listaAkcji.get(x).getNazwaAkcji()
						+ " (ostatni kurs " + listaAkcji.get(x).getKursAkcji() + "):");
				Scanner scan = new Scanner(System.in);
				String wartoscUsera = scan.nextLine().toUpperCase();

				if (wartoscUsera.equals(listaAkcji.get(x).getSkrotAkcji())) {
					punktacja = 3;
					System.out.println("Poprawna odpowiedŸ, jesteœ mistrzem i dostajesz 3 punkty :)");
				} else {
					punktacja = -2;
					System.out.println("Niestety pope³ni³eœ b³¹d. Przykro mi, ale muszê ci zabraæ 2 punkty :(");
				}
				sumaPunktow = sumaPunktow + punktacja;
				System.out.println("Aktualna punktacja: " + sumaPunktow + " pkt.");
			}
			System.out.println("\nKONIEC. Zdobyto " + sumaPunktow + " pkt.");
		}
	}

	public static void odczytDanych(ArrayList<String> lista) {
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + s);

		try {
			FileReader fr = new FileReader(/*"AkcjeQuiz/" +*/ "resources/akcje.txt");
			BufferedReader bfr = new BufferedReader(fr);
			String odczytanaLinia = null;
			int idxListyDanych = 0;
			while ((odczytanaLinia = bfr.readLine()) != null) {
				lista.add(idxListyDanych, odczytanaLinia);
				idxListyDanych++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Pojawi³ sie b³¹d wejscia wyjœcia");
			e.printStackTrace();
		}
	}
}
