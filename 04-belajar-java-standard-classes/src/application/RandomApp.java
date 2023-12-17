package application;

import java.util.Random;

public class RandomApp {
    public static void main(String[] args) {
        Random random = new Random(); // generate random number

        for (var i = 0; i <= 10; i++) {
            int randomInt = random.nextInt(1000); // maksimal 1000
            System.out.println(randomInt);
        }
    }
}
