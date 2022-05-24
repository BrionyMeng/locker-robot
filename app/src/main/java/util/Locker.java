package util;

import exception.InvalidTicketException;
import exception.LockerIsFullException;

import java.util.HashMap;

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

    public Bag pickUp(Ticket ticket) {
        Bag bag=storedBags.remove(ticket);
        if (bag==null) throw new InvalidTicketException();
        return bag;
    }
}
