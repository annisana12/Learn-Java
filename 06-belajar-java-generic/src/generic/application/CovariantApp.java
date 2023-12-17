package generic.application;

import generic.MyData;

// Substitusi dari child ke parent
public class CovariantApp {
    public static void main(String[] args) {
        MyData<String> stringMyData = new MyData<>("Budi");
        process(stringMyData);

        MyData<? extends Object> myData = stringMyData;
    }

    public static void process(MyData<? extends Object> objectMyData) {
        System.out.println(objectMyData.getData());
        // objectMyData.setData("Joko"); Tidak dapat mengubah data
    }
}
