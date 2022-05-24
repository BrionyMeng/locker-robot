package util;

import exception.LockerIsFullException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LockerTest {
    @Test
    void should_return_ticket_when_store_bag_given_empty_grids_left() {
        Locker locker = new Locker(30);

        Ticket ticket = locker.storeBag(new Bag());

        assertNotNull(ticket);
    }

    @Test
    void should_throw_LockerIsFullException_when_store_bag_given_no_available_capacity() {
        Locker locker = new Locker(1);

        locker.storeBag(new Bag());

        Assertions.assertThrows(LockerIsFullException.class, () -> {
            locker.storeBag(new Bag());
        });
    }

    @Test
    void should_get_bag_when_pick_up_given_valid_ticket() {
        Locker locker = new Locker(1);
        Bag bagStored = new Bag();
        Ticket ticket = locker.storeBag(bagStored);

        Bag bagPickedUp = locker.pickUp(ticket);

        assertSame(bagPickedUp, bagStored);
    }


}
