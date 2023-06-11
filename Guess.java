import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Guess extends JFrame {
    JTextField t1, t2, t3, t4;
    JLabel j4;
    ButtonListener bl1;
    ButtonListener2 bl2;
    ButtonListener3 bl3;

    int rand = (int) (Math.random() * 100);
    int count = 0;

    public Guess() {

        Container c = getContentPane();

        c.setLayout(null);

        c.setBackground(Color.WHITE);

        JLabel lblpic = new JLabel("");
        lblpic.setIcon(new ImageIcon("images.png"));
        lblpic.setBounds(0, 0, 500, 350);

        JLabel j = new JLabel("Guess My Number");
        j.setForeground(Color.BLACK);
        j.setFont(new Font("tunga", Font.ITALIC | Font.BOLD, 25));
        j.setSize(270, 30);
        j.setLocation(525, 24);

        JLabel j1 = new JLabel("Enter a number from 1-100 : ");
        j1.setFont(new Font("tunga", Font.BOLD, 17));
        j1.setSize(270, 20);
        j1.setLocation(500, 70);

        t1 = new JTextField(10);
        t1.setSize(50, 30);
        t1.setLocation(735, 70);

        j4 = new JLabel("Try and guess my number");
        j4.setFont(new Font("tunga", Font.ITALIC, 18));
        j4.setSize(270, 45);
        j4.setLocation(530, 135);

        t2 = new JTextField(10);
        t2.setSize(40, 25);
        t2.setLocation(575, 110);

        JLabel j5 = new JLabel("High Score : ");
        j5.setForeground(Color.BLUE);
        j5.setFont(new Font("tunga", Font.BOLD, 17));
        j5.setSize(270, 25);
        j5.setLocation(465, 110);

        t3 = new JTextField(10);
        t3.setSize(40, 25);
        t3.setLocation(775, 110);

        JLabel j6 = new JLabel("No.of Guesses : ");
        j6.setForeground(Color.RED);
        j6.setFont(new Font("tunga", Font.BOLD, 17));
        j6.setSize(270, 25);
        j6.setLocation(640, 110);

        JButton b1 = new JButton("GUESS");
        b1.setSize(150, 40);
        b1.setLocation(550, 190);
        bl1 = new ButtonListener();
        b1.addActionListener(bl1);

        JButton b2 = new JButton("EXIT");
        b2.setSize(150, 40);
        b2.setLocation(470, 250);
        bl2 = new ButtonListener2();
        b2.addActionListener(bl2);

        JButton b3 = new JButton("TRY AGAIN");
        b3.setSize(150, 40);
        b3.setLocation(650, 250);
        bl3 = new ButtonListener3();
        b3.addActionListener(bl3);

        c.add(j5);
        c.add(j4);
        c.add(lblpic);
        c.add(j);
        c.add(j1);
        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(j6);

        t2.setEditable(false);
        t3.setEditable(false);

        setTitle("GUESS MY NUMBER");

        setSize(550, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class ButtonListener implements ActionListener {
        int bestScore = 100;

        public void actionPerformed(ActionEvent e) {
            int a = Integer.parseInt(t1.getText());
            count = count + 1;
            if (a < rand) {
                j4.setText(a + " is too low, try again!!");
            } else if (a > rand) {
                j4.setText(a + " is too high, try again!!");
            } else {
                j4.setText("CORRECT, YOU WIN!!!!");
                if (count < bestScore) {
                    bestScore = count;
                    t2.setText(bestScore + "");
                } else
                    t2.setText("" + bestScore);
                t1.setEditable(false);
            }

            t1.requestFocus();
            t1.selectAll();

            t3.setText(count + "");
        }
    }

    private class ButtonListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            t3.setText("");
            j4.setText(rand + " is the answer!");
            t1.setText("");
            t1.setEditable(false);
        }
    }

    private class ButtonListener3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            rand = (int) (Math.random() * 100);
            t1.setText("");
            t3.setText("");
            j4.setText("Test Your Luck This Time");
            t3.setText("");
            count = 0;
            t1.setEditable(true);
            t1.requestFocus();
        }
    }

    public static void main(String[] args) {
        new Guess();
    }
}