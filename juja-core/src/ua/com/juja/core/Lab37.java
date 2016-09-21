package ua.com.juja.core;
import java.lang.Math;
/**
 * Created by yulia on 19.09.16.
 */
public class Lab37 {
    /*
    * Реализовать функцию, которая делает циклический сдвиг букв вправо, то есть rightShift("ABCDE", 1) = "EABCD"
    * rightShift("ABCDE", 2) = "DEABC" rightShift("ABCDE", 3) = "CDEAB" rightShift("ABCDE", 4) = "BCDEA" Допустимо
     * сдвигать на расстояние больше длины строки rightShift("ABCDE", 5) = "ABCDE" rightShift("ABCDE", 6) = "EABCD"
     * rightShift("ABCDE", 7) = "DEABC" Допустимо сдвигать на отрицательное расстояние (выходит сдвиг влево)
     * rightShift("ABCDE", -1) = "BCDEA" rightShift("ABCDE", -2) = "CDEAB" rightShift("ABCDE", -7) = "CDEAB".
     * Сдвиг на расстояние 0 и сдвиги строк длиной 0 и 1 символ - разрешены.*/

    public static void main(String[] args) {
        long start = System.currentTimeMillis();


        System.out.println(Lab37.rightShift("0123456789", Integer.MIN_VALUE));
        System.out.println("Time: " + (System.currentTimeMillis() - start) + "ms");
    }

   public static String rightShift(String arg, int delta) {

       String res = "";

       if(arg.length() != 0) {
           int newDelta = returnNewDelta(arg, delta);

           String before;
           String after;
           if (delta > 0) {

                   before = arg.substring(0, arg.length()  - newDelta);
                   after = arg.substring(arg.length() - newDelta, arg.length());


           } else {
               before = arg.substring(0, newDelta);
               after = arg.substring(newDelta, arg.length());

           }
           res = after + before;
       }


        return res;

    }
    public static int returnNewDelta(String arg, int delta){

            if (Math.abs(delta) > arg.length() || delta < -arg.length()) {
                Integer temp = delta % arg.length();
                if(temp > arg.length()){
                    returnNewDelta( arg, delta);
                }
                delta = Math.abs(temp);


            } else {
                delta = Math.abs(delta);
            }

        return delta;
    }
    }


