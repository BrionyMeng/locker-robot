package locker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LockerTest {
    @Test
    void should_pass_test() {
        assertEquals(1, 1);
    }

    @Test
    void should_return_ticket_when_store_bag_given_empty_grids_left() {
        // given
        Locker locker = new Locker(30);

        // when
        Ticket ticket = locker.storeBag();

        // then
        assertFalse(ticket.ticketId.isEmpty());
    }
}
