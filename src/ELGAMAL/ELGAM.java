package ELGAMAL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class ELGAM {
    BigInteger p = new BigInteger("65537");
    BigInteger g = new BigInteger("3");
    BigInteger x,y,r,c1,c2,m,decM;

    private JPanel panel1;
    private JTextField xfield;
    private JButton ycom;
    private JButton c1com;
    private JButton dec_button;
    private JTextField rfield;
    private JTextField c1field;
    private JButton c2com;
    private JTextField c2field;
    private JTextField decMfield;
    private JTextField yfield;
    private JTextField mfield;

    public ELGAM() {
        ycom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //y=g^x mod p
                x = new BigInteger(xfield.getText());
                y = g.modPow(x,p);
                yfield.setText(y.toString());
            }
        });
        c1com.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //c1 = g^r mod p
                r = new BigInteger(rfield.getText());
                c1 = g.modPow(r,p);
                c1field.setText(c1.toString());
            }
        });
        c2com.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Compute c2 = m* y^r mod p
                m = new BigInteger(mfield.getText());
                c2 = m.multiply(y.modPow(r,p));
                c2field.setText(c2.toString());
            }
        });
        dec_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //m = c2/(c1^x mod p)
                decM = c2.divide(c1.modPow(x,p));
                decMfield.setText(decM.toString());
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("ELGAM");
        frame.setContentPane(new ELGAM().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
