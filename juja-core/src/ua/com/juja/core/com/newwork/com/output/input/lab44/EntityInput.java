package ua.com.juja.core.com.newwork.com.output.input.lab44;

import java.io.IOException;

/**
 * Created by yulia on 03.02.17.
 */
public interface EntityInput {
    public Person readPerson() throws IOException;

    public Point readPoint() throws IOException;
}
