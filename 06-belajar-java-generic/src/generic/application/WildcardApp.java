package generic.application;

import generic.MyData;

public class WildcardApp {
    public static void main(String[] args) {
        print(new MyData<>("Budi"));
        print(new MyData<>(1000));
        print(new MyData<>(new MultipleConstraintApp.Manager()));
    }

    public static void print(MyData<?> myData) {
        System.out.println(myData.getData());
    }
}
