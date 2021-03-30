import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;

public class GuessingGame implements ActionListener{
JTextField userGuess;

JButton guess;
JButton again;

JLabel enter;
JLabel highLow;
JLabel last;

Random r;
int random;

GuessingGame(){
  Random r = new Random();
  int random = r.nextInt(100)+1;

  JFrame frame = new JFrame("Guessing Game");
  frame.setLayout(new FlowLayout());
  frame.setSize(240,120);

  userGuess = new JTextField(10);
  userGuess.setActionCommand("myTF");

  guess = new JButton("Guess");
  again = new JButton("Play Again");

  userGuess.addActionListener(this);
  guess.addActionListener(this);
  again.addActionListener(this);

  enter = new JLabel("Enter your guess:");
  highLow = new JLabel("");
  last = new JLabel("");

  frame.add(enter);
  frame.add(userGuess);
  frame.add(guess);
  frame.add(highLow);
  frame.add(last);
  frame.add(again);

  frame.setVisible(true);

}

public void actionPerformed(ActionEvent ae){
  if(ae.getActionCommand().equals("Guess")){
    int guess = Integer.parseInt(userGuess.getText());

  if(random > guess){
    highLow.setText("Too high! ");
  }
  else if(random < guess){
    highLow.setText("Too low! ");
  }
  else{
    highLow.setText("You got it! ");
  }
  last.setText("Last guess was: " + guess);
  }

  else if(ae.getActionCommand().equals("Play Again")){
    Random r = new Random();
    int random = r.nextInt(100) + 1;
    enter.setText("Enter your guess:");
    highLow.setText("");
    last.setText("");
    userGuess.setText("");
  }
  else{
    highLow.setText("You pressed Enter. Please press the Guess button.");
  }

}

}