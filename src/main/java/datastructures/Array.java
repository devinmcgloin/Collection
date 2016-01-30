package datastructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by devinmcgloin on 1/25/16.
 */
public class Array<E> extends Seq<E> {

    private ArrayList<E> elementData;

    public Array() {
        elementData = new ArrayList<>();
    }

    protected Array(E[] arr) {
        this();
        for (E item : arr)
            elementData.add(item);
    }

    public Seq.TYPE getType() {
        return TYPE.ARRAY;
    }


    ///-------------------- JAVA BOILERPLATE -------------------------------------///

    public boolean remove(Object item) {
        return elementData.remove(item);
    }

    public E get(Integer index) {
        return elementData.get(index);
    }

    public boolean contains(Object item) {
        return indexOf(item) > 0;
    }

    public boolean containsAll(Collection<?> c) {
        return elementData.containsAll(c);
    }

    public boolean equals(Object o) {
        return elementData.equals(o);
    }

    public Iterator<E> iterator() {
        return elementData.iterator();
    }

    public boolean add(E element) {
        return elementData.add(element);
    }

    public boolean addAll(Collection<? extends E> c) {
        return elementData.addAll(c);
    }

    public void clear() {
        elementData.clear();
    }

    public String toString() {
        return elementData.toString();
    }

    public Object[] toArray() {
        return elementData.toArray();
    }

    public <T> T[] toArray(T[] arr) {
        return elementData.toArray(arr);
    }

    public boolean removeAll(Collection<?> c) {
        return elementData.removeAll(c);
    }

    public boolean isEmpty() {
        return elementData.isEmpty();
    }

    public int hashCode() {
        return elementData.hashCode();
    }

    public Stream<E> parallelStream() {
        return elementData.parallelStream();
    }

    public boolean removeIf(Predicate<? super E> filter) {
        return elementData.removeIf(filter);
    }

    public boolean retainAll(Collection<?> c) {
        return elementData.retainAll(c);
    }

    public int size() {
        return elementData.size();
    }

    private int indexOf(Object item) {
        if (isSorted()) {
            int high = size();
            int low = 0;
            int mid;
            while (high >= low) {
                mid = (low + high) >>> 1;
                int cmp = getComparator().compare((E) item, elementData.get(mid));

                if (cmp < 0) {
                    low = mid + 1;
                } else if (cmp > 0) {
                    high = mid - 1;
                } else
                    return mid;
            }
            return -(low + 1);
        } else {

            for (int i = 0; i < elementData.size(); i++) {
                if (elementData.get(i).equals(item))
                    return i;
            }
            return -size();
        }
    }
}
