package test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {
    @Test
    public void testMock() {
        // Throw exception IndexOutOfBoundsException
        // List<String> list = new ArrayList<>();
        // System.out.println(list.get(0));

        // Membuat object tiruan dari class List menggunakan Mockito
        List<String> list = Mockito.mock(List.class);

        // Menambahkan behaviour pada mocking
        Mockito.when(list.get(0)).thenReturn("Budi");

        System.out.println(list.get(0));
        System.out.println(list.get(100)); // null

        // verifikasi method get(0) dipanggil 1x
        Mockito.verify(list, Mockito.times(1)).get(0);
    }
}
