package util;

public class SmartRobot {
    private final Locker[] lockers;

    public SmartRobot(Locker... lockers) {

        this.lockers = lockers;
    }

    public Ticket storeBag(Bag bag) {
        return lockers[0].storeBag(bag);
    }
}
