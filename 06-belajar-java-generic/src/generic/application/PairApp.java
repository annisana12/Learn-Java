package generic.application;

import generic.Pair;

public class PairApp {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Budi", 100);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
}
