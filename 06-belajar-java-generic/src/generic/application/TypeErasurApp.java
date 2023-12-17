package generic.application;

import generic.MyData;

public class TypeErasurApp {
    public static void main(String[] args) {
        MyData myData = new MyData("Budi");

        MyData<Integer> integerMyData = (MyData<Integer>) myData;
        Integer integer = integerMyData.getData(); // Error saat di run
    }
}
