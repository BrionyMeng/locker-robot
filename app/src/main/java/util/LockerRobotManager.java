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
        for (LockerRobot robot : robots) {
            if (!robot.isFull()) {
                return robot.storeBag(bag);
            }
        }
        for (Locker locker : lockers) {
            if (!locker.isFull()) {
                return locker.storeBag(bag);
            }
        }
        throw new LockerIsFullException();
    }
}
