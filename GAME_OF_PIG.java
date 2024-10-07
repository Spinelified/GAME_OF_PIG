/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package io.github.spinelified;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author parat
 */
public class GAME_OF_PIG 
{
    public static void main(String[] args) 
    {   
        //Make a new window.
        JFrame window = new JFrame("Game of Pig");

        //Declare Button objects.
        JButton playButton, rulesButton, exitButton;

        //Instantiate Button objects.
        playButton = new JButton("Play");
        rulesButton = new JButton("How to Play"); 
        exitButton = new JButton("Exit");


        //x, y, width, height, set these parts of the buttons
        playButton.setBounds(480, 240, 360, 80);
        rulesButton.setBounds(480, 360, 360, 80);
        exitButton.setBounds(480, 480, 360, 80);

        //Add the buttons to the window
        window.add(playButton);
        window.add(rulesButton);
        window.add(exitButton);

        //size of the window
        window.setSize(1280, 720);

        //give programmer complete control over where button is
        window.setLayout(null);

        //make the window visible
        window.setVisible(true);

        //The banks of each player.
        int bank1, bank2;

        //Whether Player 2 is a real person or a computer.
        boolean secondIsComputer;

        //Declare the Player Objects.
        Player player1; 
        SecondPlayer player2;

        //Current turn number.
        int turn = 0;

        //So that the Scanner object automatically
        //close after the blcok is finished runnning.
        try(Scanner input = new Scanner(System.in))
        {
            //Get whether or not Player 2 is a computer.
            secondIsComputer = isComputer(input);
        
            //Instatiate Player objects.
            player1 = new Player(1, secondIsComputer);
            player2 = new SecondPlayer(secondIsComputer);
        
            //Get Player 1's bank, to prepare for startTurn().
            bank1 = player1.getBank();

            //Keep playing through the game until either player has a bank 
            //greater than or equal to 100.
            while (true)
            {
                //Start and format the turn.
                turn = startTurn(turn, bank1, player2);

                //Complete Player 1's turn, store their final score, and
                //break out of loop if bank1 is greater than or equal to 100.
                player1.completeTurn(input);
                bank1 = player1.getBank();

                if (bank1 >= 100)
                    break;

                //Complete Player 2's turn, store their final score, and
                //break out of loop if bank1 is greater than or equal to 100.
                else
                {
                    if (secondIsComputer)
                        player2.computerTurn();
                    else
                        player2.completeTurn(input);
                
                    bank2 = player2.getBank();

                    if (bank2 >= 100)
                        break;
                }
            }

            //Display results
            displayResults(turn, player1, player2);
        }
    }


    //Greet the user.
    public static void greeting()
    {
        System.out.println("WELCOME TO THE GAME OF PIG!");
        System.out.println();
    }

    //METHOD FINISHED
    //Display turn number.  Output each PLayer's bank(dependent on whether 
    //or not Player 2 is a computer)  
    //Returns turn + 1 to update turn variable in main.
    public static int startTurn(int turn, int bank1, Player player2)
    {
        //Increment the turn.
        int turnNumber = turn + 1;

        //Get Player 2's bank.
        int bank2 = player2.getBank();

        System.out.println("Turn: " + turnNumber);

        if (player2.isComputer())
        {
            System.out.println("You're Current Score is: " + bank1);
            System.out.println("The Computer's Current Score is " + 
                bank2);
        }

        else
        {
            System.out.println("Player 1's Current Score is: " +
                bank1);
            System.out.println("Player 2's Current Score is: " + 
                bank2);
        }

        System.out.println();
        System.out.println();
        return turnNumber;
    }

    //METHOD FINISHED
    //Returns whether or not Player 2 is a real person or a computer.
    public static boolean isComputer(Scanner input)
    {
        //The choice that the user enters.
        //'C' means Player 2 is a computer.
        //'V' means Player 2 is a real person.
        char choice;

        System.out.println("Would you like to play against a computer " + 
            "or another person?");
        
        while (true) 
        { 
            System.out.print("Press \"V\" to play against another person " +
                "locally, or \"C\" to play against the computer: "); 

            choice = input.nextLine().toUpperCase().charAt(0);

            //Try to assign twoIsComputer based on value of choice. If there
            //is an error, throw ValidationException.  Done with rule switch.
            try
            {
                return switch (choice)
                {
                    case 'V' -> false;
                
                    case 'C' -> true;

                    default -> throw new ValidationException();
                };
            }

            //If input is not valid, tell user, then go back to beginbning of loop.
            catch(ValidationException e)
            {
                System.out.println("You did not enter a valid character.  " + 
                    "Please try again.");
            }
        }
    }

    //METHOD FINISHED
    //Display the results of the game.
    public static void displayResults(int turn, Player player1,
        Player player2)
    {
        //Get the banks of each Player.
        final int bank1 = player1.getBank();
        final int bank2 = player2.getBank();

        //Text to display if Player 2 is a computer.
        if (player2.isComputer())
        {
            if (bank1 > bank2)
                System.out.print("Congratulations!  You ");
            
            else
                System.out.print("Good try!  The Computer ");
        }

        //Text to display otherwise.
        else 
        {
            System.out.print("Congratulations Player ");
            if (bank1 > bank2)
                System.out.print(1);
            
            else
                System.out.print(2);
            
            System.out.print("!  You ");
        }

        System.out.println("won on turn " + turn + "!");
    }
}