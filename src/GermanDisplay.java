public class GermanDisplay extends DisplayPlan {

    @Override
    StringBuilder display(int dividend, int divisor) {
        appendDivisionTable(dividend, divisor, Main.DivisionType.GERMAN);

        int firstLineIndex = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == newLine) {
                firstLineIndex = i;
                break;
            }
        }

        boolean isNegative = (dividend < 0 || divisor < 0) && !(dividend < 0 && divisor < 0);
        String negativeCaseChar = isNegative ? "-" : "";

        result.replace(0, firstLineIndex, dividend + " : " + divisor + " = " + negativeCaseChar + quotient);

        return result;
    }
}
