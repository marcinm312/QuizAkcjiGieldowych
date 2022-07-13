package pl.marcinm312;

public class Stock {

    private final String name;
    private final String code;
    private final double stockPrice;

    public Stock(String[] stockArray) {

        if (stockArray.length < 4) {
            throw new ValidationException("Wiersz zawiera zbyt mało danych!");
        }

        String nameFromArray = stockArray[0];
        if (nameFromArray == null || nameFromArray.trim().isEmpty()) {
            throw new ValidationException("Nazwa akcji nie może być pusta!");
        }
        this.name = nameFromArray.trim();

        String codeFromArray = stockArray[1];
        if (codeFromArray == null || codeFromArray.trim().isEmpty()) {
            throw new ValidationException("Skrót akcji nie może być pusty!");
        }
        this.code = codeFromArray.trim();

        String stockPriceFromArray = stockArray[3];
        if (stockPriceFromArray == null || stockPriceFromArray.trim().isEmpty()) {
            throw new ValidationException("Kurs akcji nie może być pusty!");
        }
        try {
            this.stockPrice = Double.parseDouble(stockPriceFromArray.trim());
        } catch (Exception e) {
            throw new ValidationException("Kurs akcji nie jest liczbą!");
        }
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getStockPrice() {
        return stockPrice;
    }
}
