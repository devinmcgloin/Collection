package datastructures;

import org.junit.Before;
import org.junit.Test;
import seq.Sequence;

import java.util.PriorityQueue;
import java.util.Random;

import static factories.StringFactory.populate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by devinmcgloin on 1/30/16.
 */
public class QueueTest {
    private Sequence<String> seq;
    private PriorityQueue<String> priorityQueue;
    private Random r;

    @Before
    public void setUp() throws Exception {
        r = new Random();
        seq = new Sequence<>(Seq.TYPE.QUEUE);
        priorityQueue = new PriorityQueue<>();
        populate(seq, 5, "");
        populate(priorityQueue, 5, "");
    }


    @Test
    public void testRemove() throws Exception {
        assertThat(seq.get(0), is(priorityQueue.peek()));
    }


    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testContains() throws Exception {

    }

    @Test
    public void testContainsAll() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {

    }

    @Test
    public void testIterator() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testAddAll() throws Exception {

    }

    @Test
    public void testToArray() throws Exception {

    }

    @Test
    public void testToArray1() throws Exception {

    }

    @Test
    public void testRemoveAll() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testHashCode() throws Exception {

    }

    @Test
    public void testParallelStream() throws Exception {

    }

    @Test
    public void testRemoveIf() throws Exception {

    }

    @Test
    public void testRetainAll() throws Exception {

    }

    @Test
    public void testSize() throws Exception {

    }
}