import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {


    @Test
    public void testWeapon1() {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        Player player5 = new Player();

        player2.setWeapon1(0);
        player3.setWeapon1(3);
        player4.setWeapon1(2);
        player5.setWeapon1(-4);
        player5.setWeapon1(1);

        assertEquals(0, player1.getWeapon1(), 0.1, "Player1 has no weapon as default");
        assertEquals(0, player2.getWeapon1(), 0.1, "Player2 has a pistol");
        assertEquals(3, player3.getWeapon1(), 0.1, "Player3 has a shotgun");
        assertEquals(2, player4.getWeapon1(), 0.1, "Player3 has a smg");
        assertEquals(1, player5.getWeapon1(), 0.1, "Player3 has a pistol");
    }

    @Test
    public void testWeapon2() {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        Player player5 = new Player();

        player2.setWeapon2(0);
        player3.setWeapon2(3);
        player4.setWeapon2(2);
        player5.setWeapon2(-4);
        player5.setWeapon2(1);

        assertEquals(0, player1.getWeapon2(), 0.1, "Player1 has no weapon as default");
        assertEquals(0, player2.getWeapon2(), 0.1, "Player2 has a pistol");
        assertEquals(3, player3.getWeapon2(), 0.1, "Player3 has a shotgun");
        assertEquals(2, player4.getWeapon2(), 0.1, "Player3 has a smg");
        assertEquals(1, player5.getWeapon2(), 0.1, "Player3 has a pistol");
    }

    @Test
    public void testAmmo1() {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        Player player5 = new Player();

        player1.setAmmo1(100);
        player2.setAmmo1(Integer.MAX_VALUE);
        player3.setAmmo1(0);
        player4.setAmmo1(400);
        player5.setAmmo1(Integer.MIN_VALUE);

        assertEquals(100, player1.getAmmo1(), 0.1, "Player1 has 100 ammo for weapon1");
        assertEquals(Integer.MAX_VALUE, player2.getAmmo1(), 0.1, "Player1 has maximum ammo for weapon1");
        assertEquals(0, player3.getAmmo1(), 0.1, "Player1 has zero ammo for weapon1");
        assertEquals(400, player4.getAmmo1(), 0.1, "Player1 has 400 ammo for weapon1");
        assertEquals(Integer.MIN_VALUE, player5.getAmmo1(), 0.1, "Player1 has minimum ammo for weapon1");
    }

    @Test
    public void Ammo2() {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        Player player5 = new Player();

        player1.setAmmo2(100);
        player2.setAmmo2(Integer.MAX_VALUE);
        player3.setAmmo2(0);
        player4.setAmmo2(400);
        player5.setAmmo2(Integer.MIN_VALUE);

        assertEquals(100, player1.getAmmo2(), 0.1, "Player1 has 100 ammo for weapon2");
        assertEquals(Integer.MAX_VALUE, player2.getAmmo2(), 0.1, "Player1 has maximum ammo for weapon2");
        assertEquals(0, player3.getAmmo2(), 0.1, "Player1 has zero ammo for weapon2");
        assertEquals(400, player4.getAmmo2(), 0.1, "Player1 has 400 ammo for weapon2");
        assertEquals(Integer.MIN_VALUE, player5.getAmmo2(), 0.1, "Player1 has minimum ammo for weapon2");
    }


    @Test
    public void testVehicle() {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();


        player2.setVehicle(true);
        player3.setVehicle(false);

        assertFalse(player1.isVehicle());
        assertTrue(player2.isVehicle());
        assertFalse(player3.isVehicle());
    }

    @Test
    public void testMed() {
        Player player1 = new Player();
        Player player2 = new Player();

        player1.setFirstKit(0);
        player1.setDrinks(100);
        player2.setMedKit(30);

        assertEquals(0, player1.getFirstKit(), 0.1, "Player1 has no first kit");
        assertEquals(100, player1.getDrinks(), 0.1, "Player1 has 100 energy drinks");
        assertEquals(30, player2.getMedKit(), 0.1, "Player1 has 30 med kits");
        assertEquals(0, player2.getBandage(), 0.1, "Player1 has zero bandage");
    }
}