import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

//Tests the flight path
public class FlightPathTest {
    @Test
    public void testFlightPath() {
        FlightPath path = new FlightPath();
        //The initial coordinate is 0, 0
        Coordinate c1 = new Coordinate(0, 0);
        //The second coordinate of the flight path
        Coordinate c2 = new Coordinate(60, 400);
        path.setC1(c1);
        path.setC2(c2);

        assertEquals(0, path.getC1().getX(), 0.1);
        assertEquals(0, path.getC1().getY(), 0.1);
        assertEquals(60, path.getC2().getX(), 0.1);
        assertEquals(400, path.getC2().getY(), 0.1);
        assertEquals(0, path.getState(), 0.1);

        path.setState(2);
        assertEquals(2, path.getState(), 0.1);

        Coordinate c3 = new Coordinate(1000, 1000);
        Coordinate c4 = new Coordinate(500, 600);
        Coordinate c5 = new Coordinate(70, 50);

        path.addCoor(c3);

        assertEquals(1, path.getState(), 0.1);
        assertEquals(1000, path.getC1().getX(), 0.1);
        assertEquals(1000, path.getC1().getY(), 0.1);

        path.addCoor(c4);
        assertEquals(2, path.getState(), 0.1);
        assertEquals(500, path.getC2().getX(), 0.1);
        assertEquals(600, path.getC2().getY(), 0.1);

        path.addCoor(c5);
        assertEquals(1, path.getState(), 0.1);
        assertEquals(70, path.getC1().getX(), 0.1);
        assertEquals(50, path.getC1().getY(), 0.1);
        assertEquals(null, path.getC2());
    }
}