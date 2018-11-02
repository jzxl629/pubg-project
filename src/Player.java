//This class represents the players in the game
public class Player {


    private int sfs;//seconds from start
    private Coordinate location;//last recorded coordinate of the payer
    private int distSafe;

    private int weapon1;//0= no weapon, 1 = pistol, 2 = SMG, 3 = shotgun, 4 = rifle, 5 = sniper
    private int weapon2;//0= no weapon, 1 = pistol, 2 = SMG, 3 = shotgun, 4 = rifle, 5 = sniper

    //Stores the amount of ammo1
    private int ammo1;

    //Stores the amount of ammo2
    private int ammo2;

    //Stores the number of bandages
    private int bandage;

    //Stores the number of medkits
    private int medkit;

    //Stores the number of firstkits
    private int firstkit;

    //Stores the number of energy drink + painkiller
    private int drinks;

    //Stores the boolean of whether a player has a vehicle
    private boolean vehicle;

    //Returns seconds from start
    public int getSfs() {
        return sfs;
    }

    //Sets second from start
    public void setSfs(int sfs) {
        this.sfs = sfs;
    }

    //Returns the player's location in the game
    public Coordinate getLocation() {
        return location;
    }

    //Sets players' location
    public void setLocation(Coordinate location) {
        this.location = location;
    }

    //Returns the distance to safe zone
    public int getDistSafe() {
        return distSafe;
    }

    //Sets the distance to safe zone
    public void setDistSafe(int distSafe) {
        this.distSafe = distSafe;
    }

    //Returns type of weapon1 of the user
    public int getWeapon1() {
        return weapon1;
    }

    //Sets type of weapon1
    public void setWeapon1(int weapon1) {
        this.weapon1 = weapon1;
    }

    //Returns type of weapon2
    public int getWeapon2() {
        return weapon2;
    }

    //Sets type of weapon2
    public void setWeapon2(int weapon2) {
        this.weapon2 = weapon2;
    }

    //Returns amount of ammo1
    public int getAmmo1() {
        return ammo1;
    }

    //Sets amount of ammo1
    public void setAmmo1(int ammo1) {
        this.ammo1 = ammo1;
    }

    //Returns amount of ammo2
    public int getAmmo2() {
        return ammo2;
    }

    //Sets amount of ammo2
    public void setAmmo2(int ammo2) {
        this.ammo2 = ammo2;
    }

    //Returns amount of bandage
    public int getBanddage() {
        return bandage;
    }

    //Sets the amount of bandage
    public void setBanddage(int banddage) {
        this.bandage = banddage;
    }

    //Returns the amount of medkit
    public int getMedkit() {
        return medkit;
    }

    //Sets the amount of medkit
    public void setMedkit(int medkit) {
        this.medkit = medkit;
    }

    //Returns the amount of firstkit
    public int getFirstkit() {
        return firstkit;
    }

    //Sets the amount of firstkit
    public void setFirstkit(int firstkit) {
        this.firstkit = firstkit;
    }

    //Returns the amount of drinks
    public int getDrinks() {
        return drinks;
    }

    //Sets the amount of drinks
    public void setDrinks(int drinks) {
        this.drinks = drinks;
    }

    //A boolean that will return true if users have a vehicle
    public boolean isVehicle() {
        return vehicle;
    }

    //Sets if users have a vehicle
    public void setVehicle(boolean vehicle) {
        this.vehicle = vehicle;
    }
}
