package ua.com.juja.core.com.newwork.findK;

import java.util.Iterator;

/**
 * Created by yulia on 24.01.17.
 */
public class FinderElements {

    public static Integer findElement(SinglyLinkedList<Integer> singlyLinkedList, int k) {
        int index = 0;
        int size = 0;
        Integer value = null;
        Iterator<Integer> iter = singlyLinkedList.iterator();
        while(iter.hasNext()) {
            iter.next();
            size++;
        }
        while (iter.hasNext() && size - index > k && k > 0){
            value = iter.next();
            index++;
        }
        if(value == null){
            throw new IndexOutOfBoundsException();
        }
        return value;
        }

}
