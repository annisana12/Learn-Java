public class PolymorphismApp {
    public static void main(String[] args) {
        Employee employee = new Employee("Eko");
        employee.sayHello("Budi");

        employee = new Manager("Joko");
        employee.sayHello("Budi");
        // employee.company = "JP"; // Tidak bisa akses field company

        employee = new VicePresident("Dito");
        employee.sayHello("Budi");

        sayHello(new Employee("Eko"));
        sayHello(new Manager("Joko"));
        sayHello(new VicePresident("Dito"));
    }

    static void sayHello(Employee employee) {
        if (employee instanceof VicePresident) {
            VicePresident vp = (VicePresident) employee;
            System.out.println("Hello VP " + vp.name);
        } else if (employee instanceof Manager) {
            Manager manager = (Manager) employee;
            System.out.println("Hello manager " + manager.name);
        } else {
            System.out.println("Hello " + employee.name);
        }
    }
}
