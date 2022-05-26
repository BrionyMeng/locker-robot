package util;

import exception.InvalidTicketException;
import exception.LockerIsFullException;

import java.util.HashMap;

public class Locker implements Storable{
    private int capacity;

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    private int availableCapacity;
    private final HashMap<Ticket,Bag> storedBags=new HashMap<>();

    public Locker(int capacity) {
        this.capacity = capacity;
        this.availableCapacity=capacity;
    }

    @Override
    public Ticket storeBag(Bag bag) {
        if (availableCapacity<=0) {
            throw new LockerIsFullException();
        }
        Ticket ticket=new Ticket();
        storedBags.put(ticket,bag);
        availableCapacity--;
        return ticket;
    }

    @Override
    public Bag pickUp(Ticket ticket) {
        Bag bag=storedBags.remove(ticket);
        if (bag==null) throw new InvalidTicketException();
        return bag;
    }

    @Override
    public boolean isFull(){
        return availableCapacity==0;
    }

    public Boolean contains(Ticket ticket) {
        return storedBags.containsKey(ticket);
    }
}
