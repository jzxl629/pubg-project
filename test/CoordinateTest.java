import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {
    //Test the getX() and getY() function in Coordinate class
    @Test
    public void testGetCoordinate() {
        Coordinate co1 = new Coordinate(50, 60);
        Coordinate co2 = new Coordinate(0, 0);
        Coordinate co3 = new Coordinate(1000,600);

        assertEquals(50, co1.getX(), 0.1,"The x coordinate is 50");
        assertEquals(60, co1.getY(), 0.1, "The y coordinate is 60");
        assertEquals(0, co2.getX(), 0.1,"The x coordinate is 0");
        assertEquals(0, co2.getY(), 0.1, "The y coordinate is 0");
        assertEquals(1000, co3.getX(), 0.1,"The x coordinate is 1000");
        assertEquals(600, co3.getY(), 0.1, "The y coordinate is 600");
    }

    //Test the setX() and setY() function in Coordinate class
    @Test
    public void testSetCoordinate() {
        Coordinate co1 = new Coordinate(0, 0);
        Coordinate co2 = new Coordinate(0, 0);
        Coordinate co3 = new Coordinate(0, 0);

        co1.setX(50);
        co2.setX(30);
        co2.setX(0);
        co3.setX(1000);

        co1.setY(75);
        co2.setY(45);
        co2.setY(0);
        co3.setY(600);


        assertEquals(50, co1.getX(), 0.1,"The x coordinate is 50");
        assertEquals(75, co1.getY(), 0.1, "The y coordinate is 0");
        assertEquals(0, co2.getX(), 0.1,"The x coordinate is 0");
        assertEquals(0, co2.getY(), 0.1, "The y coordinate is 0");
        assertEquals(1000, co3.getX(), 0.1,"The x coordinate is 1000");
        assertEquals(600, co3.getY(), 0.1, "The y coordinate is 600");
    }

}