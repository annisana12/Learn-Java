package belajar_package.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadApp {
    public static void main(String[] args) {
        // Close file manual
//        BufferedReader reader = null;
//
//        try {
//            reader = new BufferedReader(
//                    new FileReader("README.md")
//            );
//
//            while (true) {
//                String line = reader.readLine();
//
//                if (line == null) {
//                    break;
//                }
//
//                System.out.println(line);
//            }
//        } catch (Throwable throwable) {
//            System.out.println("Error membaca file: " + throwable.getMessage());
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                    System.out.println("Sukses menutup file");
//                } catch (IOException exception) {
//                    System.out.println("Error menutup resource: " + exception.getMessage());
//                }
//            }
//        }

        /**
         * Close file menggunakan try with resource
         * syaratnya resource harus turunan AutoClosable
         */
        try (BufferedReader reader = new BufferedReader(new FileReader("README.md"))) {
            while (true) {
                String line = reader.readLine();

                if (line == null) {
                    break;
                }

                System.out.println(line);
            }
        } catch (Throwable exception) {
            System.out.println("Error membaca file " + exception.getMessage());
        }
    }
}
