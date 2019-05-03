package my.daysleeper;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class HangMan {

    private final Word word;
    private final int availableTries;

    private final PointSystem pointSystem;

    private Set<String> lettersUsed;

    public HangMan(String wordToGuess, int tries) {
        this.word = new Word(wordToGuess);
        availableTries = tries;
        pointSystem = new PointSystem();

        lettersUsed = new LinkedHashSet<>();
    }

    public int play() {

        Scanner scanner = new Scanner(System.in);

        int triesLeft = availableTries;
        boolean inLetterSpree = false;

        do {
            printHangManContent(triesLeft);

            String letter = scanner.nextLine();
            if (lettersUsed.contains(letter)) {
                System.out.println("You have already entered this letter");
                continue;
            }

            lettersUsed.add(letter);

            int letterOccurrences = word.letterOccurrences(letter.toUpperCase());

            if (letterOccurrences > 0) {
                System.out.println("Good guess! letter '" + letter + "' is found " + letterOccurrences + " time(s) in the word\n");
                pointSystem.addPointsForLetterFound(letterOccurrences);
                if (inLetterSpree) {
                    pointSystem.addPointsForLetterSpree();
                }
                inLetterSpree = true;
            } else {
                System.out.println("Bad luck, the word does not contain the letter '" + letter + "'\n");
                triesLeft--;
                inLetterSpree = false;
            }

        } while (!word.wordFound() && triesLeft > 0);

        showOutcome(triesLeft);

        int totalPoints = pointSystem.getTotalPoints();
        System.out.println("You gathered " + totalPoints + " points");
        return totalPoints;
    }

    private void printHangManContent(int triesLeft) {
        System.out.println(word.getWordSoFar());

        if (lettersUsed.size() > 0) {
            System.out.println("\n(letters used: " + String.join(",", lettersUsed).toUpperCase() + ")\n");
        }

        System.out.println("\n" + triesLeft + "/" + availableTries + " tries left\nEnter a letter: ");
    }

    private void showOutcome(int triesLeft) {
        if (triesLeft > 0) {
            pointSystem.addPointsForTriesLeft(triesLeft);
            System.out.println("CONGRATULATIONS :D you found the word: " + word.getWordToGuess());
        } else {
            System.out.println("Sorry... you lost :(");
        }
    }
}
