package datastructures;

import funct.Ranker;
import seq.Seq;
import util.Tuple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by devinmcgloin on 1/25/16.
 */
public class Array<E> extends Seq<E> {

    private ArrayList<E> elementData;

    public Array() {
        elementData = new ArrayList<>();
    }

    private Array(ArrayList<E> list) {
        elementData = (ArrayList<E>) list.clone();
    }

    public Seq<E> sort(Comparator<E> comp){
        Array<E> arr = new Array(elementData);
        arr.elementData.sort(comp);
        return arr;
    }

    public Seq<E> remove(E item) {
        Array<E> arr = new Array(elementData);
        arr.elementData.remove(item);
        return arr;
    }

    public E get(Integer index) {
        return elementData.get(index);
    }

    public Boolean isMember(E item) {
        for (E member : elementData) {
            if (member.equals(item))
                return true;
        }
        return false;
    }

    public Seq<E> subset(Seq<Integer> indicies) {
        Seq<E> seq = new Array<>();
        for (int i = 0; i < indicies.size(); i++)
            seq = seq.add(elementData.get(indicies.get(i)));
        return seq;
    }

    public Iterator<E> iterator() {
        return elementData.iterator();
    }

    public Seq<E> add(E element) {
        Array<E> arr = new Array((ArrayList) elementData.clone());
        arr.elementData.add(element);
        return arr;
    }

    public Seq<E> search(Ranker<E> ranker) {
        Array<Tuple<Double, E>> rankings = new Array<Tuple<Double, E>>();
        for (E item : elementData) {
            rankings.add(new Tuple<Double, E>(ranker.apply(item), item));
        }
        rankings.sort((o1, o2) -> o1.getFirst().compareTo(o2.getFirst()));
        Seq<E> result = new Array<>();
        for (Tuple<Double, E> item : rankings.elementData) {
            result = result.add(item.getSecond());
        }
        return result;
    }

    public Integer size() {
        return elementData.size();
    }

    public String toString() {
        return elementData.toString();
    }

}
