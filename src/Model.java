import java.util.Arrays;
import java.util.Comparator;

//Represents the support system
public class Model {

    //Initializes a player and a game
    Player player = new Player();
    Game game = new Game();

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
        for(Objective o:objectives){
            output += o.toString();
        }
        return output;
    }
}
