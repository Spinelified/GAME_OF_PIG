package io.github.spinelified;

//The dice object that will be used during the game.
//CLASS FINISHED
public class Dice
{
    //The number of sides the dice has.
    final private int numSides;

    //Represents the difference between
    //each value on every side.
    final private int increment;

    //What the first number on the dice is.
    final private int start;


    //Constructor to set each instance variable.
    public Dice(int numSides, int increment, int start)
    {
        this.numSides = numSides;
        this.increment = increment;
        this.start = start;
    }

    //Constructor to set numSides and increment.
    //start is set to 1.
    public Dice(int numSides, int increment)
    {
        this(numSides, increment, 1);
    }

    //Constructor to set numSides
    //numSides and increment are set to 1.
    public Dice(int numSides)
    {
        this(numSides, 1);
    }

    //Makes a basic 6 sided dice.
    public Dice()
    {
        this(6);
    } 

    //Roll the dice object.
    public int roll()
    {
        //Make a variable to store the rolled number in.
        int num;

        //Get a random number between 1 and numSides inclusive.
        num = (int) (Math.random() * numSides);

        //Make the difference between two adjacent numbers increment.
        num *= increment;

        //Make the number start at start.
        num += start;

        return num;
    }
}
