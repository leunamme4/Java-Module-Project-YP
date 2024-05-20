public class Formatter {
    public static String priceFormat (double price) {
        return String.format("%.2f", price).replace(',', '.');
    }

    public static String rublesFormat (double price) {
        int number = ((int) Math.floor(price) % 10); // извлекаем наименьший разряд из цены
        return switch (number){
            case 1 -> "рубль";
            case 2, 3, 4 -> "рубля";
            case 0, 5, 6, 7, 8, 9 -> "рублей";
            default -> throw new IllegalStateException("Unexpected value: " + number);
        };
    }
}
