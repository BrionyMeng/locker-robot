package util;

import exception.InvalidTicketException;

import java.util.Arrays;
import java.util.List;


public abstract class LockerRobot implements Storable{
    protected final Locker[] lockers;

    public LockerRobot(Locker... lockers) {
        this.lockers = lockers;
    }

    @Override
    public abstract Ticket storeBag(Bag bag);

    @Override
    public Bag pickUp(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.contains(ticket)) {
                return locker.pickUp(ticket);
            }
        }
        throw new InvalidTicketException();
    }

    @Override
    public boolean isFull() {
        return Arrays.stream(lockers).allMatch(Locker::isFull);
    }

    @Override
    public boolean contains(Ticket ticket){
        return Arrays.stream(lockers).anyMatch(locker -> locker.contains(ticket));
    }

    @Override
    public int getAvailableCapacity() {
        return Arrays.stream(lockers).mapToInt(Locker::getAvailableCapacity).sum();
    }

    @Override
    public int getCapacity() {
        return Arrays.stream(lockers).mapToInt(Locker::getCapacity).sum();
    }

    public List<Locker> getLockers() {
        return List.of(lockers);
    }
}
