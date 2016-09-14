package ua.com.juja.core;

import java.math.BigInteger;

/**
 * Created by yulia on 14.09.16.
 * Реализовать метод, который преобразует BigInteger в битовую строку (String из '0' и '1')
 * toBitStr(new BigInteger("2")) = "10" toBitStr(new BigInteger("8")) = "1000"
 * toBitStr(new BigInteger("10")) = "1010" toBitStr(new BigInteger("140")) = "10001100"
 */

public class BigIntegerUtils {
    public static String toBitStr(BigInteger arg) {
        BigInteger[] resultArray = new BigInteger[0];
        int index = 0;
        String arrayToString = "";

        BigInteger[] array = {new BigInteger("256") ,new BigInteger("128"), new BigInteger("64"), new BigInteger("32"), new BigInteger("16"), new BigInteger("8"), new BigInteger("4"), new BigInteger("2"), new BigInteger("1") };

        if(arg.equals(new BigInteger("0"))){
            return "0";
        }

        for (int i = 0; i < array.length; i++) {
            if(arg.compareTo(array[i]) == 1 || arg.compareTo(array[i]) == 0 ){
                if(resultArray.length == 0){
                resultArray = new BigInteger[array.length - i];
                    index = 0;
                }
                arg = arg.subtract(array[i]) ;
                resultArray[index] = new BigInteger("1");

            }
            else if(resultArray.length != 0) {
                resultArray[index] = new BigInteger("0");
            }
            index++;
        }
        for (int k = 0; k < resultArray.length; k++) {
             arrayToString += resultArray[k].toString();
        }
        return arrayToString;
    }
}
