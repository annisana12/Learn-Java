public class PersonApp {
    public static void main(String[] args) {
        // Belajar membuat object
        var person1 = new Person("Joko", "Jakarta");
        person1.address = "Jambi";
        System.out.println("Person 1: " + person1.name + ", " + person1.address + ", " + person1.country);

        person1.sayHello("Budi");

        Person person2 = new Person("Budi");
        System.out.println("Person 2: " + person2.name + ", " + person2.address + ", " + person2.country);

        Person person3;
        person3 = new Person();

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
    }
}
