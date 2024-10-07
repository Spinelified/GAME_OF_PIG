package io.github.spinelified;

import java.util.Scanner;

public class Player
{
    //The amount of points the Player has accumulated.
    protected int bank;

    protected int playerNumber;

    protected boolean twoIsComputer;

    //METHOD FINISHED
    //Make a new player with a roll and bank of 0.
    public Player(int playerNumber, boolean twoIsComputer)
    {
        bank = 0;

        this.playerNumber = playerNumber;

        this.twoIsComputer = twoIsComputer;
    }

    //METHOD FINISHED
    //Used to get the Player's bank.
    public int getBank()
    {
        return bank;
    }

    //METHOD FINISHED
    //Returns whether or not the player is a computer.
    public boolean isComputer()
    {
        return twoIsComputer;
    }

    //METHOD FINISHED
    //Used to determine whether the Player will roll or bank.
    private boolean rollOrBank(int round, Scanner input)
    {
        //Whether user wants to roll or bank.
        String choice;

        //Repeat until user enters a valid input.
        while (true) 
        {         
            System.out.print("Would you like to roll or bank? ");

            choice = input.nextLine().toLowerCase();

            //The Player wants to roll again.
            if (choice.equals("roll"))
            {
                return true;
            }

            //The Player tries to bank at the start of their turn.
            else if (choice.equals("bank") && (round == 1))
                System.out.println("You cannot bank on the first " + 
                    "round of your turn.");
            
            //The Player wants to bank.
            else if (choice.equals("bank"))
            {
                return false;
            }
                
            //The Player enters something else other than "roll"
            // or "bank".
            else 
                System.out.println("Invalid input.  Please try again.");
        }
    }

    //METHOD FINISHED
    //Complete one turn.
    public void completeTurn(Scanner input)
    {
        //Holds the number rolled from the Dice.
        int roll;

        //Records what round of the turn it is.
        int round = 1;

        //The number of points accumulated this turn.
        int score = 0;

        //Whether or not Dice should be rolled again.
        boolean doRoll;

        //Make a new Dice object.
        final Dice dice = new Dice();

        //Format the turn.
        if (twoIsComputer)
            System.out.print("Your ");

        else if (playerNumber == 1)
            System.out.println("Player 1's ");
        
        else
            System.out.print("Player 2's ");
        
        System.out.println("Turn");

        //Repeat until Player chooses to bank, or they roll a 1.
        while (true)
        {
            System.out.println("This round you have: " + score);

            //Ask the player if they would like to roll or bank.
            doRoll = rollOrBank(round, input);

            //If the Player decides to bank.
            if (!doRoll)
            {
                System.out.println();

                bank += score;

                break;
            }

            //If the Player decides to roll.
            else
            {
                roll = dice.rollDice();

                System.out.println("You rolled a " + roll + "!");

                //End turn if roll is 1.
                if (roll == 1)
                {
                    System.out.println("You get a zero for this round!");

                    System.out.println();
                    System.out.println();

                    break;
                }

                else
                {
                    //Add roll to tallied score for this turn
                    score += roll;

                    System.out.println();
                }
            }

            //Increment round.
            round++;
        }
    }
}

