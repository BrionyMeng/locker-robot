package util;

public interface Storable {
    Ticket storeBag(Bag bag);

    Bag pickUp(Ticket ticket);

    boolean isFull();
}
