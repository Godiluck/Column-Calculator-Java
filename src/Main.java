import java.util.Scanner;

public class Main {
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
        String divisionType = scanner.nextLine();

        if (!divisor.matches("-?\\d+(\\.\\d+)?")) {
            throw new InputDataException("Неверный формат деления");
        }

        Divider divider = new Divider();

        try {
            String result = divider.divide(Long.parseLong(dividend), Integer.parseInt(divisor), Integer.parseInt(divisionType));
            System.out.println(result);
        } catch (DivisionException e) {
            throw new DivisionException(e.getMessage());
        }

        scanner.close();
    };
}