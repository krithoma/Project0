import com.project0.dao.v_playerDAO;
import com.project0.model.v_entity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class testPlayer {

    public static v_playerDAO playerdao = null;

    @BeforeAll
    static void beforeAll() {
        try{
            playerdao = new v_playerDAO();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Test
    void testCheckRecord() {
        boolean player = playerdao.checkV_player("Tester");
        assertTrue(player);
    }

    @Test
    void testGetPlayerTrue() {
        v_entity playerOne = playerdao.getV_player("Tester");
        assertNotEquals(0, playerOne.getNumberOfWins());
    }

    @Test
    void testGetPlayerFalse(){
        v_entity playerOne = playerdao.getV_player("Chantal");
        assertNotEquals("Chantal", playerOne.getV_entityID());
    }

    @Test
    void testSetPlayerExists(){
        v_entity playerOne = playerdao.getV_player("Tester");
        int win = playerOne.getNumberOfWins();
        int win2 = win++;
        playerOne.setNumberOfWins(win2);
        playerdao.setV_player(playerOne);

        v_entity playerTwo = playerdao.getV_player("Tester");
        assertNotEquals(win, win2);
    }
}
