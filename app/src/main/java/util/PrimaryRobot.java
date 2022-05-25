package util;

import exception.InvalidTicketException;
import exception.LockerIsFullException;

import java.util.ArrayList;
import java.util.List;

public class  PrimaryRobot {
    private List<Locker> lockers=new ArrayList<>();

    public PrimaryRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public PrimaryRobot(Locker... lockers) {
        for (Locker locker : lockers) {
            this.lockers.add(locker);
        }
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
        throw new InvalidTicketException();
    }
}
