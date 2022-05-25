package util;

import exception.LockerIsFullException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class SmartRobotTest {
    @Test
    void should_store_bag_to_1st_locker_when_robot_store_bag_given_1st_locker_available_capacity_is_3_and_2nd_locker_is_2() {
        Locker firstLocker = new Locker(3);
        Locker secondLocker = new Locker(2);
        SmartRobot robot = new SmartRobot(firstLocker, secondLocker);

        Bag bagStored = new Bag();
        Ticket ticket = robot.storeBag(bagStored);

        assertSame(bagStored, firstLocker.pickUp(ticket));
    }

    @Test
    void should_store_bag_to_2nd_locker_when_robot_store_bag_given_1st_locker_available_capacity_is_2_and_2nd_locker_is_3() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(3);
        SmartRobot robot = new SmartRobot(firstLocker, secondLocker);

        Bag bagStored = new Bag();
        Ticket ticket = robot.storeBag(bagStored);

        assertSame(bagStored, secondLocker.pickUp(ticket));
    }

    @Test
    void should_store_bag_to_1st_locker_when_robot_store_bag_given_lockers_have_same_available_capacity() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(2);
        SmartRobot robot = new SmartRobot(firstLocker, secondLocker);

        Bag bagStored = new Bag();
        Ticket ticket = robot.storeBag(bagStored);

        assertSame(bagStored, firstLocker.pickUp(ticket));
    }

    @Test
    void should_throw_LockerIsFullException_when_robot_store_bag_given_lockers_are_full() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        SmartRobot robot = new SmartRobot(firstLocker, secondLocker);
        robot.storeBag(new Bag());
        robot.storeBag(new Bag());

        Assertions.assertThrows(LockerIsFullException.class, () -> robot.storeBag(new Bag()));
    }

    @Test
    void should_get_the_bag_when_smart_robot_pick_up_bag_given_a_valid_ticket_from_primary_robot() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        SmartRobot smartRobot = new SmartRobot(firstLocker, secondLocker);
        PrimaryRobot primaryRobot = new PrimaryRobot(firstLocker, secondLocker);
        Bag bagStored = new Bag();
        Ticket ticket = primaryRobot.storeBag(bagStored);

        Bag bagPickedUp = smartRobot.pickUp(ticket);

        assertSame(bagStored, bagPickedUp);
    }

    @Test
    void should_get_the_bag_when_smart_robot_pick_up_bag_given_a_valid_ticket_from_smart_robot() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        SmartRobot smartRobot = new SmartRobot(firstLocker, secondLocker);
        Bag bagStored = new Bag();
        Ticket ticket = smartRobot.storeBag(bagStored);

        Bag bagPickedUp = smartRobot.pickUp(ticket);

        assertSame(bagStored, bagPickedUp);
    }

    @Test
    void should_get_the_bag_when_primary_robot_pick_up_bag_given_a_valid_ticket_from_smart_robot() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        SmartRobot smartRobot = new SmartRobot(firstLocker, secondLocker);
        PrimaryRobot primaryRobot = new PrimaryRobot(firstLocker, secondLocker);
        Bag bagStored = new Bag();
        Ticket ticket = smartRobot.storeBag(bagStored);

        Bag bagPickedUp = primaryRobot.pickUp(ticket);

        assertSame(bagStored, bagPickedUp);
    }
}
