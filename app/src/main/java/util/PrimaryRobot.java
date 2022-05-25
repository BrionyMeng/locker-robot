package util;

import java.util.List;

public class  PrimaryRobot {
    private List<Locker> lockers;

    public PrimaryRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket storeBag(Bag myBag) {
        return lockers.get(0).storeBag(myBag);
    }
}
