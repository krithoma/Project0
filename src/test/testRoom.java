import com.project0.dao.v_roomDAO;
import com.project0.driver.Driver;
import com.project0.model.v_map;
import com.project0.util.KTConnectionUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
    void roomName() {

    }
}
