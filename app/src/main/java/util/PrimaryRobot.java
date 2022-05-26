package util;

import exception.LockerIsFullException;

public class  PrimaryRobot extends LockerRobot {

    public PrimaryRobot(Locker... lockers) {super (lockers);}

    public Ticket storeBag(Bag myBag) {
        for (Locker locker:lockers){
            if (!locker.isFull()) {
                return locker.storeBag(myBag);
            }
        }
        throw new LockerIsFullException();
    }
}
