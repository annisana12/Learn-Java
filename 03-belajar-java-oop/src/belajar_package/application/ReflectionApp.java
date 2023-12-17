package belajar_package.application;

import belajar_package.data.CreateUserRequest;
import belajar_package.util.ValidationUtil;

public class ReflectionApp {
    public static void main(String[] args) {
        CreateUserRequest request = new CreateUserRequest();
        request.setUsername("Budi");
        request.setPassword("Rahasia");

        ValidationUtil.validationReflection(request);
    }
}
