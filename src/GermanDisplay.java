public class GermanDisplay extends DisplayPlan {

    @Override
    void modifyResultToView(Long dividend, Integer divisor) {
        int firstLineIndex = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '\n') {
                firstLineIndex = i;
                break;
            }
        }

        boolean isNegative = (dividend < 0 || divisor < 0) && !(dividend < 0 && divisor < 0);

        result.replace(0, firstLineIndex, dividend + " : " + divisor + " = " + (isNegative ? '-' : "") + quotient);
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

        int offset = dividend < 0 ? 2 : 1;

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
