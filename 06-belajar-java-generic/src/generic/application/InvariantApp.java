package generic.application;

import generic.MyData;

public class InvariantApp {
    public static void main(String[] args) {
        MyData<String> stringMyData = new MyData<>("Budi");
        // doItObject(stringMyData); // ERROR
        // MyData<Object> objectStringMyData = stringMyData; // ERROR

        MyData<Object> objectMyData = new MyData<>(1000);
        // doItInteger(objectMyData); // ERROR
        // MyData<Integer> integerMyData = objectMyData; // ERROR
    }

    public static void doItObject(MyData<Object> objectMyData) {
        // Do nothing
    }

    public static void doItInteger(MyData<Integer> integerMyData) {
        // Do nothing
    }
}
