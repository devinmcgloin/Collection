package datastructures;

import org.junit.Before;
import org.junit.Test;
import seq.Seq;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by devinmcgloin on 1/29/16.
 */
public class ArrayTest {
    private Seq<Integer> arr;
    private ArrayList<Integer> arrayList;
    private Random r;

    @Before
    public void setUp() throws Exception {
        r = new Random();
        arr = new Array<>();
        arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i += 3) {
            arr = arr.add(i);
            arrayList.add(i);
        }
    }

    @Test
    public void testSort() throws Exception {
        arrayList.sort((o1, o2) -> o2.compareTo(o1));
        arr = arr.sort((o1, o2) -> o2.compareTo(o1));
        for (int i = 0; i < arrayList.size(); i++) {
            assertEquals(arrayList.get(i), arr.get(i));
        }
    }

    @Test
    public void testRemove() throws Exception {
        for (int i = 0; i < 100; i += 2) {
            arrayList.remove((Integer) i);
            arr = arr.remove(i);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            assertEquals(arrayList.get(i), arr.get(i));
        }
    }

    @Test
    public void testGet() throws Exception {
        int size = arrayList.size();
        for (int i = 0; i < 100; i++) {
            int index = r.nextInt(size);
            assertEquals(arrayList.get(index), arr.get(index));
        }
    }

    @Test
    public void testIsMember() throws Exception {
        for (int i = 0; i < 100; i++) {
            int searching = r.nextInt(150);
            boolean found = false;
            for (Integer integer : arrayList) {
                if (integer.equals(searching))
                    found = true;
            }
            assertEquals(found, arr.isMember(searching));
        }
    }

    @Test
    public void testSubset() throws Exception {
        ArrayList<Integer> subset = new ArrayList<>();
        Seq<Integer> indicies = new Array<>();
        for (int i = 0; i < arrayList.size(); i += 4) {
            subset.add(arrayList.get(i));
            indicies = indicies.add(i);
        }
        arr = arr.subset(indicies);
        for (int i = 0; i < subset.size(); i++) {
            assertEquals(subset.get(i), arr.get(i));
        }
    }


    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testSearch() throws Exception {

    }
}