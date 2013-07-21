package HangmanGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class View extends JFrame implements ActionListener {

    GridBagLayout gridbag;
    GridBagConstraints c;

    String prompt;
    JTextArea dashes;

    Control control;
    int man;
    JTextField inputBox;
    JPanel panel;
    JPanel picPanel;
    JFrame frame;

    //create the GUI
    protected void createAndShowGUI() {
        gridbag = new GridBagLayout();
        c = new GridBagConstraints();
        setLayout (gridbag);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        //create the window
        frame = new JFrame("Hangman Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        picPanel = new JPanel();

        //label the frame
        JLabel label = new JLabel("<html> Welcome to Hangman." + "<P>" +
                "An evil warlord is playing a game with you." + "<P>"
                +"To save an innocent citizen, guess the word before he is hung by the neck until dead."
                +"<P>"+"Beware! The evil warlord is case sensitive."+"<P><P>Hint: "+control.getHint()) ;
        c.gridx = 0;
        c.gridy = 0;
        frame.add(label, BorderLayout.NORTH);

        //box for the entry of text
        addInputBox();
        Dashes(c);

        frame.getContentPane().add(picPanel, BorderLayout.SOUTH);

        //box for drawing the man
        Man();

        //Display the window
        frame.pack();
        frame.setVisible(true);
    }

    public void addInputBox()
    {
        inputBox = new JTextField(5);
        inputBox.addActionListener(this);

        c.gridx = 1;
        c.gridy = 0;
        panel.add(inputBox);

        frame.getContentPane().add(panel);
    }

    public void AddListener(Control control)
    {
        this.control = control;
    }

    public void Dashes(GridBagConstraints c)
    {
        dashes = new JTextArea("Guess the word " + control.getDisplayString());

        c.gridx = 2;
        c.gridy = 0;
        panel.add(dashes, c);
    }

    public void actionPerformed(ActionEvent evt)
    {
        String text = inputBox.getText();
        char inputChar;

        if(text != null)
        {
            inputChar = text.charAt(0);
        } else {
            inputChar = ' ';
        }

        panel.removeAll();

        control.acceptInput(inputChar);
        control.makeGuess();

        addInputBox();
        Dashes(c);

        control.isgameover(c);

        panel.validate();
        panel.repaint();
    }

    public void Man()
    {
        control.acceptOutput();

        JLabel picture;
        URL hangURL;
        Image hangman;

        picPanel.removeAll();

        switch(control.getManState())
        {
            case 1:
                hangURL = getClass().getResource("/Images/hangman1.jpg");
                hangman = Toolkit.getDefaultToolkit().getImage(hangURL);
                checkImage(hangman);
                picture = new JLabel(new ImageIcon(hangman));
                picPanel.add(picture, BorderLayout.SOUTH);
                break;
            case 2:
                hangURL = getClass().getResource("/Images/hangman2.jpg");
                hangman = Toolkit.getDefaultToolkit().getImage(hangURL);
                checkImage(hangman);
                picture = new JLabel(new ImageIcon(hangman));
                picPanel.add(picture, BorderLayout.SOUTH);
                break;
            case 3:
                hangURL = getClass().getResource("/Images/hangman3.jpg");
                hangman = Toolkit.getDefaultToolkit().getImage(hangURL);
                checkImage(hangman);
                picture = new JLabel(new ImageIcon(hangman));
                picPanel.add(picture, BorderLayout.SOUTH);
                break;
            case 4:
                hangURL = getClass().getResource("/Images/hangman4.jpg");
                hangman = Toolkit.getDefaultToolkit().getImage(hangURL);
                checkImage(hangman);
                picture = new JLabel(new ImageIcon(hangman));
                picPanel.add(picture, BorderLayout.SOUTH);
                break;
            case 5:
                hangURL = getClass().getResource("/Images/hangman5.jpg");
                hangman = Toolkit.getDefaultToolkit().getImage(hangURL);
                checkImage(hangman);
                picture = new JLabel(new ImageIcon(hangman));
                picPanel.add(picture, BorderLayout.SOUTH);
                break;
            case 6:
                hangURL = getClass().getResource("/Images/hangman6.jpg");
                hangman = Toolkit.getDefaultToolkit().getImage(hangURL);
                checkImage(hangman);
                picture = new JLabel(new ImageIcon(hangman));
                picPanel.add(picture, BorderLayout.SOUTH);
                break;
            case 7:
                hangURL = getClass().getResource("/Images/hangman7.jpg");
                hangman = Toolkit.getDefaultToolkit().getImage(hangURL);
                checkImage(hangman);
                picture = new JLabel(new ImageIcon(hangman));
                picPanel.add(picture, BorderLayout.SOUTH);
                break;
            case 8:
                hangURL = getClass().getResource("/Images/hangman8.jpg");
                hangman = Toolkit.getDefaultToolkit().getImage(hangURL);
                checkImage(hangman);
                picture = new JLabel(new ImageIcon(hangman));
                picPanel.add(picture, BorderLayout.SOUTH);
                break;
            default:
                hangURL = getClass().getResource("/Images/hangman0.jpg");
                hangman = Toolkit.getDefaultToolkit().getImage(hangURL);
                checkImage(hangman);
                picture = new JLabel(new ImageIcon(hangman));
                picPanel.add(picture, BorderLayout.SOUTH);
                break;
        }

        picPanel.validate();
        picPanel.repaint();
    }

    private void checkImage(Image image)
    {
        if(image == null)
        {
            JLabel errorLabel = new JLabel("Error with Hangman Image");
            c.gridx = 1;
            c.gridy = 3;
            panel.add(errorLabel,c);
        }
    }

    public void lose() {
        panel.removeAll();

        JLabel label = new JLabel("<html> You have failed to prevent the execution of an innocent. Shame on you.");

        panel.add(label,BorderLayout.CENTER);

        panel.validate();
        panel.repaint();
    }

    public void win() {
        panel.removeAll();

        JLabel label = new JLabel("<html> Congratulations! You saved an innocent from impending doom. Restart the program to play again.");

        panel.add(label,BorderLayout.CENTER);

        panel.validate();
        panel.repaint();
    }
}
