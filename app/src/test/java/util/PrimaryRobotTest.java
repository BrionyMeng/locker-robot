package util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PrimaryRobotTest {
    @Test
    void should_return_ticket_of_1st_locker_when_store_bag_given_robot_is_manage_two_available_lockers() {
        Locker firstLocker=new Locker(6);
        PrimaryRobot robot= new PrimaryRobot(Arrays.asList(firstLocker,new Locker(10)));

        Bag myBag=new Bag();
        Ticket ticket=robot.storeBag(myBag);

        assertNotNull(ticket);
        assertSame(myBag, firstLocker.pickUp(ticket));
    }
}
