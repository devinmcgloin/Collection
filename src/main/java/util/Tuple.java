package util;

/**
 * Created by devinmcgloin on 1/29/16.
 */
public class Tuple<E, T> {
    E first;
    T second;

    public Tuple(E first, T second) {

        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
