public class SafeZone {
    private Coordinate center;
    private double radius;
    private int state;
    public SafeZone(){
        state = 0;
    }
    public void input(Coordinate input){
        if(state == 0){
            center = input;
            state = 1;
            return;
        }
        if(state == 1){
            radius = input.distanceTo(center);
            state = 2;
            return;
        }
        if(state == 2){
            center = input;
            radius = 0.0;
            state = 1;
            return;
        }
    }
    public Coordinate getCenter() {
        return center;
    }

    public void setCenter(Coordinate center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
