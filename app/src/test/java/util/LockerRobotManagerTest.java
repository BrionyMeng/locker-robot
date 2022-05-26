package util;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class LockerRobotManagerTest {
    @Test
    void should_return_ticket_save_in_1st_locker_when_save_bag_given_manager_has_two_lockers_with_capacity_and_no_robot() {
        Locker firstLocker = new Locker(1);
        LockerRobotManager manager = new LockerRobotManager(asList(firstLocker, new Locker(2)), emptyList());

        Bag bagStored = new Bag();
        Ticket ticket= manager.storeBag(bagStored);

        assertNotNull(ticket);
        assertSame(bagStored,firstLocker.pickUp(ticket));
    }
}
