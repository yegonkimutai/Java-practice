package com.kenzie.app;

import java.util.Optional;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        int score = 0;
        int totalClues = 10;

        for (int i = 0; i < totalClues; i++) {
          try {
            Optional<Clue> clueOptional = CustomHttpClient.fetchRandomClue();

            if (clueOptional.isPresent()) {
                Clue clue = clueOptional.get();
                System.out.println("Clue: " + clue.getQuestion());

                // Read the user's answer
                Scanner scanner = new Scanner(System.in);
                String userAnswer = scanner.nextLine();

                // Check if the user's answer is correct
                if (userAnswer.equalsIgnoreCase(clue.getAnswer())) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect. The correct answer is: " + clue.getAnswer());
                }

                System.out.println("Your score: " + score);
            }
          } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while fetching a clue.");
        }   
        }

        System.out.println("Game over. Your final score: " + score);
    }
}
