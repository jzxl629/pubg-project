import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelTest {

    @Test
    public void testModel() {
        Model model = new Model();
        Game game = new Game();
        Player player1 = new Player();
        player1.setAmmo1(600);
        player1.setWeapon1(0);
        player1.setWeapon2(3);
        player1.setAmmo2(1000);
        player1.setVehicle(true);

        model.setGame(game);
        model.setPlayer(player1);
        assertEquals(0, model.getPlayer().getWeapon1(), 0.1, "Player1 has no weapon as default");
        assertEquals(600, model.getPlayer().getAmmo1(), 0.1, "Player1 has 600 ammo for weapon1");
        assertEquals(3, model.getPlayer().getWeapon2(), "Player1 has a smg for weapon2");
        assertEquals(1000, model.getPlayer().getAmmo2(), 0.1, "Player1 has 1000 ammo for weapon2");
        assertTrue(model.getPlayer().isVehicle());


    }

}