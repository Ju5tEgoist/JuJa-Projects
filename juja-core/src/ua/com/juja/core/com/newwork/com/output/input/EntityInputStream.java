package ua.com.juja.core.com.newwork.com.output.input;

import java.io.*;
/**
 * Created by yulia on 01.02.17.
 */
public class EntityInputStream implements EntityInput {
    private DataInput in;
    public EntityInputStream(InputStream in){
        this.in = new DataInputStream (in);
    }


    @Override
    public Person readPerson() throws IOException {
        int age = 0;
        byte[] input = new byte[10];
        int i = 0;
        String name = "";
        while(in.readByte() != -1){
             input[i] = in.readByte();
            if(input[i] != 0){
                age = input[i];
                break;
            }
            i++;
        }
        char[] array;
        array = in.readLine().toCharArray();
        for (int j = 0; j < 7; j++) {
            if ((array[j] >= 'a' && array[j] <= 'z') || (array[j] >= 'A' && array[j] <= 'Z')){
                name += array[j];
            }
        }
        return new Person(name,age);
    }

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
    @Override
    public Point readPoint() throws IOException {
        byte temp = in.readByte();
        int v = temp & 0xFF;
        Character hexChars = hexArray[v >>> 4];
        Character hexChars2 = hexArray[v & 0xF];
        int x = Integer.parseInt(hexChars.toString());
        int y = Integer.parseInt(hexChars2.toString(), 16);
        return new Point(x,y);
    }

}
