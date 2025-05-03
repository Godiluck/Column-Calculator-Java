import java.util.Scanner;

public class Main {
    public enum DivisionType {
        CLASSIC,
        GERMAN
    }

    public static void main(String[] args) throws InputDataException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите делимое: ");
        String dividend = scanner.nextLine();

        if (!dividend.matches("-?\\d+(\\.\\d+)?")) {
            throw new InputDataException("Неверный формат делимого");
        }

        System.out.println("Введите делитель: ");
        String divisor = scanner.nextLine();

        if (!divisor.matches("-?\\d+(\\.\\d+)?")) {
            throw new InputDataException("Неверный формат делителя");
        }

        System.out.println("Выберите систему деления: 1 - классическая, 2 - немецкая");
        String divisionTypeScanner = scanner.nextLine();

        if (!divisionTypeScanner.equals("1") && !divisionTypeScanner.equals("2")) {
            throw new InputDataException("Неверный формат деления");
        }

        DivisionType divisionType = divisionTypeScanner.equals("1") ? DivisionType.CLASSIC : DivisionType.GERMAN;

        DivisionHandler divider = new DivisionHandler();

        try {
            String result = divider.divide(Integer.parseInt(dividend), Integer.parseInt(divisor), divisionType);
            System.out.println(result);
        } catch (DivisionException e) {
            throw new DivisionException(e.getMessage());
        }

        scanner.close();
    };
}