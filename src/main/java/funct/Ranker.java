package funct;

/**
 * Created by devinmcgloin on 1/25/16.
 * basically a fitness function, used for searches.
 * todo ranker is being called right now on every comparison. This is not advantageous for laborious ranking functions.
 */
public interface Ranker<E> {
    Double apply(E item);
}
