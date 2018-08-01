package com.roshambo;

import java.util.Scanner;

public class RoshamboApp {

	public static void main(String[] args) {
		// Declare/initialize variables
		Scanner scan = new Scanner(System.in);
		Player human = new User();
		Player computer = null;
		Player computer2 = null;
		String userName;
		String userOpp;
		String userInput;
		Roshambo value = null;
		Roshambo userValue = null;
		String cont = "y";
		int userWins = 0;
		int compWins = 0;
		
		System.out.println("Welcome to Roshambo!");
		System.out.println();
		// Prompt user to enter name. Validate input.
		userName = Validator.getString(scan, "Please enter your name: ");
		human.setName(userName);

		// Prompt user to select an opponent. Validate input.

		while (cont.equalsIgnoreCase("y")) {

			userOpp = Validator.getString(scan, "Would you like to play against Beethoven or Mozart? (b/m)");

			// Prompt user to select Rock, Paper, or Scissors. Validate input.
			userInput = Validator.getString(scan, "Rock, Paper, or Scissors? (R/P/S)");

			// Display opponent's choice.
			if (userOpp.equalsIgnoreCase("b")) {
				computer = new Dummy();
				computer.setName("Beethoven");
				value = computer.generateRoshambo();
				System.out.println("Beethoven: " + value);
			} else if (userOpp.equalsIgnoreCase("m")) {
				computer2 = new RandomUser();
				computer2.setName("Mozart");
				value = computer2.generateRoshambo();
				System.out.println("Mozart: " + value);
			}
			// Display user's choice.
			userValue = human.generateRoshambo(userInput);
			System.out.println(userName + ": " + userValue);

			System.out.println();
			// Display results of match. Write a separate method.
			if (displayResults(computer, human, userValue, value) == 0) {
				System.out.println("Draw!");
			} else if (displayResults(computer, human, userValue, value) == -1) {
				compWins++;
				System.out.println(computer.getName() + " wins!");
			} else {
				userWins++;
				System.out.println(human.getName() + " wins!");
			}

			System.out.println(displayResults(computer, human, userValue, value));
			System.out.println();
			// Prompt user to continue. Validate
			System.out.println("Play again? (y/n)");
			cont = scan.nextLine();
		}
		System.out.println(human.getName() + " won " + userWins + " games.");
		System.out.println(human.getName() + " lost " + compWins + " games.");
		System.out.println();
		System.out.println("Thanks for playing! Goodbye!");

		scan.close();
	}

	public static int displayResults(Player computer, Player human, Roshambo userValue, Roshambo value) {
		if (userValue == value) {
			return 0;
		} else if (userValue == Roshambo.ROCK && value == Roshambo.PAPER
				|| userValue == Roshambo.PAPER && value == Roshambo.SCISSORS
				|| userValue == Roshambo.SCISSORS && value == Roshambo.ROCK) {
			return -1;
		} else {
			return 1;
		}
	}
}
