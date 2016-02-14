package stats;


import seq.SeqOp;
import seq.SeqType;

import java.util.EnumMap;

/**
 * Created by devinmcgloin on 1/30/16.
 */
public class Recommender {

    EnumMap<SeqOp, Integer> operations;

    public Recommender() {
        operations = new EnumMap<SeqOp, Integer>(SeqOp.class);
        for (SeqOp ops : SeqOp.values())
            operations.put(ops, 0);
    }

    public static void main(String[] args) {
        Recommender rec = new Recommender();
        System.out.println(rec);
        rec.inc(SeqOp.MEMBERSHIP);
        System.out.println(rec);
    }

    @Override
    public String toString() {
        return "Recommender{" +
                "operations=" + operations +
                '}';
    }

    public void clearSize() {
        operations.put(SeqOp.SIZE, 0);
    }

    public void inc(SeqOp op) {
        Integer i = operations.get(op);
        i += 1;
        operations.put(op, i);
    }

    public void incSize(int size) {
        Integer i = operations.get(SeqOp.SIZE);
        i += size;
        operations.put(SeqOp.SIZE, i);
    }

    public void decSize(int size) {
        Integer i = operations.get(SeqOp.SIZE);
        i -= size;
        operations.put(SeqOp.SIZE, i);
    }

    public SeqType reccomend() {
        return SeqType.HASHSET;
    }





}
