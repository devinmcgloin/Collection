package factories;

import seq.Sequence;

import java.util.Collection;

/**
 * Created by devinmcgloin on 1/30/16.
 */
public class StringFactory {

    private StringFactory() {
    }

    public static void populate(Collection<String> col, int len, String primer) {
        if (primer.length() == len)
            col.add(primer);
        else {
            populate(col, len, primer + "0");
            populate(col, len, primer + "1");
        }
    }
}
