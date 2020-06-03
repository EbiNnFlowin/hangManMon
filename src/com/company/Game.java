package com.company;

public class Game {
    private String answer;
    private String hits;
    private String misses;

    public Game(String answer) {
        this.answer = answer;
        hits = "";
        misses = "";

    }

    private char normalizeGuess(char letter){
        if (!Character.isLetter(letter)){
            throw new IllegalArgumentException("A letter is required");
        }
        letter = Character.toLowerCase(letter);
        return letter;
    }

    public boolean applyGuess(char letter){
        letter = normalizeGuess(letter);
        boolean isHit = answer.indexOf(letter) != -1;
        if (isHit){
            hits += letter;
        }else {
            misses += letter;
        }
        return isHit;
    }

    public String getCurrentProgress(){
        String progress = "";
        for (char letter : answer.toCharArray()){
            char display = '-';
            if (hits.indexOf(letter) != -1){
                display = letter;
            }
            progress += display;
        }
        return progress;
    }
}
