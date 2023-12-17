package application;

import java.util.UUID;

public class UUIDApp {
    public static void main(String[] args) {
        for (var i = 0; i <= 10; i++) {
            UUID uuid = UUID.randomUUID();
            System.out.println(uuid);

            // convert to string
            String stringUUID = uuid.toString();
            System.out.println("String UUID: " + stringUUID);
        }
    }
}
