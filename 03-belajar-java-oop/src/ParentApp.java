public class ParentApp {
    public static void main(String[] args) {
        Child child = new Child();
        child.name = "Budi";
        child.doIt(); // Do it in Child
        System.out.println(child.name);

        Parent parent = (Parent) child;
        parent.doIt(); // Do it in Child
        System.out.println(parent.name);
    }
}
