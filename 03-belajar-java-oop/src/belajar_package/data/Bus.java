package belajar_package.data;

public class Bus implements Car {

    @Override
    public void drive() {
        System.out.println("Bus drive");
    }

    @Override
    public int getTire() {
        return 8;
    }

    @Override
    public boolean isBig() {
        return true;
    }

    @Override
    public String getBrand() {
        return "Hino";
    }
}
