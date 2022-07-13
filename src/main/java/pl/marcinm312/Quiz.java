package pl.marcinm312;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {

		List<Stock> stocks = readDataFromFile();

		int sumOfPoints = 0;
		for (Stock stock : stocks) {

			System.out.println("\nPodaj giełdowy skrót spółki " + stock.getName()
					+ " (ostatni kurs " + stock.getStockPrice() + "):");
			Scanner scanner = new Scanner(System.in);
			String userInput = scanner.nextLine().trim().toUpperCase();

			int points;
			if (userInput.equals(stock.getCode())) {
				points = 3;
				System.out.println("Poprawna odpowiedź, jesteś mistrzem i dostajesz 3 punkty :)");
			} else {
				points = -2;
				System.out.println("Niestety popełniłeś błąd. Przykro mi, ale muszę ci zabrać 2 punkty :(");
			}

			sumOfPoints = sumOfPoints + points;
			System.out.println("Aktualna punktacja: " + sumOfPoints + " pkt.");
		}
		System.out.println("\nKONIEC. Zdobyto " + sumOfPoints + " pkt.");
	}

	public static List<Stock> readDataFromFile() {

		List<Stock> stocks = new ArrayList<>();
		String fileSeparator = FileSystems.getDefault().getSeparator();

		try (FileReader fr = new FileReader("resources" + fileSeparator + "akcje.txt");
			 BufferedReader bfr = new BufferedReader(fr)) {

			String line;
			while ((line = bfr.readLine()) != null) {
				createStock(stocks, line);
			}

		} catch (Exception e) {
			System.err.println("Wystąpił błąd podczas odczytu pliku: " + e.getMessage());
		}

		return stocks;
	}

	private static void createStock(List<Stock> stocks, String line) {
		
		try {
			Stock stock = new Stock(line.split(":"));
			stocks.add(stock);
		} catch (Exception e) {
			System.err.println("Wystąpił błąd podczas odczytu akcji: " + e.getMessage());
		}
	}
}
