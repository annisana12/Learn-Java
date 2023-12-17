public class ManagerApp {
    public static void main(String[] args) {
        var manager = new Manager("Joko");
        manager.sayHello("Budi");

        var vp = new VicePresident("Dito");
        vp.sayHello("Budi");
    }
}
