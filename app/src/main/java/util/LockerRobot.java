package util;

import exception.InvalidTicketException;

public abstract class LockerRobot {
    protected final Locker[] lockers;

    public LockerRobot(Locker... lockers) {
        this.lockers = lockers;
    }

    public abstract Ticket storeBag(Bag bag);

    public Bag pickUp(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.contains(ticket)) {
                return locker.pickUp(ticket);
            }
        }
        throw new InvalidTicketException();
    }
}
