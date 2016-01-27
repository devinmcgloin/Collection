package datastructures;

import seq.Seq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by devinmcgloin on 1/25/16.
 */
public class Array<E> extends ArrayList<E>, implements Seq<E> {

    public Seq<E> sort(Comparator<E> comp){
        Array<E> arr = (Array<E>) this.clone();
        Collections.sort(arr, comp);
        return arr;
    }
}
