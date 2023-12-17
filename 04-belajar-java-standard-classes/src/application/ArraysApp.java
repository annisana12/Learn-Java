package application;

import java.util.Arrays;

public class ArraysApp {
    public static void main(String[] args) {
        int[] numbers = {
                3,2,492,121,240,13,3,5,2,9,10,23,3,4,6,7
        };

        Arrays.sort(numbers);

        System.out.println(Arrays.toString(numbers));

        System.out.println(Arrays.binarySearch(numbers, 2)); // return index
        System.out.println(Arrays.binarySearch(numbers, 3));
        System.out.println(Arrays.binarySearch(numbers, 100));

        int[] result1 = Arrays.copyOf(numbers, 5);
        System.out.println(Arrays.toString(result1));

        int[] result2 = Arrays.copyOfRange(numbers, 5, 10);
        System.out.println(Arrays.toString(result2));

        int[] result3 = Arrays.copyOf(numbers, numbers.length);
        System.out.println(Arrays.equals(numbers, result3));
    }
}
