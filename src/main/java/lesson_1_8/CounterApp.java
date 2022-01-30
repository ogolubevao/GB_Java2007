package lesson_1_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {
    private int value;
    private JLabel infoLabel;


    public CounterApp() {
        setBounds(500, 200, 400, 150);
        setTitle("Counter App");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);



        //Font
        Font font = new Font("Arial", Font.BOLD, 32);

        //text fields not editable
        JLabel label = new JLabel("0");
        label.setFont(font);
        label.setBounds(151, 40, 100, 40);
        //label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);

        //add infopanel
        //show error if |value| more than 10
        infoLabel = new JLabel();
        infoLabel.setBounds(10, 10, 150, 20);
        add(infoLabel);





        //Buttons to increment and decrement
        JButton decrementbutton = new JButton("<");
        decrementbutton.setFont(font);
        decrementbutton.setBounds(81, 40, 60,40);
        add(decrementbutton);

        JButton incrementbutton = new JButton(">");
        incrementbutton.setFont(font);
        incrementbutton.setBounds(221, 40, 60, 40);
        add(incrementbutton);

        decrementbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value--;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        incrementbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value++;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        //Buttons to increment and decrement by 10
        JButton decrementbutton10 = new JButton("<<");
        decrementbutton10.setFont(font);
        decrementbutton10.setBounds(0,40,80,40);
        add(decrementbutton10);

        JButton incrementbutton10 = new JButton(">>");
        incrementbutton10.setFont(font);
        incrementbutton10.setBounds(281, 40, 80,40);
        add(incrementbutton10);

        decrementbutton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value-=10;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        incrementbutton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value+=10;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });



        setVisible(true);



    }

    private void validateRange() {
        if (Math.abs(value)>10) {
            infoLabel.setText("Value out of range");
        } else {
            infoLabel.setText("");
        }
    }

    public static void main(String[] args) {
        new CounterApp();
    }
}
