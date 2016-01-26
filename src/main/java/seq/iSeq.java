package seq;

import funct.*;

import java.util.Iterator;

/**
 * Created by devinmcgloin on 1/25/16.
 * Basic seq inteface that everything has to follow.
 */
public interface iSeq<E> {

    <T> iSeq<T> map(Functor<E, T> functor);

    iSeq<E> filter(Predicate<E> predicate);

    iSeq<E> filter(iSeq<Predicate<E>> predicates);

    void sort(Comparator<E> cmp);

    iSeq<E> add(E item);

    iSeq<E> remove(E item);

    iSeq<E> remove(Integer item);

    Iterator<E> iterator();

    E get(Integer index);

    Boolean isMember(E item);

    iSeq<E> subset(Seq<Integer> indexes);

    iSeq<E> search(Ranker<E> rank);

    iSeq<iSeq<E>> groupBy(Getter<E> getter);

}
