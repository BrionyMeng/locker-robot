package util;

import exception.LockerIsFullException;

import java.util.List;

public class  PrimaryRobot {
    private List<Locker> lockers;

    public PrimaryRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket storeBag(Bag myBag) {
        for (Locker locker:lockers){
            if (!locker.isFull()) {
                return locker.storeBag(myBag);
            }
        }
        throw new LockerIsFullException();
    }

    public Bag pickUp(Ticket ticket) {
        for (Locker locker:lockers){
            if (locker.contains(ticket)){
                return locker.pickUp(ticket);
            }
        }
        return null;
    }
}
