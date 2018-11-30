public class FlightPath {
    private int state;
    private Coordinate c1;
    private Coordinate c2;



    public FlightPath(){
        state = 0;
    };
    public Coordinate getC1() {
        return c1;
    }

    public void setC1(Coordinate c1) {
        this.c1 = c1;
    }

    public Coordinate getC2() {
        return c2;
    }

    public void setC2(Coordinate c2) {
        this.c2 = c2;
    }
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void addCoor(Coordinate c){
        if(state == 0){
            c1 = c;
            state++;
            return;
        }
        if(state == 1){
            c2 = c;
            state++;
            return;
        }
        if(state == 2){
            c1 = c;
            c2 = null;
            state = 1;
            return;
        }
    }
}
