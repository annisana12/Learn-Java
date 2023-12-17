package belajar_package.application;

import belajar_package.data.LoginRequest;

public class RecordApp {
    public static void main(String[] args) {
        LoginRequest loginRequest = new LoginRequest("Budi", "Rahasia");
        System.out.println(loginRequest);
        System.out.println(loginRequest.username());
        System.out.println(loginRequest.password());

        System.out.println(new LoginRequest());
        System.out.println(new LoginRequest("Dito"));

        LoginRequest loginRequest2 = new LoginRequest("Budi", "Rahasia");
        System.out.println(loginRequest.equals(loginRequest2));

        loginRequest.sayHello("Dito");
    }
}
