package util;

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
}
