package ua.com.juja.core.com.newwork.findK;

/**
 * Created by yulia on 25.01.17.
 */
public class Test {
    public static void main(String[] args) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(2);

        Integer actualElement = null;

        try {
            actualElement = FinderElements.findElement(list, 4);
            if (actualElement == null)
                throw new AssertionError("result findElement()  is not null");
        } catch (IndexOutOfBoundsException e) {
            // expected behaviour
        }

        try {
            actualElement = FinderElements.findElement(list, -4);
            if (actualElement == null)
                throw new AssertionError("result findElement()  is not null");
        } catch (IndexOutOfBoundsException e) {
            // expected behaviour
        }

        if (actualElement != null)
            throw new AssertionError("list is empty and expected ArrayIndexOutOfBoundsException  but found" + actualElement.toString());

        System.out.print("OK");
    }


}
