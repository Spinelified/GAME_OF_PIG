/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package io.github.spinelified;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author parat
 */
public class GAME_OF_PIG 
{
    public static void main(String[] args) 
    {
        ArrayList<Player> listOfPlayers;
        Scanner input = new Scanner(System.in);

        greeting();

        createPlayers(input);

        input.close();
    }

    //Greet the user.
    public static void greeting()
    {
        System.out.println("WELCOME TO THE GAME OF PIG!");
        System.out.println();
    }

    public static ArrayList<Player> createPlayers(
        Scanner input)
    {
        //In Java 7 and after, we can use a diamond
        //operator when instantiating an ArrayList.
        //This makes code easier to read.
        ArrayList<Player> list = new ArrayList<>();
        String name;
        int counter = 1;
        boolean exit = false;

        //Repeat forever
        while (true)
        {
            //Printf is used for formatting.
            //
            System.out.printf("Please enter "  + 
                "Player %d's name: ", counter);
            
            name = input.nextLine();

            switch (name.toLowerCase())
            {
                case "computer" -> 
                {
                    int difficulty;
                    System.out.println("What will the difficulty " + 
                        "for this computer be?");
                    
                    while (true)
                    {
                        System.out.print("Please enter an integer" + 
                            "from 0 to 4: ");
                    
                        try
                        {
                            difficulty = input.nextInt();
                            break;
                        }

                        catch (Exception e)
                        {
                            System.out.println("An integer must " + 
                                "be entered.");
                        }
                    }
                    list.add(new ComputerPlayer(difficulty));
                }

                case "exit" -> exit = true;
                
                default -> list.add(new Player(name));
            }

            System.out.println("\n");

            if (exit)
                break;
        }

        return list;
    }
}