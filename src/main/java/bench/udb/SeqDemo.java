package bench.udb;

import funct.DatedComparator;
import funct.Ranker;
import seq.Seq;

/**
 * @author devinmcgloin
 * @version 2/3/16.
 */
public class SeqDemo {

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

        data.sort(new DatedComparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (int) Math.floor(ranker.apply(o2) - ranker.apply(o1));
            }
        });
        System.out.println(data);

        data.filter(s -> s.startsWith("10"));
        System.out.println(data);
        populate(3, "");
        System.out.println(data.contains("101"));
        data.add("001");
        System.out.println(data);
        data.convert(Seq.TYPE.SET);
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
