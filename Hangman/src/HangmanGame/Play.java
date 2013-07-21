package HangmanGame;

import java.util.HashSet;
import java.util.Random;

public class Play {

    HashSet wrongSet;
    HashSet rightSet;
    String guess;
    String hint;
    String displayString;

    int maxguesses = 8;
    int stateOfMan;
    char userinput;
    boolean canPlay;
    boolean win;

    public Play()
    {
        String words[] = new String[6];
        String hints[] = new String[6];
        words[0] = "Pen";
        hints[0] = "writing implement";
        words[1] = "Ruler";
        hints[1] = "Straight line making device";
        words[2] = "Dali";
        hints[2] = "Spanish surrealist, had a pet anteater";
        words[3] = "Manet";
        hints[3] = "Boring French realist, mainly worked on bourgeois portraits";
        words[4] = "Monet";
        hints[4] = "Artist famous for painting a bridge in Giverny";
        words[5] = "Phenylalanine";
        hints[5] = "Aromatic amino acid";

        Random rand = new Random();
        int number = rand.nextInt(words.length);
        guess = (String) words[number];
        hint = (String) hints[number];

        wrongSet = new HashSet();
        rightSet = new HashSet();

        displayString = "";

        int i = 0;

        while(i < guess.length())
        {
            displayString += "-";
            i++;
        }

        canPlay = true;
        win = false;
    }


    public void TakeTurn()
    {
        //store the guess
        //search string for guess
        //is the guess right? If yes, put in rightSet, if no, put in wrongSet

        for(int i = 0; i < guess.length(); i++)
        {
            if(guess.charAt(i) == userinput)
            {
                rightSet.add(userinput);
            }
        }

        // here, the userinput is not in the word
        if (!(rightSet.contains(userinput)))
        {
            if(!(wrongSet.contains(userinput)))
            {
                wrongSet.add(userinput);

                //draw a man
                stateOfMan++;
            }
        }

        String newString = "";

        for (int j = 0; j < guess.length(); j++)
        {
            if (guess.charAt(j) == userinput)
            {
                newString = displayString.substring(0, j) + userinput + displayString.substring(j + 1);
                displayString = newString;
            }
        }

        if (wrongSet.size() == maxguesses)
        {
            canPlay = false;
        }

        for (int i = 0; i < guess.length(); i++)
        {
            if (rightSet.contains(guess.charAt(i)))
            {
                win = true;

            } else {
                win = false;
                break;
            }
        }
    }
}
