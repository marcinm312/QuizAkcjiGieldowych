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

        ArrayList<String> daneAkcji = new ArrayList<>();
        odczytDanych(daneAkcji);

        String tempLine;
        String[] tempWektorStr;

        ArrayList<Akcja> listaAkcji = new ArrayList<>();
        for (int i = 0; i < daneAkcji.size(); i++) {
            tempLine = daneAkcji.get(i);
            tempWektorStr = tempLine.split(":");
            Akcja tempAkcja = new Akcja(tempWektorStr[0], tempWektorStr[1],
                    Double.parseDouble(tempWektorStr[3]));

            listaAkcji.add(i, tempAkcja);
        }

        int punktacja;
        int sumaPunktow = 0;
        for (Akcja akcja : listaAkcji) {
            System.out.println("\nPodaj giełdowy skrót spółki " + akcja.getNazwaAkcji()
                    + " (ostatni kurs " + akcja.getKursAkcji() + "):");
            Scanner scan = new Scanner(System.in);
            String wartoscUsera = scan.nextLine().toUpperCase();

            if (wartoscUsera.equals(akcja.getSkrotAkcji())) {
                punktacja = 3;
                System.out.println("Poprawna odpowiedź, jesteś mistrzem i dostajesz 3 punkty :)");
            } else {
                punktacja = -2;
                System.out.println("Niestety popełniłeś błąd. Przykro mi, ale muszę ci zabrać 2 punkty :(");
            }
            sumaPunktow = sumaPunktow + punktacja;
            System.out.println("Aktualna punktacja: " + sumaPunktow + " pkt.");
        }
        System.out.println("\nKONIEC. Zdobyto " + sumaPunktow + " pkt.");

    }

    public static void odczytDanych(ArrayList<String> lista) {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);

        try {
            FileReader fr = new FileReader(/*"AkcjeQuiz/" +*/ "resources/akcje.txt");
            BufferedReader bfr = new BufferedReader(fr);
            String odczytanaLinia;
            int idxListyDanych = 0;
            while ((odczytanaLinia = bfr.readLine()) != null) {
                lista.add(idxListyDanych, odczytanaLinia);
                idxListyDanych++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Pojawił sie błąd wejścia wyjścia");
            e.printStackTrace();
        }
    }
}
