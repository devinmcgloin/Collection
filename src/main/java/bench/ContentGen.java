package bench;

import seq.Seq;

import java.util.Random;

/**
 * @author devinmcgloin
 * @version 2/14/16.
 */
public class ContentGen {
    static Random r = new Random();

    public static void populate(Seq<String> data, int len, String primer) {
        if (primer.length() == len)
            data.add(primer);
        else {
            populate(data, len, primer + "0");
            populate(data, len, primer + "1");
        }
    }

    public static String generateSequence(int len, String primer) {
        StringBuffer buffer = new StringBuffer();
        while (buffer.length() <= len) {
            if (r.nextBoolean()) {
                buffer.append("0");
            } else buffer.append("1");
        }
        return buffer.toString();
    }


}
