package bench.stdJava;

import java.util.Set;

/**
 * @author devinmcgloin
 * @version 2/3/16.
 */
public class SetBench {

    private int iterations = 3;

    private static void genData(Set<String> set, int len, String seq) {
        if (seq.length() == len)
            set.add(seq);
        else {
            genData(set, len, seq + "0");
            genData(set, len, seq + "1");
        }
    }


}
