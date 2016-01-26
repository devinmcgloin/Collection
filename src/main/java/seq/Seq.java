package seq;

import datastructures.Array;
import funct.*;

import java.util.Iterator;

/**
 * Created by devinmcgloin on 1/25/16.
 * Basic seq that everything has to follow.
 */
public abstract class Seq<E> {

    Seq() {

    }

    Seq(Seq<E> seq) {

    }

    <T> T reduce(Functor<E, T> functor) {

    }

    <T> Seq<T> map(Functor<E, T> functor) {
        Seq<T> seq = new Array<>();
        Iterator<E> iter = iterator();
        while (iter.hasNext()) {
            seq.add(functor.apply(iter.next()));
        }
        return seq;
    }

    Seq<E> filter(Predicate<E> predicate) {

    }

    Seq<E> filter(Seq<Predicate<E>> predicates) {

    }

    abstract void sort(Comparator<E> cmp);

    abstract Seq<E> add(E item);

    abstract Seq<E> remove(E item);

    abstract Seq<E> remove(Integer item);

    abstract Iterator<E> iterator();

    abstract E get(Integer index);

    abstract Boolean isMember(E item);

    abstract Seq<E> subset(Seq<Integer> indexes);

    abstract Seq<E> search(Ranker<E> rank);

    abstract <T> Seq<Seq<E>> groupBy(Getter<E, T> getter);

}
