package bench.udb;

import bench.ContentGen;
import funct.DatedComparator;
import funct.Ranker;
import seq.Seq;
import seq.SeqType;

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

        ContentGen.populate(data, 3, "");
        System.out.println(data);
        data.filter(s -> s.startsWith("10"));
        System.out.println(data);

        ContentGen.populate(data, 3, "");
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
        ContentGen.populate(data, 3, "");
        System.out.println(data.contains("101"));
        data.add("001");
        System.out.println(data);
        data.convert(SeqType.HASHSET);
        System.out.println(data);
    }
}
