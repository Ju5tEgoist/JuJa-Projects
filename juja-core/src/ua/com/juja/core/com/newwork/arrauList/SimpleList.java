package ua.com.juja.core.com.newwork.arrauList;

import java.util.Iterator;

/**
 * Created by yulia on 19.01.17.
 */
public interface SimpleList <E> {
    public boolean add(E newElement);
    public E get(int index);
    public Iterator<E> iterator();
    public int size();
    public boolean isEmpty();
    public E remove(int index);
}
