package application;

import java.util.Scanner;

public class ScannerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Input dari console

        System.out.print("Nama : ");
        String name = scanner.nextLine();

        System.out.print("umur : ");
        int umur = scanner.nextInt();

        System.out.println("Halo " + name + ", umur Anda " + umur);
    }
}
