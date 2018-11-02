public class Game {
    int sfs;
    Coordinate safeCenter;
    int radius;

    public int getSfs() {
        return sfs;
    }
    public void setSfs(int sfs) {
        this.sfs = sfs;
    }

    public Game() {
        //todo
    }

    public Coordinate getSafeCenter() {
        return safeCenter;
    }

    public void setSafeCenter(Coordinate safeCenter) {
        this.safeCenter = safeCenter;
    }

    public int getTimeToNextShrink(){
        //todo
        return 0;
    }
}
