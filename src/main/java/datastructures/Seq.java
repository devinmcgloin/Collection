package datastructures;

import funct.Functor;
import funct.Predicate;
import funct.Ranker;
import funct.Reductor;
import util.Tuple;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by devinmcgloin on 1/25/16.
 * Basic seq that everything has to follow.
 */
public abstract class Seq<E> implements Collection<E> {

    public Seq() {
    }

    public Seq<E> sort(Comparator<E> cmp) {
        E[] arr = (E[]) toArray();
        Arrays.sort(arr, cmp);
        return switcher(getType(), arr);
    }

    public Seq<E> convert(TYPE t) {
        if (t == getType())
            return this;
        E[] arr = (E[]) toArray();
        return switcher(t, arr);
    }

    private Seq<E> switcher(TYPE t, E[] arr) {
        switch (t) {
            case ARRAY:
                return new Array<E>(arr);
            case TREE:
                return new Tree<E>(arr);
            case QUEUE:
                return new Queue<E>(arr);
            case SET:
                return new Set<E>(arr);
            case LIST:
                return new List<E>(arr);
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    public abstract TYPE getType();

    public abstract E get(Integer index);

    public Seq<E> subset(Seq<Integer> indicies) {
        Seq<E> seq = new Array<>();
        for (int i = 0; i < indicies.size(); i++)
            seq.add(get(indicies.get(i)));
        return seq;
    }

    public Seq<E> search(Ranker<E> ranker) {
        Seq<Tuple<Double, E>> rankings = new Array<Tuple<Double, E>>();
        for (E item : this) {
            rankings.add(new Tuple<Double, E>(ranker.apply(item), item));
        }
        rankings = rankings.sort((o1, o2) -> o2.getFirst().compareTo(o1.getFirst()));
        Seq<E> result = new Array<>();
        for (Tuple<Double, E> item : rankings) {
            result.add(item.getSecond());
        }
        return result;
    }

//    <T> Seq<Seq<E>> groupBy(Getter<E, T> getter);

    /**
     * @param reductor
     * @return
     */
    public <E> E reduce(Seq<E> coll, Reductor<E> reductor) {
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
    public <E, T> Seq<T> map(Seq<E> coll, Functor<E, T> functor) {
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
    public <E> Seq<E> filter(Seq<E> coll, Predicate<E> predicate) {
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
