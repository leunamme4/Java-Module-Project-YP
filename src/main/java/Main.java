import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guests;
        while (true) {
            System.out.println("На сколько человек необходимо разделить счёт?");
            if (scanner.hasNextInt()) {
                guests = scanner.nextInt();
                scanner.nextLine(); // нужно для "поглощения" символа новой строки и дальнейшего использования экземпляра scanner
                if (guests < 1) {
                    System.out.println("Введено некорректное для подсчета значение, значение должно быть больше 1");
                } else if (guests == 1) {
                    System.out.println("Придется платить за счет одному, поделить не получится :(\nВозвращайтесь с компанией и попробуйте снова");
                } else {
                    System.out.println("Отлично! Начнём подсчёт ^_^");
                    break;
                }
            } else {
                scanner.nextLine(); // нужно для "поглощения" символа новой строки и дальнейшего использования экземпляра scanner
                System.out.println("Неверный формат ввода. Введите целое число.");
            }
        }

        Calculator calculator = new Calculator();

        while (true) {
            double price;
            String name;

            //запрашиваем название товара
            while (true) {
                System.out.println("\nВведите название товара:");
                name = scanner.nextLine();

                if (name.isEmpty()) {
                    System.out.println("Название товара не может быть пустым");
                } else {
                    break;
                }
            }

            // зарпрашиваем цену товара
            while (true) {
                System.out.println("Введите цену товара в формате \"рубли,копейки\":");
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    scanner.nextLine(); // нужно для "поглощения" символа новой строки и дальнейшего использования экземпляра scanner
                    if (price < 0.0) {
                        System.out.println("Цена не может быть меньше 0");
                    } else {
                        break;
                    }
                } else {
                    scanner.nextLine(); // нужно для "поглощения" символа новой строки и дальнейшего использования экземпляра scanner
                    System.out.println("Неверный формат, введите цену товара в формате \"рубли,копейки\":");
                }
            }

            calculator.addProduct(name, price); // добавляем товар
            System.out.println("Если хотите завершить добавление товаров, введите \"Завершить\", хотите продолжить - введите любой символ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("Завершить")) {
                calculator.printAll(guests); // вывод списка товаров и подсчет суммы
                break;
            }
        }
    }
}