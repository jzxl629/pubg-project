public class Player {
    int sfs;//seconds from start
    Coordinate location;//last recorded coordinate of the payer
    int distSafe;

    int weapon1;//0= no weapon, 1 = pistol, 2 = SMG, 3 = shotgun, 4 = rifle, 5 = sniper
    int weapon2;//0= no weapon, 1 = pistol, 2 = SMG, 3 = shotgun, 4 = rifle, 5 = sniper
    int ammo1;
    int ammo2;
    int banddage;
    int medkit;
    int firstkit;
    int drinks;
    boolean vehicle;

    public int getSfs() {
        return sfs;
    }

    public void setSfs(int sfs) {
        this.sfs = sfs;
    }

    public Coordinate getLocation() {
        return location;
    }

    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public int getDistSafe() {
        return distSafe;
    }

    public void setDistSafe(int distSafe) {
        this.distSafe = distSafe;
    }

    public int getWeapon1() {
        return weapon1;
    }

    public void setWeapon1(int weapon1) {
        this.weapon1 = weapon1;
    }

    public int getWeapon2() {
        return weapon2;
    }

    public void setWeapon2(int weapon2) {
        this.weapon2 = weapon2;
    }

    public int getAmmo1() {
        return ammo1;
    }

    public void setAmmo1(int ammo1) {
        this.ammo1 = ammo1;
    }

    public int getAmmo2() {
        return ammo2;
    }

    public void setAmmo2(int ammo2) {
        this.ammo2 = ammo2;
    }

    public int getBanddage() {
        return banddage;
    }

    public void setBanddage(int banddage) {
        this.banddage = banddage;
    }

    public int getMedkit() {
        return medkit;
    }

    public void setMedkit(int medkit) {
        this.medkit = medkit;
    }

    public int getFirstkit() {
        return firstkit;
    }

    public void setFirstkit(int firstkit) {
        this.firstkit = firstkit;
    }

    public int getDrinks() {
        return drinks;
    }

    public void setDrinks(int drinks) {
        this.drinks = drinks;
    }

    public boolean isVehicle() {
        return vehicle;
    }

    public void setVehicle(boolean vehicle) {
        this.vehicle = vehicle;
    }
}
