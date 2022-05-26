package util;

import exception.LockerIsFullException;

import java.util.List;

public class LockerRobotManager {

    private final List<Storable> storables;

    public LockerRobotManager(List<Storable> storables) {
        this.storables = storables;
    }

    public Ticket storeBag(Bag bag) {
        for (Storable storable : storables) {
           if(!storable.isFull()){
               return storable.storeBag(bag);
           }
        }
        throw new LockerIsFullException();
    }

    public Bag pickUp(Ticket ticket) {
        return storables.get(0).pickUp(ticket);
    }
}
