package ua.com.juja.core.com.newwork.com.output.input.lab45;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by yulia on 07.02.17.
 */
public class ByteFilter {

    public static void filter(InputStream src, OutputStream dst, int bufferSize, byte filterCriteria) throws IOException {

        byte[] temp = new byte[bufferSize];
        src.read(temp);
        int k = 0;
        for (int i = 0; i < bufferSize; i++) {
            equalsFilterCriteria(bufferSize, filterCriteria, temp, i);
        }
        for (int i = 0; i < bufferSize; i++) {
           if(temp[i] !=filterCriteria){
               k++;
           }
        }
        dst.write(temp, 0, k);
        if(src.available() > 0){
            filter(src, dst, bufferSize, filterCriteria);
        }
    }

    private static boolean equalsFilterCriteria(int bufferSize, byte filterCriteria, byte[] temp, int i) {
        boolean result = false;
        if(temp[i] == filterCriteria){
            moving(bufferSize, filterCriteria, temp, i);
            result = true;
        }
        return result;
    }

    private static void moving(int bufferSize, byte filterCriteria, byte[] temp, int i) {
        if(i+1 < bufferSize){
            temp[i] = temp[i+1];
            temp[i+1] = filterCriteria;
            if(i >= 1){
                i-=1;
                equalsFilterCriteria(bufferSize, filterCriteria, temp, i);
            }

        }
    }
}
