package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {
    Visitor visitor;
    Dodgems dodgems;

    @Before
    public void setUp() throws Exception {
        visitor = new Visitor(11, 145, 20);
        dodgems = new Dodgems("Bumper Cars", 5);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void visitorOverLessThan12PaysHalf() {
        assertEquals((4.50 / 2), dodgems.priceFor(visitor), 0.0);
    }
}
