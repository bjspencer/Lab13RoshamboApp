package com.roshambo;

import java.util.Scanner;

public class RoshamboApp {

	public static void main(String[] args) {
		// Declare/initialize variables
		Scanner scan = new Scanner(System.in);
		Player human = new User();
		Player computer = null;
		String userName;
		String userOpp;
		String userInput;
		Roshambo value = null;
		Roshambo userValue = null;
		String cont = "y";

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
				computer = new RandomUser();
				computer.setName("Mozart");
				value = computer.generateRoshambo();
				System.out.println("Mozart: " + value);
			}
			// Display user's choice.
			userValue = human.generateRoshambo(userInput);
			System.out.println(userName + ": " + userValue);

			// Display results of match. Write a separate method.
			System.out.println();
			System.out.println(displayResults(computer, human, userValue, value));
			System.out.println();
			// Prompt user to continue. Validate
			System.out.println("Play again? (y/n)");
			cont = scan.nextLine();
		}

		System.out.println("Thanks for playing! Goodbye!");

		scan.close();
	}

	public static String displayResults(Player computer, Player human, Roshambo userValue, Roshambo value) {
		if (userValue == value) {
			return "Draw!";
		} else if (userValue == Roshambo.ROCK && value == Roshambo.PAPER
				|| userValue == Roshambo.PAPER && value == Roshambo.SCISSORS
				|| userValue == Roshambo.SCISSORS && value == Roshambo.ROCK) {

			return computer.getName() + " wins!";
		} else {
			return human.getName() + " wins!";
		}
	}

}
