public class ClassicDisplay extends DisplayPlan {

    @Override
    StringBuilder display(int dividend, int divisor) {
        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);

        String[] digits = String.valueOf(absDividend).split("");
        int reminderNumber;
        int multiplyResult;
        int divisorDigit = calculateDigit(absDivisor);
        int tempRemainder;

        int offset = dividend < 0 ? 3 : 2;

        for (int i = 0; i < digits.length; i++) {
            reminder.append(digits[i]);
            reminderNumber = Integer.parseInt(reminder.toString());

            if (reminderNumber >= absDivisor) {
                tempRemainder = reminderNumber % absDivisor;
                multiplyResult = reminderNumber / absDivisor * absDivisor;

                String lastReminder = String.format("%" + (i + offset) + "s", "_" + reminderNumber);
                result.append(lastReminder).append(newLine);

                String multiply = String.format("%" + (i + offset) + "d", multiplyResult);
                result.append(multiply).append(newLine);

                Integer tab = lastReminder.length() - calculateDigit(multiplyResult);
                result.append(makeDivider(reminderNumber, tab)).append(newLine);

                quotient.append(reminderNumber / absDivisor);

                reminder.replace(0, reminder.length(), Integer.toString(tempRemainder));
                reminderNumber = Integer.parseInt(reminder.toString());
            } else {
                if (i >= divisorDigit) {
                    quotient.append(0);
                }
            }

            if (i == digits.length - 1) {
                result.append(String.format("%" + (i + offset) + "s", reminderNumber)).append(newLine);
            }
        }

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
    };
}
