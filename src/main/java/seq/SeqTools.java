package seq;

import datastructures.Array;
import funct.Functor;
import funct.Predicate;
import funct.Reductor;

import java.util.Iterator;

/**
 * Created by devinmcgloin on 1/26/16.
 */
public class SeqTools {

    private SeqTools(){}

    /**
     * @param reductor
     * @return
     */
    <E> E reduce(Reductor<E> reductor) {
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
    <E, T> Seq<T> map(Functor<E, T> functor) {
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
    <E> Seq<E> filter(Predicate<E> predicate) {
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
}
