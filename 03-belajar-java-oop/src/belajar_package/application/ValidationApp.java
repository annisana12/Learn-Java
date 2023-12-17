package belajar_package.application;

import belajar_package.data.LoginRequest;
import belajar_package.error.ValidationException;
import belajar_package.util.ValidationUtil;

public class ValidationApp {
    public static void main(String[] args) {
        LoginRequest loginRequest = new LoginRequest("", "Rahasia");

//        try {
//            ValidationUtil.validate(loginRequest);
//            System.out.println("Data valid");
//        } catch (ValidationException exception) {
//            System.out.println("Data tidak valid: " + exception.getMessage());
//        } catch (NullPointerException exception) {
//            System.out.println("Data null: " + exception.getMessage());
//        }

        // Cara lain
        try {
            ValidationUtil.validate(loginRequest);
            System.out.println("Data valid");
        } catch (ValidationException | NullPointerException e) {
            System.out.println("Data tidak valid: " + e.getMessage());
        } finally {
            System.out.println("Selalu dieksekusi");
        }

        // Runtime exception tidak wajib pakai try catch tapi aplikasi tetap mati kalau terjadi error
        LoginRequest loginRequest2 = new LoginRequest(null, "Rahasia");
        ValidationUtil.validateRuntime(loginRequest2);
    }
}
