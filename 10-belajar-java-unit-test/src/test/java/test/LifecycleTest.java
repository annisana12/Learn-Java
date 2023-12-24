package test;

import org.junit.jupiter.api.Test;

public class LifecycleTest {

    private String name;

    @Test
    public void testA(){
        name = "Budi";
        System.out.println(name);
    }

    @Test
    public void testB() {
        // Akan buat object LifecycleTest baru
        System.out.println(name); // null
    }
}
