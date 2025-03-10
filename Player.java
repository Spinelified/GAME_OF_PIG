package io.github.spinelified;

import java.util.ArrayList;

public class Player
{
    //The player's name.
    private String name;

    //The amount of points that have 
    //been accumulated in one turn.
    private int turnPoints;

    //The amount of points the Player has accumulated.
    private int bank;

    //Whether or not the player is ready.
    private boolean ready;

    //The dice object should be shared by all players.
    private static Dice dice = null;

    //Whether or not the game has actually started.
    private static boolean started = false;

    //The list of all of the player's that exist.
    final private static ArrayList<Player> playerList = 
        new ArrayList<>();

    //CONSTRUCTOR FINISHED
    /*
     *Make a new player with a roll and bank of 0.
     *The Player is not ready after being created.
     */
    public Player(String name)
    {
        this.bank = 0;
        this.turnPoints = 0;
        this.name = name;
        this.ready = false;
    }

    //METHOD FINISHED
    /*
     *name accessor
     */
    public String getName()
    {
        return name;
    }

    //METHOD FINISHED
    /*
     *name mutator 
     */
    public void setName(String name)
    {
        //Names shouldn't be changed while the Player
        //is already in a game
        if (ready)
            System.out.println("Name can not be changed " + 
                "while in play.");
        
        //Change the Player's name.
        else
            this.name = name;
    }

    //METHOD FINISHED
    /*
     *turnPoints accessor 
     */
    public int getTurnPoints()
    {
        return turnPoints;
    }

    //METHOD FINISHED
    /*
     *bank accessor
     */
    public int getBank()
    {
        return bank;
    }

    //METHOD FINISHED
    /*
     *Adds turnPoints to bank.
     *Then resets turnPoints.
     */
    protected void bank()
    {
        //We should not be changing the bank
        //if the Player is not in play.
        if (started)
        {
            this.bank += turnPoints;
            this.turnPoints = 0;
        }
    }

    //METHOD FINISHED
    /*
     *Readies the Player
     */
    public void isReady()
    {
        this.ready = true;

        //Add the Player to the player list
        //if they haven't been already
        if (playerList.indexOf(this) == -1)
            playerList.add(this);

        System.out.printf("%s is " + 
            "ready to start!%n", name);
    }

    //METHOD FINISHED
    /*
     *Sets the dice if a game is not already
     *in play, and the dice is not null.
     */
    public static void setDice(Dice d)
    {
        if (started)
            System.out.println("Cannot set dice " +
                "as the game has already started.");
        
        else if (dice == null)
            System.out.println("Cannot set dice to null.");
        
        else
            dice = d;
    }

    //METHOD FINISHED
    /*
     *Checks if all Players are ready, and
     *if a dice has been created.
     *Outputs what still needs to be done.
     *Sets start to true if everything is good.
    */
    public static boolean readyToStart()
    {
        boolean playersReady = true;
        boolean diceInit = true;

        for (Player p : playerList)
            if (!p.ready)
            {
                System.out.printf("%s still needs" +
                    "to get ready!%n", p.name);
                playersReady = false;
            }
        
        System.out.println();

        if (dice == null)
        {
            System.out.println("A dice still needs to be created!");
            
            diceInit = false;
        }

        System.out.println();

        started = playersReady && diceInit;

        return started;
    }

    //METHOD FINISHED
    /* 
     *Rolls the dice, adds it to turnPoints
     *Returns the number rolled.
     */
    public int roll()
    {

        int roll = dice.roll();
        this.turnPoints += roll;

        return roll;
    }

    //METHOD FINISHED
    /*
     *playerList accessor 
     */
    public static ArrayList<Player> getPlayerList()
    {
        return playerList;
    }
}

