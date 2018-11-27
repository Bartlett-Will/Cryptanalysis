import java.math.BigInteger;
import java.security.SecureRandom;

public class MR {
     public static void main(String[] args){
        int BIT_LENGTH = 1024;

        //generates 1 random, large positive number of length 1024 bits
        SecureRandom r = new SecureRandom();
        BigInteger a = new BigInteger(BIT_LENGTH, r);

        //System.out.println(a);

        Boolean prime = a.isProbablePrime(2^(-100));

        //desired output
        if(prime){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
