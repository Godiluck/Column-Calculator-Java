public class ClassicDisplay extends DisplayPlan {

    @Override
    StringBuilder display(int dividend, int divisor) {
        appendDivisionTable(dividend, divisor, Main.DivisionType.CLASSIC);

        int[] index = new int[3];
        for (int i = 0, j = 0; i < result.length(); i++) {
            if (result.charAt(i) == newLine) {
                index[j] = i;
                j++;
            }

            if (j == 3) {
                break;
            }
        }

        int tab = calculateDigit(Math.abs(dividend)) + (dividend < 0 ? 2 : 1) - index[0];
        boolean isNegative = (dividend < 0 || divisor < 0) && !(dividend < 0 && divisor < 0);
        int offsetRightSide = isNegative || divisor < 0 ? 1 : 0;
        String negativeCaseChar = isNegative ? "-" : "";

        result.insert(index[2], assemblyString(tab, ' ') + dashChar + negativeCaseChar + quotient.toString());
        result.insert(index[1], assemblyString(tab, whitespace) + dashChar + assemblyString(quotient.length() + offsetRightSide, '-'));
        result.insert(index[0], dashChar + divisor);
        result.replace(1, index[0], String.valueOf(dividend));

        return result;
    }
}
