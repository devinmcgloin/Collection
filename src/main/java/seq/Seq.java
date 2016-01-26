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
public abstract class Seq<E> {

    Seq() {

    }

    Seq(Collection<E> collection) {
        for (E item : collection)
            add(item);
    }

    Seq(Seq<E> seq) {
        Iterator<E> iter = iterator();
        while (iter.hasNext()) {
            add(iter.next());
        }
    }

    /**
     * @param reductor
     * @return
     */
    E reduce(Reductor<E> reductor) {
        Iterator<E> iter = iterator();
        while (iter.hasNext()) {
            reductor.accept(iter.next());
        }
        return reductor.result();
    }

    /**
     *
     * @param functor
     * @param <T>
     * @return
     */
    <T> Seq<T> map(Functor<E, T> functor) {
        Seq<T> seq = new Array<>();
        Iterator<E> iter = iterator();
        while (iter.hasNext()) {
            seq.add(functor.apply(iter.next()));
        }
        return seq;
    }

    /**
     * todo would like to extend this to work for multiple predicates.
     *
     * @param predicate
     * @return
     */
    Seq<E> filter(Predicate<E> predicate) {
        Seq<E> seq = new Array<>();
        Iterator<E> iter = iterator();
        while (iter.hasNext()) {
            E item = iter.next();
            if (predicate.apply(item)) {
                seq.add(item);
            }
        }
        return seq;
    }

    abstract Seq<E> sort(Comparator<E> cmp);

    abstract Seq<E> add(E item);

    abstract Seq<E> remove(E item);

    abstract Seq<E> remove(Integer item);

    abstract Iterator<E> iterator();

    abstract E get(Integer index);

    abstract Boolean isMember(E item);

    abstract Seq<E> subset(Seq<Integer> indexes);

    abstract Seq<E> search(Ranker<E> rank);

    abstract <T> Seq<Seq<E>> groupBy(Getter<E, T> getter);

    public enum TYPE {
        ARRAY, TREE, LIST, QUEUE, SET
    }

}
