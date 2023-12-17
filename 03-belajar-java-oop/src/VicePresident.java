/**
 * Belajar inheritance
 */
class VicePresident extends Manager {
    VicePresident(String name) {
        super(name);
    }

    // Method Overriding
    void sayHello(String name) {
        System.out.println("Hello " + name + ", my name is vp " + this.name);
    }
}
