package funct;

/**
 * Created by devinmcgloin on 1/25/16.
 */
public interface Reductor<T> {

    void accept(T item);

    T result();

}
