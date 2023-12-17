/**
 * Belajar class, field, constructor, method
 */
class Person {
    String name;
    String address;
    final String country = "Indonesia";

    Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    Person(String name) {
        this(name, null);
    }

    Person() {
        this(null);
    }

    void sayHello(String name) {
        System.out.println("Hi " + name + ", My name is " + this.name);
    }
}
