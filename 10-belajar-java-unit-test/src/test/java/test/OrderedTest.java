package test;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {

    private int counter;

    @BeforeAll
    public void beforeAll() {
        // Lifecycle.PER_CLASS memungkinkan beforeAll dan afterAll non static
        System.out.println("Before Class");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After Class");
    }

    @Test
    @Order(1)
    public void test3() {
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(2)
    public void test2() {
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(3)
    public void test1() {
        counter++;
        System.out.println(counter);
    }
}
