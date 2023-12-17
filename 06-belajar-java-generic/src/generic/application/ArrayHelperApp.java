package generic.application;

import generic.util.ArrayHelper;

public class ArrayHelperApp {
    public static void main(String[] args) {
        String[] cities = {
                "Bandung", "Jakarta", "Bekasi", "Bogor"
        };

        Integer[] numbers = {
                1, 2, 3, 4, 5, 6, 7, 8
        };

        System.out.println(ArrayHelper.<String>count(cities));
        System.out.println(ArrayHelper.count(numbers));
    }
}
