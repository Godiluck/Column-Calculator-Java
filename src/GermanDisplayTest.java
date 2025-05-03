import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GermanDisplayTest {

    @Test
    public void testGermanValidExample() {
        DivisionHandler divider = new DivisionHandler();
        String result = divider.divide(10, 2, Main.DivisionType.GERMAN);

        String assertion = """
                10 : 2 = 5
                10
                 --
                 0
                """;

        assertEquals(assertion, result);

    }

    @Test
    public void testGermanZeroResult1() {
        DivisionHandler divider = new DivisionHandler();
        String result = divider.divide(2, 10, Main.DivisionType.GERMAN);

        String assertion = "2 : 10 = 0";

        assertEquals(assertion, result);

    }

    @Test
    public void testGermanZeroResult2() {
        DivisionHandler divider = new DivisionHandler();
        String result = divider.divide(0, 10, Main.DivisionType.GERMAN);

        String assertion = "0 : 10 = 0";

        assertEquals(assertion, result);

    }

    @Test
    public void testGermanNegativeResult1() {
        DivisionHandler divider = new DivisionHandler();
        String result = divider.divide(-10, 2, Main.DivisionType.GERMAN);

        String assertion = """
                -10 : 2 = -5
                 10
                 --
                  0
                """;

        assertEquals(assertion, result);
    }

    @Test
    public void testGermanNegativeResult2() {
        DivisionHandler divider = new DivisionHandler();
        String result = divider.divide(10, -2, Main.DivisionType.GERMAN);

        String assertion = """
                10 : -2 = -5
                10
                 --
                 0
                """;

        assertEquals(assertion, result);
    }
}