package util;

import exception.LockerIsFullException;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerRobotManagerTest {
    @Test
    void should_return_ticket_saved_in_1st_locker_when_save_bag_given_manager_has_two_lockers_with_capacity_and_no_robot() {
        Locker firstLocker = new Locker(1);
        LockerRobotManager manager = new LockerRobotManager(asList(firstLocker, new Locker(2)), emptyList());

        Bag bagStored = new Bag();
        Ticket ticket = manager.storeBag(bagStored);

        assertNotNull(ticket);
        assertSame(bagStored, firstLocker.pickUp(ticket));
    }

    @Test
    void should_return_ticket_saved_in_2nd_locker_when_save_bag_given_manager_has_two_lockers_1st_is_full_2nd_is_available_and_no_robot() {
        Locker secondLocker = new Locker(2);
        LockerRobotManager manager = new LockerRobotManager(asList(new Locker(1), secondLocker), emptyList());
        manager.storeBag(new Bag());

        Bag bagStored = new Bag();
        Ticket ticket = manager.storeBag(bagStored);

        assertNotNull(ticket);
        assertSame(bagStored, secondLocker.pickUp(ticket));
    }

    @Test
    void should_throw_LockerIsFullException_when_save_bag_given_manager_has_two_full_lockers_and_no_robot() {
        LockerRobotManager manager = new LockerRobotManager(asList(new Locker(1), new Locker(1)), emptyList());
        manager.storeBag(new Bag());
        manager.storeBag(new Bag());

        assertThrows(LockerIsFullException.class, () -> manager.storeBag(new Bag()));
    }

    @Test
    void should_return_ticket_by_1st_robot_when_save_bag_given_manager_has_no_locker_and_2_robots() {
        PrimaryRobot firstRobot = new PrimaryRobot(new Locker(1));
        LockerRobotManager manager = new LockerRobotManager(emptyList(), asList(firstRobot, new PrimaryRobot(new Locker(1))));

        Bag bagStored = new Bag();
        Ticket ticket = manager.storeBag(bagStored);

        assertNotNull(ticket);
        assertSame(bagStored, firstRobot.pickUp(ticket));
    }

    @Test
    void should_return_ticket_by_2nd_robot_when_save_bag_given_manager_has_no_locker_and_2_robots_and_1st_robot_is_full() {
        PrimaryRobot secondRobot = new PrimaryRobot(new Locker(1));
        LockerRobotManager manager = new LockerRobotManager(emptyList(), asList(new PrimaryRobot(new Locker(1)), secondRobot));
        manager.storeBag(new Bag());

        Bag bagStored = new Bag();
        Ticket ticket = manager.storeBag(bagStored);

        assertNotNull(ticket);
        assertSame(bagStored, secondRobot.pickUp(ticket));
    }
}
