import attractions.*;
import behaviours.IReviewed;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;

public class ThemeParkTest {

    private ThemePark themePark;
    private Dodgems dodgems;
    private Park park;
    private Playground playground;
    private RollerCoaster rollerCoaster;
    private CandyflossStall candyflossStall;
    private IceCreamStall iceCreamStall;
    private TobaccoStall tobaccoStall;
    private Visitor visitor;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("1", 1);
        park = new Park("3", 1);
        playground = new Playground("d", 3);
        rollerCoaster = new RollerCoaster("d", 3);
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(dodgems);
        attractions.add(park);
        attractions.add(playground);
        attractions.add(rollerCoaster);
        candyflossStall = new CandyflossStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 5);
        iceCreamStall = new IceCreamStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 5);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 5);
        ArrayList<Stall> stalls = new ArrayList<>();
        stalls.add(candyflossStall);
        stalls.add(iceCreamStall);
        stalls.add(tobaccoStall);
        themePark = new ThemePark();

        themePark.setAttractions(attractions);
        themePark.setStalls(stalls);

        visitor = new Visitor(18, 1.52, 40.0);
    }

    @Test
    public void canTakeArrayListOfAllowedPlaces() {
        ArrayList<IReviewed> actualAllowedPlaces = themePark.getAllAllowedFor(visitor);
        ArrayList<IReviewed> expectedAllowedPlaces = new ArrayList<>();
        expectedAllowedPlaces.add((IReviewed) dodgems);
        expectedAllowedPlaces.add((IReviewed) park);
        expectedAllowedPlaces.add((IReviewed) rollerCoaster);
        expectedAllowedPlaces.add((IReviewed) candyflossStall);
        expectedAllowedPlaces.add((IReviewed) iceCreamStall);
        expectedAllowedPlaces.add((IReviewed) tobaccoStall);
        Assert.assertEquals(expectedAllowedPlaces, actualAllowedPlaces);
    }
}
