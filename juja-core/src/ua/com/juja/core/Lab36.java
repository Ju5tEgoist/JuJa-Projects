package ua.com.juja.core;

import java.math.BigInteger;

/**
 * Created by yulia on 18.09.16.
 */
public class Lab36 {
    public static BigInteger[] mul(BigInteger[] x, BigInteger[] y) {
        BigInteger[] mulArray = new BigInteger[x.length + y.length - 1];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length ; j++) {
                if(!(mulArray[i+j] == null)){
                    mulArray[i+j] = mulArray[i+j].add(x[i].multiply(y[j]));
                }
                else{
                    mulArray[i+j] = x[i].multiply(y[j]);
                }
            }

        }
        return mulArray;
    }
}
