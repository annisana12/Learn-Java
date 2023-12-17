import java.util.ArrayDeque;
import java.util.Deque;

public class DequeueApp {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();

        stack.offerLast("Apple");
        stack.offerLast("Orange");
        stack.offerLast("Grape");

        System.out.println(stack);
        System.out.println("pollLast : ");
        System.out.println(stack.pollLast());
        System.out.println(stack.pollLast());
        System.out.println(stack.pollLast());

        Deque<String> deque = new ArrayDeque<>();

        deque.offerLast("Apple");
        deque.offerLast("Orange");
        deque.offerLast("Grape");

        System.out.println(deque);
        System.out.println("pollFirst : ");
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
    }
}
