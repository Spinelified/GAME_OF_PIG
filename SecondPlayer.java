package io.github.spinelified;

public class SecondPlayer extends Player
{
    //METHOD FINISHED
    //ComputerPlayers are always Player 2.
    public SecondPlayer(boolean isComputer)
    {
        super(2, isComputer);
    }

    //Methods below are used if the SecondPlayer is a computer.

    //METHOD FINISHED
    //Used to determine whether the computer will roll or bank.
    protected boolean rollOrBank(int score)
    {
        //The computer only banks if it's score is greater than
        //15 or if the sum of it's current score and it's bank
        //is greater than or equal to 100.

        //Whether the Computer wants to roll or bank.
        boolean doRoll;

        if ((score > 15) || (score + bank >= 100))
        {
            System.out.println("The computer chooses to bank.");
            System.out.println();

            doRoll = false;
        }

        else
        {
            System.out.println("The computer chooses to roll.");

            doRoll = true;
        }

        return doRoll;
    }

    //Complete one Computer turn.
    public void computerTurn()
    {
        //Number rolled during current round.
        int roll;

        //Whether or not to roll again.
        boolean doRoll;

        //Total score accumulated this turn.
        int score = 0;

        //Make a new Dice object.
        final Dice dice = new Dice();

        //Formatting.
        System.out.println("The Computer's Turn");

        //Repeat until the computer rolls a 1 or choose to bank.
        while (true)
        {
            //Formatting
            System.out.println("This round the Computer " +
                "has: " + score);
            
            doRoll = rollOrBank(score);

            //Break out if the copmuter chooses to bank.
            if (!doRoll)
            {
                bank += score;

                break;
            }

            //Roll dice.
            else
            {
                roll = dice.rollDice();

                System.out.println("The Computer rolled a " + 
                    roll + "!");
                
                //Break out if 1 is rolled.
                if (roll == 1)
                {
                    System.out.println("The Computer gets " + 
                        "a zero for this round!");
                    
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
        }
    }
}