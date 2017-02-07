package ua.com.juja.core.com.newwork.com.output.input.lab44;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by yulia on 03.02.17.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Point expectedPoint = new Point(5, 10);
        StringWriter outStringWriter = new StringWriter();
        EntityOutputWriter writer = new EntityOutputWriter(outStringWriter);

        writer.writePoint(expectedPoint);
        String rawString = outStringWriter.toString();

        //call
        StringReader inStringReader = new StringReader(rawString);
        EntityInputReader reader = new EntityInputReader(inStringReader);
        Point actualPoint = reader.readPoint();

        // check
        if (actualPoint.getX() != expectedPoint.getX())
            throw new AssertionError("Expected Point X equals " + expectedPoint.getX() + " but found " + actualPoint.getX());

        if (actualPoint.getY() != expectedPoint.getY())
            throw new AssertionError("Expected Person Y equals " + expectedPoint.getY() + " but found " + actualPoint.getY());

        System.out.print("OK");
    }
}
