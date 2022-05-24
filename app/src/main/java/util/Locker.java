package util;

import exception.LockerIsFullException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Locker {
    private int capacity;
    private int availableCapacity;
    private final HashMap<Ticket,Bag> storedBags=new HashMap<>();

    public Locker(int capacity) {
        this.capacity = capacity;
        this.availableCapacity=capacity;
    }

    public Ticket storeBag(Bag bag) {
        if (availableCapacity<=0) {
            throw new LockerIsFullException();
        }
        Ticket ticket=new Ticket();
        storedBags.put(ticket,bag);
        availableCapacity--;
        return ticket;
    }

    private List<Grid> findEmptyGrid() {
        List<Grid> emptyGrid=new ArrayList<>();
        Grid testGrid=new Grid(1);
        emptyGrid.add(testGrid);
        return emptyGrid;
    }

    public Bag pickUp(Ticket ticket) {
        Bag bag=storedBags.remove(ticket);
        if (bag==null) throw new LockerIsFullException();
        return bag;
    }
}
