package util;

import exception.LockerIsFullException;

import java.util.ArrayList;
import java.util.List;

public class Locker {
    private int capacity;
    private int availableCapacity;

    public Locker(int capacity) {
        this.capacity = capacity;
        this.availableCapacity=capacity;
    }

    public Ticket storeBag(Bag bag) {
        if (availableCapacity<=0) {
            throw new LockerIsFullException();
        }
        availableCapacity--;
        return new Ticket();
    }

    private List<Grid> findEmptyGrid() {
        List<Grid> emptyGrid=new ArrayList<>();
        Grid testGrid=new Grid(1);
        emptyGrid.add(testGrid);
        return emptyGrid;
    }
}
