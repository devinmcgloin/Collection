package seq;

import datastructures.Array;
import funct.Functor;
import funct.Predicate;
import funct.Ranker;
import funct.Reductor;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by devinmcgloin on 1/25/16.
 * Basic seq that everything has to follow.
 */
public abstract class Seq<E> {

    public abstract Integer size();

    public abstract Seq<E> sort(Comparator<E> cmp);

    public abstract Seq<E> remove(E item);

    public abstract E get(Integer index);

    public abstract Boolean isMember(E item);

    public abstract Seq<E> subset(Seq<Integer> indicies);

    public abstract Seq<E> search(Ranker<E> rank);

//    <T> Seq<Seq<E>> groupBy(Getter<E, T> getter);

    public abstract Iterator<E> iterator();

    public abstract Seq<E> add(E item);

    /**
     * @param reductor
     * @return
     */
    <E> E reduce(Seq<E> coll, Reductor<E> reductor) {
        Iterator<E> iter = coll.iterator();
        while (iter.hasNext()) {
            reductor.accept(iter.next());
        }
        return reductor.result();
    }

    /**
     * @param functor
     * @param <T>
     * @return
     */
    <E, T> Seq<T> map(Seq<E> coll, Functor<E, T> functor) {
        Seq<T> seq = new Array<>();
        Iterator<E> iter = coll.iterator();
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
    <E> Seq<E> filter(Seq<E> coll, Predicate<E> predicate) {
        Seq<E> seq = new Array<>();
        Iterator<E> iter = coll.iterator();
        while (iter.hasNext()) {
            E item = iter.next();
            if (predicate.apply(item)) {
                seq.add(item);
            }
        }
        return seq;
    }

    public enum TYPE {
        ARRAY, TREE, LIST, QUEUE, SET
    }

}
