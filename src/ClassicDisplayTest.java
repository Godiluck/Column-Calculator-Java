import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ClassicDisplayTest {

    @Test
    public void testClassicValidExample() {
        DivisionHandler divider = new DivisionHandler();
        String result = divider.divide(10, 2, Main.DivisionType.CLASSIC);

        String assertion = """
                _10|2
                 10|-
                 --|5
                  0
                """;

        assertEquals(assertion, result);
    }

    @Test
    public void testClassicZeroDivisor() {
        DivisionHandler divider = new DivisionHandler();
        String assertion = "Деление на ноль невозможно";
        DivisionException divisionException = assertThrows(DivisionException.class, () -> divider.divide(10, 0, Main.DivisionType.CLASSIC));

        assertEquals(assertion, divisionException.getMessage());
    }

    @Test
    public void testClassicZeroResult1() {
        DivisionHandler divider = new DivisionHandler();
        String result = divider.divide(2, 10, Main.DivisionType.CLASSIC);

        String assertion = "2 : 10 = 0";

        assertEquals(assertion, result);
    }

    @Test
    public void testClassicZeroResult2() {
        DivisionHandler divider = new DivisionHandler();
        String result = divider.divide(0, 10, Main.DivisionType.CLASSIC);

        String assertion = "0 : 10 = 0";

        assertEquals(assertion, result);
    }

    @Test
    public void testClassicNegativeResult1() {
        DivisionHandler divider = new DivisionHandler();
        String result = divider.divide(-10, 2, Main.DivisionType.CLASSIC);

        String assertion = """
                -10|2
                 10|--
                 --|-5
                  0
               """;

        assertEquals(assertion, result);
    }

    @Test
    public void testClassicNegativeResult2() {
        DivisionHandler divider = new DivisionHandler();
        String result = divider.divide(10, -2, Main.DivisionType.CLASSIC);

        String assertion = """
                _10|-2
                 10|--
                 --|-5
                  0
                """;

        assertEquals(assertion, result);
    }

}