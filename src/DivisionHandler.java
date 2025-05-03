public class DivisionHandler {

    public String divide(int dividend, int divisor, Main.DivisionType divisionType) throws DivisionException {
        if (divisor == 0) {
            throw new DivisionException("Деление на ноль невозможно");
        }

        if (Math.abs(dividend) < Math.abs(divisor)) {
            return dividend + " : " + divisor + " = 0";
        }

        GermanDisplay germanDisplay = new GermanDisplay();
        ClassicDisplay classicDisplay = new ClassicDisplay();

        if (divisionType == Main.DivisionType.CLASSIC) {
            return classicDisplay.display(dividend, divisor).toString();
        } else {
            return germanDisplay.display(dividend, divisor).toString();
        }
    }

}