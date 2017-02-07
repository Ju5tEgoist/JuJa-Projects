package ua.com.juja.core.com.newwork.com.output.input.lab44;

import java.io.IOException;

/**
 * Created by yulia on 03.02.17.
 */
public interface EntityOutput {
    public void writePerson(Person person) throws IOException;

    public void writePoint(Point point) throws IOException;
}
