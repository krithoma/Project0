import com.project0.dao.v_roomDAO;
import com.project0.driver.Driver;
import com.project0.driver.movementParse;
import com.project0.model.v_entity;
import com.project0.model.v_map;
import com.project0.model.v_room;
import com.project0.util.KTConnectionUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

public class testRoom {

    public static Connection conn = KTConnectionUtil.getConnection();
    static v_map catacomb = null;

    @BeforeAll
    static void beforeAll() {
        try {
            v_roomDAO catacombdao = new v_roomDAO();
            catacomb = catacombdao.getV_room();
        } catch (SQLException e) {
            Driver.log.warn("Bad or missing data...", e);
        }
    }

    @Test
    void testRoomDesc() {
        v_room room = catacomb.getRoom(5);
        String roomdesc = room.getRoomdesc();
        assertNotEquals("", roomdesc);
    }

    @Test
    void testAddOrb() {
        v_room room = catacomb.getRoom(5);
        assertFalse(room.getHasOrb());
        room.setHasOrb(true);
        assertTrue(room.getHasOrb());
    }

    @Test
    void testAddOgre() {
        v_room room = catacomb.getRoom(5);
        assertFalse(room.isHasOgre());
        room.setHasOgre(true);
        assertTrue(room.isHasOgre());
    }

    @Test
    void testRoomLock() {
        v_room room = catacomb.getRoom(5);
        assertFalse(room.isLocked());
        room.setLocked(true);
        assertTrue(room.isLocked());
    }

    @Test
    void testPickupFalse(){
        movementParse v_parse = new movementParse(catacomb);
        v_entity playerOne = new v_entity("Tester");
        v_parse.moveItem("sword",5, playerOne);
        assertFalse(playerOne.isHasSword());
    }

    @Test
    void testPickupTrue() {
        movementParse v_parse = new movementParse(catacomb);
        v_room room = catacomb.getRoom(5);
        v_entity playerOne = new v_entity("Tester");
        room.setHasKey(true);
        assertFalse(playerOne.isHasKey());
        assertTrue(room.getHasKey());
        v_parse.moveItem("key",5, playerOne);
        assertTrue(playerOne.isHasKey());
        assertFalse(room.getHasKey());
    }

    @Test
    void testGetDoors() {
        movementParse v_parse = new movementParse(catacomb);
        v_room room = catacomb.getRoom(5);
        assertTrue(room.getWhoNorthDoor() == 8);
        assertTrue(room.getWhoSouthDoor() == 2);
        assertTrue(room.getWhoEastDoor() == 6);
        assertTrue(room.getWhoWestDoor() == 4);
    }

    @Test
    void testMovePlayer() {
        movementParse v_parse = new movementParse(catacomb);
        v_room room = catacomb.getRoom(5);
        v_entity playerOne = new v_entity("Tester");
        playerOne.setWherePlayer(5);
        assertEquals(5, playerOne.getWherePlayer());
        int whereweare = v_parse.movePlayer("north",playerOne.getWherePlayer(),playerOne);
        assertEquals(8, whereweare);
    }
}
