package HangmanGame;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.awt.*;

// userinput gives characters to the model, Play
// Play gives the control the state of the man which Control draws
// Control gives info to the view, HangmanSwing
public class Control {

    Play model;
    View view;

    //public constructor
    //constructor is the method which is called when making a new instance of this object
    public Control(Play model, View view)
    {
        this.model = model;
        this.view = view;
        this.view.AddListener(this);
    }

    public void start()
    {
        view.createAndShowGUI();
    }

    public void makeGuess()
    {
        model.TakeTurn();
        view.Man();
    }

    public boolean getWin()
    {
        return model.win;
    }

    //gives the Play the input
    public void acceptInput(char input)
    {
        model.userinput = input;
    }

    public char getInput()
    {
        return model.userinput;
    }

    // takes the state of the man from play and tells swing what to do with it
    public void acceptOutput()
    {
        view.man = model.stateOfMan;

    }

    public int getManState()
    {
        return model.stateOfMan;
    }

    public void isgameover(GridBagConstraints c)
    {
        if (!(model.canPlay))
        {
            view.lose();
        }

        if (model.win)
        {
            view.win();
        }
    }

    public String getGuess()
    {
        return model.guess;
    }

    public String getHint()
    {
        return model.hint;
    }

    public String getDisplayString()
    {
        return model.displayString;
    }

}

