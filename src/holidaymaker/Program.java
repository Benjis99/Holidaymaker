package holidaymaker;

import java.sql.*;

public class Program {
    private ResultSet resultSet;
    private PreparedStatement statement;
    private Connection connect = null;

    public Program() throws SQLException {
        connect();
        new Menu(connect, statement, resultSet);
    }

    private void connect() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:Holidaymaker2");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
