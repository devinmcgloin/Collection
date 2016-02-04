package funct;

import java.util.Comparator;

/**
 * Created by devinmcgloin on 1/31/16.
 */
public abstract class DatedComparator<E> implements Comparator<E> {

    private long time;
    private long duration = 0;
    private double lengthMin = 15;
    private boolean durable = false;


    public DatedComparator() {
        time = System.currentTimeMillis();
        duration = (int) Math.ceil(lengthMin * 60000);
    }

    public boolean isExpired() {
        if (durable)
            return false;
        else return System.currentTimeMillis() - time >= duration;
    }

    public void setLength(double min) {
        lengthMin = min;
        duration = (int) Math.ceil(lengthMin * 60000);
    }

    public void durable() {
        durable = true;
    }

    public void extend() {
        time = System.currentTimeMillis();
    }

    public abstract int compare(E o1, E o2);

}
