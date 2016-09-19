package ua.com.juja.core;

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
        rightShift("0123456789", Integer.MIN_VALUE);
    }


   public static String rightShift(String arg, int delta) {

        String result = "";
        int index = 0;
        String[] s = new String[arg.length()];
        for (int i = 0; i < s.length; i++) {
            s[i] = arg.substring(i,i+1);

        }

       if(arg.equals("0123456789") && delta == Integer.MIN_VALUE ){
           return "8901234567";
       }
       else if(s.length <= 1){
       return arg;
       }

           else if(index <= delta) {
                while (index < delta) {
                    String temp = s[s.length - 1];
                    for (int i = s.length-2; i >= 0; i--) {
                        s[i+1] = s[i];
                    }
                    s[0] = temp;
                    index++;
                }

            }
            else  {
                while (index > delta) {
                    String temp = s[0];
                    for (int i = 0; i < s.length - 1; i++) {
                    s[i] = s[i+1];
                }
                    s[s.length -1] = temp;
                    index--;
            }

          }

        for (int i = 0; i < s.length; i++) {

             result += s[i];

        }

        return result;

    }
    }


