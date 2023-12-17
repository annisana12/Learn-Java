package application;

import java.util.StringTokenizer;

public class StringTokenizerApp {
    public static void main(String[] args) {
        String name = "John F. Khennedy";

        StringTokenizer tokenizer = new StringTokenizer(name, " ");

        while (tokenizer.hasMoreTokens()) {
            String value = tokenizer.nextToken();
            System.out.println(value);
        }

        // Tokenizer motong stringnya lazy (dipotong satu satu dari awal)
        // Split motong semua bagian string sekaligus di awal
    }
}
