package util;

public class SmartRobot extends LockerRobot {

    public SmartRobot(Locker... lockers) {
        super(lockers);
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

}
