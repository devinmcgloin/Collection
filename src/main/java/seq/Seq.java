package seq;

import datastructures.Array;
import funct.*;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by devinmcgloin on 1/25/16.
 * Basic seq that everything has to follow.
 */
public interface Seq<E> {

    Seq<E> sort(Comparator<E> cmp);

    Seq<E> remove(Integer item);

    E get(Integer index);

    Boolean isMember(E item);

    Seq<E> subset(Seq<Integer> indexes);

    Seq<E> search(Ranker<E> rank);

    <T> Seq<Seq<E>> groupBy(Getter<E, T> getter);

    public enum TYPE {
        ARRAY, TREE, LIST, QUEUE, SET
    }

}
