public abstract class DisplayPlan {

    StringBuilder result = new StringBuilder();
    StringBuilder quotient = new StringBuilder();
    StringBuilder reminder= new StringBuilder();

    abstract StringBuilder display(Long dividend, int divisor);

    String assemblyString(long numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }

    int calculateDigit(long i) {
        return (int) Math.log10(i) + 1;
    }

    String makeDivider(Integer reminderNumber, Integer tab) {
        return assemblyString(tab, ' ') + assemblyString(calculateDigit(reminderNumber), '-');
    }

    abstract void modifyResultToView(Long dividend, Integer divisor);
}
