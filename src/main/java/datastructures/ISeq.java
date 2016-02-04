package datastructures;

import java.util.Collection;

/**
 * @author devinmcgloin
 * @version 2/3/16.
 */
public interface ISeq<E> extends Collection<E> {

    E get(int i);

    E remove(int i);

    boolean add(E item);

}
