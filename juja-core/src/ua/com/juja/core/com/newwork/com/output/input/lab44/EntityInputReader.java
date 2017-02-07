package ua.com.juja.core.com.newwork.com.output.input.lab44;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by yulia on 03.02.17.
 */
public class EntityInputReader implements EntityInput{
    private Reader in;
    public EntityInputReader(Reader in){
        this.in = in;
    }

    @Override
    public Person readPerson() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(in);
        char[] age = new char[2];
        String line = bufferedReader.readLine();
        char[] chars = line.toCharArray();
        char[] name = new char[4];
        int j = 0;
        for (int i = 0; i < chars.length; i++) {

            if(chars[i] >= 'A' && chars[i] <= 'Z'){
                name[j] = chars[i];
                j++;
            }
            else if(chars[i] >= 'a' && chars[i] <= 'z' && j != 0){
                name[j] = chars[i];
                j++;
            }
            else if(j != 0 && !(chars[i] >= 'a' && chars[i] <= 'z') ){
               break;
            }
        }
        String nameString = String.valueOf(name);

        j = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= '0' && chars[i] <= '9'){
                age[j] = chars[i];
                j++;
            }
        }
        int ageInt =Integer.parseInt(String.valueOf(age));
        return new Person(nameString, ageInt);
    }

    @Override
    public Point readPoint() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(in);
        char[] firstPoint = new char[1];
        char[] secondPoint = new char[2];
        String line = bufferedReader.readLine();
        char[] chars = line.toCharArray();
        int i ;
        int k = 0;
        for ( i = 0; i < chars.length; i++) {
            if(chars[i] >= '0' && chars[i] <= '9'){
                firstPoint[0] = chars[i];
               k++;
            }
            else if(k != 0){
                break;
            }
        }
        k = 0;
        for (int j = i + 1; j < chars.length; j++) {
            if(chars[j] >= '0' && chars[j] <= '9' ){
                secondPoint[k] = chars[j];
                k++;
            }
            else if(k != 0){
                break;
            }
        }
        int firstInt =Integer.parseInt(String.valueOf(firstPoint));
        int secondInt =Integer.parseInt(String.valueOf(secondPoint));
        return new Point(firstInt,secondInt);
    }

  /*BODY*/
}
