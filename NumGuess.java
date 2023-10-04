package OasisTasks_Agniv_017;

import javax.swing.*;
import javax.swing.border.Border;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class UniqNumGuess extends JFrame {
    private int targetNumber;
    private int maxAttempts = 10;
    private int attempts = 0;

    private JTextField fieldInput;
    private JButton buttonOfGuess;
    private JLabel messageResult;

    public UniqNumGuess() {
        setTitle("Let's do guessing!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        Random random = new Random();
        targetNumber = random.nextInt(100) + 1;

        JLabel gameTitleLabel = new JLabel("Hmm...What number can it be from 1 to 100? ");
        add(gameTitleLabel);

        fieldInput = new JTextField(10);
        add(fieldInput);

        buttonOfGuess = new JButton("Let's Check!");
        buttonOfGuess.setFont(new Font("Arial", Font.PLAIN, 12)); 
        Border buttonBorder = BorderFactory.createLineBorder(Color.RED, 2); 
        buttonOfGuess.setBorder(buttonBorder);
        buttonOfGuess.addActionListener(new GuessSubmitListener());
        add(buttonOfGuess);

        messageResult = new JLabel("Attempts Remaining: " + (maxAttempts - attempts));
        add(messageResult);

        setVisible(true);
    }

    private class GuessSubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int userGuess;
            try {
                userGuess = Integer.parseInt(fieldInput.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Oh no! It's a wrong guess. Try again!");
                return;
            }

            attempts++;
            messageResult.setText("Attempts Remaining: " + (maxAttempts - attempts));

            if (userGuess == targetNumber) {
                JOptionPane.showMessageDialog(null, "Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                dispose(); 
            } else if (attempts >= maxAttempts) {
                JOptionPane.showMessageDialog(null, "Sorry, you've exhausted your attempts. The correct number was: " + targetNumber);
                dispose();
            } else if (userGuess == targetNumber-1){
                String message = "You were soo close! Try again.";
                JOptionPane.showMessageDialog(null, message);
            } else if (userGuess == targetNumber+1) {
                String message = "You were soo close! Try again.";
                JOptionPane.showMessageDialog(null, message);
            } else {
                String message = (userGuess < targetNumber) ? "Your guess is low. Try again." : "Your guess is high. Try again.";
                JOptionPane.showMessageDialog(null, message);
            }

            fieldInput.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UniqNumGuess::new);
    }
}
