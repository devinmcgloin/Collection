package datastructures;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by devinmcgloin on 1/25/16.
 */
public class Set<E> extends Seq<E> {

    private HashSet<E> elementData;

    public Set() {
        elementData = new HashSet<>();
    }

    protected Set(E[] arr) {
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
        int i = 0;
        for (E item : elementData) {
            if (i == index) {
                return item;
            }
            i++;
        }
        return null;
    }

    public boolean contains(Object item) {
        return elementData.contains(item);
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
}
