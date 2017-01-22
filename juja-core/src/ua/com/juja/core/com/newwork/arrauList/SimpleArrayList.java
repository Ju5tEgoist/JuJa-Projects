package ua.com.juja.core.com.newwork.arrauList;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Created by yulia on 19.01.17.
 */
public class SimpleArrayList <E> implements SimpleList<E> {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private E[] data;
    private int size = 0;
    private int index = 0;
    private Iterator<E> iterator;
    public SimpleArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public SimpleArrayList(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];

        // My code
        //start
        //-------------------------------------------------------------------------
        iterator = new Iterator<E>() {
            @Override
            public boolean hasNext() {
                if (index == data.length - 1)
                    return false;
                for (int i = index; i < data.length ; i++) {

                    if (data[i] != null)
                    {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public E next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }

                return data[index++];
            }

            @Override
            public void remove() {

                if(index != 0){
                    int numMoved = size + 1  - index;
                    System.arraycopy(data, index, data, index-1, numMoved);
                }
                else {
                   throw new IllegalStateException();
                }

                data[--size] = null;

            }
        };
    }
    // end
//-----------------------------------------------------------------------------------------------------
    @Override
    public boolean add(E newElement) {
        ensureCapacity(size + 1);
        data[size] = newElement;
        size++;
        return true;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return data[index];
    }

    @Override
    public Iterator<E> iterator() {
        return iterator;
    }

    // My code
    // start
    //------------------------------------------------------------------------------------------
    @Override
    public String toString(){
        String result = "[";
        for (int i = 0; i < size(); i++) {
            if(i==0){
                result = result + data[i];
            }
            else{
                result = result + ", " + data[i];
            }
        }
        result = result + "]";
        return result;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || this.data == null){
            return false;
        }
        else if (!(o instanceof SimpleArrayList)){
            return false;
        }
        else if (o == this){
            return true;
        }
        else if(((SimpleArrayList) o).size() == this.size()){
            for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; i++) {
                if(((SimpleArrayList) o).get(i) == data[i]){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        int hashCode = 0;
        while (iterator.hasNext())
        {
            hashCode += iterator.next().hashCode();
        }
        return hashCode;
    }

    //end
    //--------------------------------------------------------------------------

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = data[index];
        int numMoved = size - index - 1;
        System.arraycopy(data, index + 1, data, index, numMoved);
        data[--size] = null;
        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index < 0 || size < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(minCapacity, data.length + (data.length >> 1));
            E[] newData = (E[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            this.data = newData;
        }
    }
}
