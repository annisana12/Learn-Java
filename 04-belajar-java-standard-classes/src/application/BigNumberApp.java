package application;

import java.math.BigInteger;

public class BigNumberApp {
    public static void main(String[] args) {
        // BigInteger digunakan untuk menyimpan number yang melebihi kapasitas long
        BigInteger a = new BigInteger("100000000000000000000");
        BigInteger b = new BigInteger("100000000000000000000");

        BigInteger c = a.add(b);
        BigInteger d = c.subtract(a);

        System.out.println(c);
        System.out.println(d);
    }
}
