package bench.udb;

import bench.ContentGen;
import com.google.common.base.Stopwatch;
import datastructures.DynamicList;
import seq.Seq;
import seq.SeqType;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author devinmcgloin
 * @version 2/14/16.
 */
public class InitialTesting {
    static final int ITERATIONS = 5000;
    static final int SIZE = 15;
    static Seq<String> seq;
    static Random r = new Random();
    static TimeUnit timeUnit = TimeUnit.MILLISECONDS;

    public static void main(String[] args) {
        System.out.println(runTests(SeqType.HASHSET));
        System.out.println(runTests(SeqType.TREESET));
        System.out.println(runTests(SeqType.ARRAYLIST));
        System.out.println(runTests(SeqType.LINKEDLIST));
        System.out.println(runTests(SeqType.PRIORITYQUEUE));
    }

    public static DynamicList<Long> runTests(SeqType t) {
        DynamicList<Long> list = new DynamicList<>();
        seq = new Seq<>(t, true);
        ContentGen.populate(seq, SIZE, "");
        System.out.printf("\nType = %s\nSize = %6d\n", t, seq.size());

        //Membership
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < ITERATIONS; i++) {
            seq.contains(ContentGen.generateSequence(SIZE, ""));
        }
        System.out.printf("Membership = %s\n", stopwatch.stop());
        list.add(stopwatch.elapsed(timeUnit));

        //First
        stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < ITERATIONS; i++) {
            seq.get(0);
        }
        System.out.printf("getFirst = %s\n", stopwatch.stop());
        list.add(stopwatch.elapsed(timeUnit));

        //Last
        stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < ITERATIONS; i++) {
            seq.get(seq.size() - 1);
        }
        System.out.printf("getLast = %s\n", stopwatch.stop());
        list.add(stopwatch.elapsed(timeUnit));

        //Middle
        stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < ITERATIONS; i++) {
            seq.get(1 + r.nextInt(seq.size() - 1));
        }
        System.out.printf("getMiddle = %s\n", stopwatch.stop());
        list.add(stopwatch.elapsed(timeUnit));

        //First
        stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < ITERATIONS; i++) {
            seq.remove(0);
        }
        System.out.printf("rmFirst = %s\n", stopwatch.stop());
        list.add(stopwatch.elapsed(timeUnit));

        //Last
        stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < ITERATIONS; i++) {
            seq.remove(seq.size() - 1);
        }
        System.out.printf("rmLast = %s\n", stopwatch.stop());
        list.add(stopwatch.elapsed(timeUnit));

        //Middle
        stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < ITERATIONS; i++) {
            seq.remove(1 + r.nextInt(seq.size() - 1));
        }
        System.out.printf("rmMiddle = %s\n", stopwatch.stop());
        list.add(stopwatch.elapsed(timeUnit));
        return list;
    }

}
