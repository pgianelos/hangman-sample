package my.daysleeper;

import java.util.Arrays;

public class Word {

    private static final String LETTER_HIDING_CHARACTER = "_";

    private final String wordToGuess;
    private String[] wordGuessed;

    public Word(String givenWord) {
        wordToGuess = givenWord;

        wordGuessed = new String[givenWord.length()];
        Arrays.fill(wordGuessed, LETTER_HIDING_CHARACTER);
    }

    int letterOccurrences(String letter) {

        int occurrences = 0;
        if (wordToGuess.contains(letter)) {

            int index = wordToGuess.indexOf(letter);
            while(index >= 0) {
                occurrences++;
                wordGuessed[index] = letter;
                index = wordToGuess.indexOf(letter, index + 1);
            }
        }
        return occurrences;
    }

    public boolean wordFound() {
        return !Arrays.toString(wordGuessed).contains(LETTER_HIDING_CHARACTER);
    }

    public String getWordSoFar() {
        return String.join(" ", wordGuessed);
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

}
