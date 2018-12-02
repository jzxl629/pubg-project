public class Game {
    //given game constants
    int[] shrinkTimes = {420,620,770,890,1010,1100,1190,1250};
    int[] diamaters = {4564,2967,1483,741,370,185,92,46};
    double[] dmgPerRing = {.4,.6,.8,1.0,3.0,5.0,7.0,9.0};





    public Model model;
    public GUI gui;
    //Stores the second from start
    private FlightPath flightPath;
    private SafeZone safeZone;
    private int sfs;
    //Stores the coordinate of the safe center
    Coordinate safeCenter;
    int scs = 0;
    //Stores the radius of the circle
    private int radius;

    public FlightPath getFlightPath() {
        return flightPath;
    }

    public void setFlightPath(FlightPath flightPath) {
        this.flightPath = flightPath;
    }

    public SafeZone getSafeZone() {
        return safeZone;
    }

    public void setSafeZone(SafeZone safeZone) {
        this.safeZone = safeZone;
    }

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
        flightPath = new FlightPath();
        safeZone = new SafeZone();
    }
    public void addToFlightPath(Coordinate c){
        flightPath.addCoor(c);
        if(flightPath.getState() == 2){
            //todo
        }
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

    public int getCircleRadius(){
        return 0;

    }
}
