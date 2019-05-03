package my.daysleeper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HangmanApplication {

    private static final String[] WORDS = {"HELLO", "APPLAUSE", "BEAUTIFUL"};

    public static void main(String[] args) {

        List<Integer> points = Arrays.stream(WORDS).map(word -> {
            System.out.println("NEW GAME");
            return new HangMan(word, 3).play();
        }).collect(Collectors.toList());

        System.out.println("\n\nResults of all " + WORDS.length + " plays:");
        points.forEach(point -> {
            System.out.println(point + " points");
        });
        System.out.println("\nYou gathered from all games: " + points.stream().reduce((p1,p2) -> p1 + p2).get() + " points");
    }
}
