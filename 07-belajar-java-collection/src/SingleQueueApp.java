import Collections.SingleQueue;

import java.util.Queue;

public class SingleQueueApp {
    public static void main(String[] args) {
        Queue<String> queue = new SingleQueue<String>();

        System.out.println(queue.size());

        System.out.println(queue.offer("Apple"));
        System.out.println(queue.offer("Orange"));
        System.out.println(queue.offer("Mango"));

        System.out.println(queue.size());

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println(queue.size());
    }
}
