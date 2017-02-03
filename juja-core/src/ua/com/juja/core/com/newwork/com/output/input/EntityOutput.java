package ua.com.juja.core.com.newwork.com.output.input;
import java.io.*;
/**
 * Created by yulia on 01.02.17.
 */
public interface EntityOutput {
    public void writePerson(Person person) throws IOException;
    public void writePoint(Point point) throws IOException;
}
