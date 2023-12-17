package lambda.app;

import lambda.SimpleAction;

public class SimpleActionApp {
    public static void main(String[] args) {
        SimpleAction simpleAction1 = new SimpleAction() {
            @Override
            public String action(String name) {
                return "Hello " + name;
            }
        };

        System.out.println(simpleAction1.action("Budi"));

        SimpleAction simpleAction2 = (String name) -> {
            return "Hello " + name;
        };

        System.out.println(simpleAction2.action("Budi"));

        SimpleAction simpleAction3 = (name) -> {
            return "Hello " + name;
        };

        System.out.println(simpleAction3.action("Budi"));

        SimpleAction simpleAction4 = (String name) -> "Hello " + name;
        SimpleAction simpleAction5 = (name) -> "Hello " + name;
        SimpleAction simpleAction6 = name -> "Hello " + name;

        System.out.println(simpleAction4.action("Joko"));
        System.out.println(simpleAction5.action("Joko"));
        System.out.println(simpleAction6.action("Joko"));
    }
}
