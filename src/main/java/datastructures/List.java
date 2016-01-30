package datastructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by devinmcgloin on 1/25/16.
 */
public class List<E> extends Seq<E> {

    private LinkedList<E> elementData;

    public List() {
        elementData = new LinkedList<>();
    }

    protected List(E[] arr) {
        this();
        for (E item : arr)
            elementData.add(item);
    }

    public Seq.TYPE getType() {
        return TYPE.LIST;
    }

    ///-------------------- JAVA BOILERPLATE -------------------------------------///

    public boolean remove(Object item) {
        if (item.equals(elementData.getLast())) {
            elementData.removeLast();
            return true;
        }
        return elementData.remove(item);
    }

    public E remove(Integer index) {
        if (index == 0)
            return elementData.removeFirst();
        else if (index == size() - 1)
            return elementData.removeLast();
        else
            return elementData.remove((int) index);
    }

    public E get(Integer index) {
        if (index == 0)
            return elementData.getFirst();
        else if (index == size() - 1)
            return elementData.getLast();
        else
            return elementData.get(index);
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
