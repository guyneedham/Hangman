package HangmanGame;// This file is where the game starts.
// The game will allow a user to play a game of hangman against the computer. The computer will provide a word and a clue.

public class HangmanSwing {

    public static void main(String[] args) {

        final View view = new View();
        Play model = new Play();
        final Control control = new Control(model, view);

        //create and show the GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                control.start();
            }
        });
    }
}