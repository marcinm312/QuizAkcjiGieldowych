import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {

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
		int sumaPunkt�w = 0;
		for (int x = 0; x < listaAkcji.size(); x++) {
			System.out.println("\nPodaj gie�dowy skr�t sp�ki " + listaAkcji.get(x).getNazwaAkcji() + " (ostatni kurs "
					+ listaAkcji.get(x).getKursAkcji() + "):");
			Scanner scan = new Scanner(System.in);
			String wartoscUsera = scan.nextLine();

			if (wartoscUsera.equals(listaAkcji.get(x).getSkrotAkcji())) {
				punktacja = 3;
				System.out.println("Poprawna odpowied�, jeste� mistrzem i dostajesz 3 punkty :)");
			} else {
				punktacja = -2;
				System.out.println("Niestety pope�ni�e� b��d. Przykro mi, ale musz� ci zabra� 2 punkty :(");
			}
			sumaPunkt�w = sumaPunkt�w + punktacja;
		}
		System.out.println("\nKONIEC. Zdobyto " + sumaPunkt�w + " pkt.");
	}

	public static void odczytDanych(ArrayList<String> lista) {
		try {
			FileReader fr = new FileReader("akcje.txt");
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
			System.out.println("Pojawi� sie b��d wejscia wyj�cia");
			e.printStackTrace();
		}
	}
}
