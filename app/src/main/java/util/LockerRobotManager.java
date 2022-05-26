package util;

import exception.LockerIsFullException;

import java.util.List;

public class LockerRobotManager {

    private final List<Locker> lockers;
    private final List<LockerRobot> robots;

    public LockerRobotManager(List<Locker> lockers, List<LockerRobot> robots) {
        this.lockers = lockers;
        this.robots = robots;
    }

    public Ticket storeBag(Bag bag) {
        for (Locker locker : lockers) {
            if (!locker.isFull()) {
                return locker.storeBag(bag);
            }
        }
        throw new LockerIsFullException();
    }
}
