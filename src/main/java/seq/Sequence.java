package seq;


import datastructures.*;
import stats.Recommender;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 *
 * Created by devinmcgloin on 1/25/16.
 * Meta object that holds a seq. This is the one that keeps counts
 */
public class Sequence<E> {
    Seq<E> elementData;
    Recommender rec;

    public Sequence(Seq.TYPE t) {
        switch (t) {
            case ARRAY:
                elementData = new Array<E>();
                break;
            case TREE:
                elementData = new Tree<E>();
                break;
            case QUEUE:
                elementData = new Queue<E>();
                break;
            case SET:
                elementData = new Set<E>();
                break;
            case LIST:
                elementData = new List<E>();
                break;
            default:
                throw new IllegalArgumentException("Invalid type");
        }
        rec = new Recommender();
    }


    ///-------------------- JAVA BOILERPLATE -------------------------------------///

    public boolean remove(Object item) {
        return elementData.remove(item);
    }

    public E get(Integer index) {
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

    public boolean retainAll(Collection<?> c) {
        return elementData.retainAll(c);
    }

    public int size() {
        return elementData.size();
    }
}
