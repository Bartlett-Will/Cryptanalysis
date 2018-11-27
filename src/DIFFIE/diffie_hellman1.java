package DIFFIE;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;
import java.math.BigInteger;
import java.security.SecureRandom;

public class diffie_hellman1 {
    BigInteger p = new BigInteger("65537");
    BigInteger g = new BigInteger("3");
    BigInteger x;
    BigInteger y;
    BigInteger X;
    BigInteger Y;
    BigInteger k1;
    BigInteger k2;


    private JPanel panel1;
    private JTextField xfield;
    private JTextField yfield;
    private JButton Ycom;
    private JTextField Yfield;
    private JButton Xcom;
    private JTextField Xfield;
    private JTextField k1field;
    private JTextField k2field;
    private JButton k1button;
    private JButton k2button;

    public diffie_hellman1() {
        Xcom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //2. Compute X = g^x modp
                x = new BigInteger(xfield.getText());
                X = g.modPow(x,p);
                Xfield.setText(X.toString());
            }
        });
        Ycom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //4. Compute Y = g^y mod p
                y = new BigInteger(yfield.getText());
                Y = g.modPow(y,p);
                Yfield.setText(Y.toString());
            }
        });
        k1button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //K = Y^x mod p =
                k1 = Y.modPow(x,p);
                k1field.setText(k1.toString());
            }
        });
        k2button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //K = X^y mod p =
                k2 = X.modPow(y,p);
                k2field.setText(k2.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("diffie_hellman1");
        frame.setContentPane(new diffie_hellman1().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
