import java.util.Arrays;
import java.util.Comparator;

//Represents the support system
public class Model {

    //Initializes a player and a game
    Player player = new Player();
    Game game = new Game();
    GUI gui;

    //Stores the amount of objects
    private final int objCount = 7;

    private final String[] objsnames = {"Reach Safe Zone","Reposition","Loot Ammo","Loot Meds","Find Vehicle","Find Sniper","Find Rifle"};
    private Objective[] objectives = new Objective[objCount];
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void Model(){
        for(int i = 0; i<objCount;i++){
            objectives[i] = new Objective(objsnames[i]);
        }
        game.gui = gui;
    }
    public void calculatePriorities(){
        //todo
        //"Reach Safe Zone","Reposition","Loot Ammo","Loot Meds","Find Vehicle","Find Sniper","Find Rifle"
        //safe zone formula = sigmoid(distance to safezone)
        //double p0 =

        //Reposition
    }
    public void calculateRandomPriorities(){
        for(int i = 0; i<objCount; i++){
            objectives[i] = new Objective(objsnames[i]);
            objectives[i].setPriority(Math.random());
        }
    }

    public void sortPriorties(){
        Comparator<Objective> myComparator = new Comparator<Objective>() {
            @Override
            public int compare(Objective o1, Objective o2) {
                if(o1.getPriority()>o2.getPriority())return -1;
                return 1;
            }
        };
        Arrays.sort(objectives, myComparator);
    }
    public void printPriorities(){
        for(Objective o:objectives){
            System.out.println(o);
        }
    }
    public void printOrderedPriorities(){
        for(Objective o:objectives){
            System.out.println(o);
        }
    }

    @Override
    public String toString(){
        String output = "Player State: \n";
        output += "Player Weapon 1 ammo count: " + player.getAmmo1() + "\n";
        output += "Player Weapon 2 ammo count; " + player.getAmmo2() + "\n";
        output += "Player has Vehicle: ";
        output += player.isVehicle()? "true" : "false";
        return output;
    }
    public String objToString() {
        String output = "";
        output += "Player at: " + player.getLocation() + "\n";
        output += "Safe Zone at: " + game.getSafeZone() + "\n";
        output += "Distance to safezone: " + distanceToSafe() + "m" + "\n";
        output += "First Aid Needed" + medNeededToSafe() + "\n";
        output += "Straight Line runtime to SafeZone" + lineWalktimeToSafe() + "s" + "\n";

        for(Objective o:objectives){
            output += o.toString();
        }
        return output;
    }
    public int distanceToSafe(){//600 * 600 -> 8000 * 8000
        int distance = (int)((player.getLocation().distanceTo(game.getSafeZone().getCenter())-game.getSafeZone().getRadius())*80/6);
        if(distance<0) return 0;
        return distance;
    }
    public int lineWalktimeToSafe(){
        int seconds = (int)(distanceToSafe()/6.2);
        return seconds;
    }
    public int currentCircle(){
        int seconds = game.getSfs();
        int output = 0;
        while(game.shrinkTimes[output]<seconds){
            output++;
        }
        return output;
    }
    public int medNeededToSafe(){
        double dps = game.dmgPerRing[currentCircle()];
        int maxHeal = 75 - (int)dps*6;
        if(maxHeal<0){
            return -1;
        }
        if(distanceToSafe() == 0){
            return 0;
        }
        int travel = (int)((100/dps)*6.2);
        int togo = distanceToSafe()-travel;
        int distanceperMed = (int)(maxHeal/dps * 6.2);
        return (int)(togo/distanceperMed)+1;
    }
}
