package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;
import test.generator.SimpleDisplayNameGenerator;


@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
// @DisplayName("Test untuk class Calculator")
public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all");
    }

    @BeforeEach
    public void setup() {
        System.out.println("Before each");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After each");
    }

    // @DisplayName("Test skenario sukses untuk calculator.add(Integer, Integer)")
    @Test
    public void testAddSuccess() {
        var result = calculator.add(10, 10);
        assertEquals(20, result);

//        if (result != 20) {
//            throw new RuntimeException("Test gagal");
//        }
    }

    @Test
    public void testDivideSuccess() {
        var result = calculator.divide(20, 10);
        assertEquals(2, result);
    }

    @Test
    public void testDivideFailed() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }

    @Test
    @Disabled
    public void testComingSoon() {

    }

    @Test
    public void testAborted() {
        var profile = System.getenv("PROFILE");

        if (!"DEV".equals(profile)) {
            throw new TestAbortedException("Test dibatalkan karena bukan di DEV");
        }

        // Unit test untuk DEV
    }

    @Test
    public void testAssumptions() {
        assumeTrue("PROD".equals(System.getenv("PROFILE")));

        // Unit test untuk PROD
    }
}
