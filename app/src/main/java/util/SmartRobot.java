package util;

public class SmartRobot {
    private final Locker[] lockers;

    public SmartRobot(Locker... lockers) {
        this.lockers = lockers;
    }

    public Ticket storeBag(Bag bag) {
        return getMaxAvailableCapacityLocker().storeBag(bag);
    }

    private Locker getMaxAvailableCapacityLocker() {
        int maxAvailableCapacity=lockers[0].getAvailableCapacity();
        Locker maxAvailableCapacityLocker=lockers[0];
        for (Locker locker : lockers) {
            if (locker.getAvailableCapacity()>maxAvailableCapacity){
                maxAvailableCapacity=locker.getAvailableCapacity();
                maxAvailableCapacityLocker=locker;
            }
        }
        return maxAvailableCapacityLocker;
    }

    public Bag pickUp(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.contains(ticket)) {
                return locker.pickUp(ticket);
            }
        }
        return null;
    }
}
