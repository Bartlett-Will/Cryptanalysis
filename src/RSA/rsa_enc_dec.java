package RSA;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;
import java.math.BigInteger;
import java.security.SecureRandom;

public class rsa_enc_dec {
    //int BIT_LENGTH = 1024;
    int p = 0;
    int q = 0;
    int n = 0;
    BigInteger bigN;
    BigInteger key;
    BigInteger d;
    BigInteger m;
    BigInteger c;



    private JPanel panel1;
    private JButton pq_genButton;
    private JTextField xfield;
    private JButton Xcom;
    private JTextField qfield;
    private JTextField Xfield;
    private JTextField yfield;
    private JButton Ycom;
    private JButton enc_button;
    private JButton k1button;
    private JTextField og_mField;
    private JTextField k1field;
    private JTextField k2field;
    private JTextField Yfield;
    private JButton k2button;


    public rsa_enc_dec() {
        pq_genButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random r = new SecureRandom();
                p = r.nextInt(100000) + 1000;
                q = r.nextInt(5001);
                xfield.setText(Integer.toString(p));
                qfield.setText(Integer.toString(q));

            }
        });
        Xcom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n = p * q;
                Xfield.setText(Integer.toString(n));
            }
        });
        Ycom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                key = new BigInteger(yfield.getText());
                bigN = new BigInteger(Integer.toString(n));
                d = key.modInverse(bigN);
                Yfield.setText(d.toString());
            }
        });
        enc_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m = new BigInteger(og_mField.getText());
                //c = m^e modn
                c = m.modPow(key,bigN);
                k1field.setText(c.toString());
            }
        });
        k1button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //m = c^d modn
                BigInteger decryptM = c.modPow(d,bigN);
                k2field.setText(m.toString());
            }
        });


    }

    public static void main(String[] args) {
         JFrame frame = new JFrame("rsa_enc_dec");
         frame.setContentPane(new rsa_enc_dec().panel1);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack();
         frame.setVisible(true);
    }
}
