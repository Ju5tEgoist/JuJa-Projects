package ua.com.juja.core.com.newwork.com.output.input;
import java.io.*;
/**
 * Created by yulia on 01.02.17.
 */
public interface EntityInput {
    public Person readPerson() throws IOException;
    public Point readPoint() throws IOException;
}
