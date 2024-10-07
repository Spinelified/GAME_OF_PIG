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

    //Makes a basic 6 sided die.
    public Dice()
    {
        numSides = 6;
        increment = 1;
    } 

    //Dice with different number of sides.
    public Dice(int numSides)
    {
        this.numSides = numSides;
        increment = 1;
    }

    //Dice with different number of sides and
    //different increment number.
    public Dice(int numSides, int increment)
    {
        this.numSides = numSides;
        this.increment = increment;
    }

    //Roll the dice object.
    public int rollDice()
    {
        //Make a variable to store the rolled number in.
        int num;

        //Get a random number between 1 and numSides inclusive.
        num = (int) (Math.random() * numSides + 1);

        //Make the difference between two adjacent numbers increment.
        num *= increment;

        return num;
    }
}
