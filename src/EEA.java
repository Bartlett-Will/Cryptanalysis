import java.util.*;
import java.math.BigInteger;
import java.security.SecureRandom;


public class EEA {
    public static void main(String [] args){

        int BIT_LENGTH = 1024;

        //generates 2 random, primes of length 1024 bits
        Random r = new SecureRandom();
        BigInteger a = BigInteger.probablePrime(BIT_LENGTH, r);
        BigInteger b = BigInteger.probablePrime(BIT_LENGTH, r);

        //prints a & b
        System.out.println("a = " + a + "\nb = " + b);

        //calc. c & d
        BigInteger c = a.modInverse(b);
        BigInteger d = b.modInverse(a);

        //prints c & d
        System.out.println("c = " + c + "\nd = " + d);


    }


}
