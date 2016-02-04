package bench.udb;

import datastructures.Seq;

/**
 * @author devinmcgloin
 * @version 2/3/16.
 */
public class SeqDemo {

    public static void main(String[] args) {
        Seq<String> seq = new Seq<>();
        genData(seq, 3, "");

    }

    private static void genData(Seq<String> set, int len, String seq) {
        if (seq.length() == len)
            set.add(seq);
        else {
            genData(set, len, seq + "0");
            genData(set, len, seq + "1");
        }
    }
}
