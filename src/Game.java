public class Game {

    //Stores the second from start
    private int sfs;

    //Stores the coordinate of the safe center
    Coordinate safeCenter;

    //Stores the radius of the circle
    private int radius;

    //Returns second from start
    public int getSfs() {
        return sfs;
    }

    //Sets second from start
    public void setSfs(int sfs) {
        this.sfs = sfs;
    }

    public Game() {
        //todo
    }

    //Gets the coordinate of the safe center
    public Coordinate getSafeCenter() {
        return safeCenter;
    }

    //Sets the coordinate of the safe center
    public void setSafeCenter(Coordinate safeCenter) {
        this.safeCenter = safeCenter;
    }

    //Returns time until the next shrink
    public int getTimeToNextShrink(){
        //todo
        return 0;
    }
}
