public class Divider {

    public String divide(long dividend, int divisor, int divisionType) throws DivisionException {
        if (divisor == 0) {
            throw new DivisionException("Деление на ноль невозможно");
        }

        if (Math.abs(dividend) < Math.abs(divisor)) {
            return dividend + " : " + divisor + " = 0";
        }

        GermanDisplay germanDisplay = new GermanDisplay();
        ClassicDisplay classicDisplay = new ClassicDisplay();

        if (divisionType == 1) {
            return classicDisplay.display(dividend, divisor).toString();
        } else {
            return germanDisplay.display(dividend, divisor).toString();
        }
    }

}