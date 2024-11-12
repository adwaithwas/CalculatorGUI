package adwaith;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator{
    //initialising all the req elements
    JFrame f;
    JTextField display;
    JButton[] numberButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, eqButton, clrButton;
    double num1, num2, ans;
    char operator;


    //default constructor
    Calculator(){
        f = new JFrame("Calculator");
        f.setSize(480,720);
        f.setVisible(true);
        f.setLayout(null);

        display = new JTextField();
        display.setBounds(50, 40, 360, 50);
        f.add(display);

        for (int i=0; i< 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setBounds(50 + (i % 3) * 100, 150 + (i / 3) * 100, 80, 80);
            f.add(numberButtons[i]);

            int finalI = i;
            numberButtons[i].addActionListener(e -> display.setText(display.getText() + finalI));
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        eqButton = new JButton("=");
        clrButton = new JButton("C");

        addButton.setBounds(350, 150, 80, 80);
        subButton.setBounds(350, 250, 80, 80);
        mulButton.setBounds(350, 350, 80, 80);
        divButton.setBounds(350, 450, 80, 80);
        eqButton.setBounds(250, 550, 180, 80);
        clrButton.setBounds(50, 550, 180, 80);

        f.add(addButton);
        f.add(subButton);
        f.add(mulButton);
        f.add(divButton);
        f.add(eqButton);
        f.add(clrButton);

        // adding action listeners
        addButton.addActionListener(e -> {
            num1 = Double.parseDouble(display.getText()); //extracting txt form the text field (1st number)
            operator = '+'; // setting the operator to plus (+)
            display.setText(""); // emptying the text field
        });

        subButton.addActionListener(e -> {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        });

        mulButton.addActionListener(e -> {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        });

        divButton.addActionListener(e -> {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        });

        eqButton.addActionListener(e -> {
            num2 = Double.parseDouble(display.getText()); // inputting the second number

            switch(operator){
                case '+':
                    ans = num1 + num2;
                    break;
                case '-':
                    ans = num1 - num2;
                    break;
                case '*':
                    ans = num1 * num2;
                    break;
                case '/':
                    ans = num1 / num2;
                    break;
            }
            display.setText((String.valueOf(ans)));

        });
        clrButton.addActionListener(e -> display.setText(""));


        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

public class Main {
    public static void main(String[] args) {
        new Calculator();
    }
}