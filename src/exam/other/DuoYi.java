package exam.other;

import java.math.BigInteger;

public class DuoYi {

    public static void main(String[] args) {
        BigInteger A = new BigInteger("1000000000000000000000000000000000000000000000000001");
        String B = "100000";
        BigInteger remainder = A.remainder(new BigInteger(B));
        Integer integer = Integer.valueOf(remainder.toString());
        System.out.println(integer);
    }

}
