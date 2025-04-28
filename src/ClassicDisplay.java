import java.util.Arrays;

public class ClassicDisplay extends DisplayPlan {

    @Override
    void modifyResultToView(Long dividend, Integer divisor) {
        int[] index = new int[3];
        for (int i = 0, j = 0; i < result.length(); i++) {
            if (result.charAt(i) == '\n') {
                index[j] = i;
                j++;
            }

            if (j == 3) {
                break;
            }
        }

        long tab = calculateDigit(Math.abs(dividend)) + (dividend < 0 ? 2 : 1) - index[0];
        boolean isNegative = (dividend < 0 || divisor < 0) && !(dividend < 0 && divisor < 0);
        int offsetRightSide = isNegative || divisor < 0 ? 1 : 0;

        result.insert(index[2], assemblyString(tab, ' ') +"│" + (isNegative ? '-' : "") + quotient.toString());
        result.insert(index[1], assemblyString(tab, ' ') +"│" + assemblyString(quotient.length() + offsetRightSide, '-'));
        result.insert(index[0], "│" + divisor);
        result.replace(1, index[0], dividend.toString());
    }

    @Override
    StringBuilder display(Long dividend, int divisor) {
        long absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);

        String[] digits = String.valueOf(absDividend).split("");
        int reminderNumber;
        int multiplyResult;
        int divisorDigit = calculateDigit(absDivisor);
        Integer tempRemainder;

        int offset = dividend < 0 ? 3 : 2;

        for (int i = 0; i < digits.length; i++) {
            reminder.append(digits[i]);
            reminderNumber = Integer.parseInt(reminder.toString());

            if (reminderNumber >= absDivisor) {
                tempRemainder = reminderNumber % absDivisor;
                multiplyResult = reminderNumber / absDivisor * absDivisor;

                String lastReminder = String.format("%" + (i + offset) + "s", "_" + reminderNumber);
                result.append(lastReminder).append("\n");

                String multiply = String.format("%" + (i + offset) + "d", multiplyResult);
                result.append(multiply).append("\n");

                Integer tab = lastReminder.length() - calculateDigit(multiplyResult);
                result.append(makeDivider(reminderNumber, tab)).append("\n");

                quotient.append(reminderNumber / absDivisor);

                reminder.replace(0, reminder.length(), tempRemainder.toString());
                reminderNumber = Integer.parseInt(reminder.toString());
            } else {
                if (i >= divisorDigit) {
                    quotient.append(0);
                }
            }

            if (i == digits.length - 1) {
                result.append(String.format("%" + (i + offset) + "s", reminderNumber)).append("\n");
            }
        }

        modifyResultToView(dividend, divisor);

        return result;
    };
}
