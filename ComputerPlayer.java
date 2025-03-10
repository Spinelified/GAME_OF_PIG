package io.github.spinelified;

import java.util.ArrayList;

public class ComputerPlayer extends Player
{
    //What strategy the Computer Player is using.
    private enum Difficulty
    {
        RANDOM,
        HOLDAT20,
        HOLDAT25,
        FOURSCORINGTURNS,
        KEEPPACE;

        public void getInfo()
        {
            switch(this)
            {
                case RANDOM ->
                {
                    System.out.println("Random:");
                    System.out.println("The computer will " + 
                        "randomly choose");
                    System.out.println("between rolling " + 
                        "again and "); 
                    System.out.println("banking turned points");
                }

                case HOLDAT20 ->
                {
                    System.out.println("Hold at 20:");
                    System.out.println("The computer will " + 
                        "choose to bank");
                    System.out.println("once the amount of " + 
                        "points accumulated "); 
                    System.out.println("is greater than or " + 
                        "equal to 20.");
                }

                case HOLDAT25 ->
                {
                    System.out.println("Hold at 25:");
                    System.out.println("The computer will " + 
                        "choose to bank ");
                    System.out.println("once the amount of " + 
                        "points accumulated "); 
                    System.out.println("is greater than or " + 
                        "equal to 25.");
                }

                case FOURSCORINGTURNS ->
                {
                    System.out.println("Four Scoring Turns:");
                    System.out.println("The computer will " + 
                        "choose to bank");
                    System.out.println("once the amount of " + 
                        "points accumulated "); 
                    System.out.println("is greater than or equal" + 
                        "to 25 on turn 1.");
                }

                case KEEPPACE ->
                {
                    System.out.println("Hold at 20:");
                    System.out.println("The computer will " + 
                        "choose to bank");
                    System.out.println("once the amount of " + 
                        "points accumulated "); 
                    System.out.println("is greater than or " + 
                        "equal to 20.");
                }
            }
        }

        @Override
        public String toString()
        {
            return "Difficulty " + this.ordinal() + 
                " - " + switch(this)
            {
                case RANDOM -> "Random";

                case HOLDAT20 -> "Hold at 20";

                case HOLDAT25 -> "Hold at 25";

                case FOURSCORINGTURNS -> "4 Scoring Turns";

                case KEEPPACE -> "Keep Pace";
            };
        }
    }

    //Used to determine what to do when
    //it is this Player's turn.
    private Difficulty difficulty;

    //List of all the Computer Player objects that exist
    final private static ArrayList<ComputerPlayer> 
        computerList = new ArrayList<>();

    //CONSTRUCTOR FINISHED
    //Takes in integer parameter difficulty
    public ComputerPlayer(int difficulty)
    {
        super("CPU " + (computerList.size() + 1));

        this.difficulty = switch (difficulty)
        {
            case 0 -> Difficulty.RANDOM;

            case 1 -> Difficulty.HOLDAT20;

            case 2 -> Difficulty.HOLDAT25;

            case 3 -> Difficulty.FOURSCORINGTURNS;

            case 4 -> Difficulty.KEEPPACE;

            default -> 
            {
                System.out.println("No such difficculty exists.");
                System.out.println("Difficulty being set to 0...");
                yield Difficulty.RANDOM;
            }
        };
    }

    //METHOD FINISHED
    /*
     *Computer Player's shouldn't be 
     *able to change their name.
     */
    @Override
    public void setName(String name)
    {
        //We don't want to allow Computer Players'
        //names to be changed
        System.out.println("Computer Player " + 
            "name cannot be set.");
    }

    public String getDifficulty()
    {
        return difficulty.toString();
    }

    //METHOD FINISHED
    /*
     *Readies the Computer
     */
    @Override
    public void isReady()
    {
        if (computerList.indexOf(this) == -1)
            computerList.add(this);

        super.isReady();
    }
}