package util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PrimaryRobotTest {
    @Test
    void should_return_ticket_of_1st_locker_when_store_bag_given_robot_manages_two_available_lockers() {
        Locker firstLocker=new Locker(6);
        PrimaryRobot robot= new PrimaryRobot(Arrays.asList(firstLocker,new Locker(10)));

        Bag myBag=new Bag();
        Ticket ticket=robot.storeBag(myBag);

        assertNotNull(ticket);
        assertSame(myBag, firstLocker.pickUp(ticket));
    }

    @Test
    void should_return_ticket_of_2nd_locker_when_store_bag_given_robot_manages_two_available_lockers_and_the_first_locker_is_full() {
        Locker secondLocker = new Locker(10);
        PrimaryRobot robot= new PrimaryRobot(Arrays.asList(new Locker(1), secondLocker));
        robot.storeBag(new Bag());

        Bag myBag=new Bag();
        Ticket ticket=robot.storeBag(myBag);

        assertNotNull(ticket);
        assertSame(myBag, secondLocker.pickUp(ticket));
    }
}
