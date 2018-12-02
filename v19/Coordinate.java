//This class represents the coordinate of an object in the game
public class Coordinate {

    //Stores the x coordinate of the object
    private int x;

    //Stores the y coordinate of the object
    private int y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return("x: " + this.x + "y: " + this.y);
    }

    //Returns the x coordinate
    public int getX() {
        return x;
    }

    //Sets the x coordinate
    public void setX(int x) {
        this.x = x;
    }

    //Returns the y coordinate
    public int getY() {
        return y;
    }

    //Sets the y coordinate
    public void setY(int y) {
        this.y = y;
    }

    public double distanceTo(Coordinate c){
        int dx = this.x - c.getX();
        int dy = this.y - c.getY();
        double distance = Math.sqrt(1.0*((dx*dx)+(dy*dy)));
        return distance;
    }


}
