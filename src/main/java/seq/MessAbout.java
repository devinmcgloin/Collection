package seq;

import datastructures.Seq;
import funct.Ranker;

/**
 * Created by devinmcgloin on 1/29/16.
 */
public class MessAbout {

    private static Seq<String> data;

    public static void main(String[] args) {
        Ranker<String> ranker = item -> {
            double score = 0;
            if (item.startsWith("0"))
                score += 2;
            if (item.endsWith("01"))
                score += 3;
            return score;
        };

        data = new Seq<>();

        populate(3, "");
        System.out.println(data);
        data.filter(s -> s.startsWith("10"));
        System.out.println(data);

        populate(3, "");
        data.search(ranker);
        System.out.println(data);

        for (String s : data) {
            System.out.printf("%2d %4s\n", (int) Math.floor(ranker.apply(s)), s);
        }
        data.sort((o1, o2) -> (int) Math.floor(ranker.apply(o2) - ranker.apply(o1)));
        System.out.println(data);

        data.filter(s -> s.startsWith("10"));
        System.out.println(data);
        System.out.println(data.contains("101"));
        System.out.println(data);
    }

    private static void populate(int len, String primer) {
        if (primer.length() == len)
            data.add(primer);
        else {
            populate(len, primer + "0");
            populate(len, primer + "1");
        }

    }

    private static void randOps() {

    }
}
