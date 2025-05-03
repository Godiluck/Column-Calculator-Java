public abstract class DisplayPlan {

    protected StringBuilder result = new StringBuilder();
    protected StringBuilder quotient = new StringBuilder();
    protected StringBuilder reminder= new StringBuilder();

    protected char newLine = '\n';
    protected char whitespace = ' ';
    protected String dashChar = "|";

    abstract StringBuilder display(int dividend, int divisor);

    String assemblyString(int numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }

    int calculateDigit(int i) {
        return (int) Math.log10(i) + 1;
    }

    String makeDivider(Integer reminderNumber, Integer tab) {
        return assemblyString(tab, ' ') + assemblyString(calculateDigit(reminderNumber), '-');
    }
}
