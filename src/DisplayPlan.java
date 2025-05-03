public abstract class DisplayPlan {

    protected StringBuilder result = new StringBuilder();
    protected StringBuilder quotient = new StringBuilder();
    protected StringBuilder reminder= new StringBuilder();

    protected char newLine = '\n';
    protected char whitespace = ' ';
    protected String dashChar = "|";

    abstract StringBuilder display(int dividend, int divisor);

    void appendDivisionTable(int dividend, int divisor, Main.DivisionType divisionType) {
        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);

        String[] digits = String.valueOf(absDividend).split("");
        int reminderNumber;
        int multiplyResult;
        int divisorDigit = calculateDigit(absDivisor);
        int tempRemainder;

        int offset = dividend < 0 ? 2 : 1;

        if (divisionType == Main.DivisionType.CLASSIC) {
            offset++;
        }

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
    }

    String assemblyString(int numberOfSymbols, char symbol) {
        return String.valueOf(symbol).repeat(Math.max(0, numberOfSymbols));
    }

    int calculateDigit(int i) {
        return (int) Math.log10(i) + 1;
    }

    String makeDivider(Integer reminderNumber, Integer tab) {
        return assemblyString(tab, whitespace) + assemblyString(calculateDigit(reminderNumber), '-');
    }
}
