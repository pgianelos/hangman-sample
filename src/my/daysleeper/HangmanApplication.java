package my.daysleeper;

import java.security.SecureRandom;

public class HangmanApplication {

    private static final String[] WORDS = {"HELLO", "APPLAUSE", "BEAUTIFUL", "MAVERICK"};
    private static final int NUMBER_OF_TRIES = 5;

    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {

        System.out.println("Welcome to HangMan!");

        String word = WORDS[random.nextInt(WORDS.length -1)];
        int points = new HangMan(word, NUMBER_OF_TRIES).play();

        System.out.println("\nYour final score is " + points + " points");


//        List<Integer> points = Arrays.stream(WORDS).map(word -> {
//            System.out.println("NEW GAME");
//            return new HangMan(word, 3).play();
//        }).collect(Collectors.toList());
//
//        System.out.println("\n\nResults of all " + WORDS.length + " plays:");
//        points.forEach(point -> {
//            System.out.println(point + " points");
//        });
//        System.out.println("\nYou gathered from all games: " + points.stream().reduce((p1,p2) -> p1 + p2).get() + " points");
    }
}
