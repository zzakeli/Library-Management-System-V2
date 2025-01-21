package DatabaseConnection;

import java.sql.*;

public class Connector {
    private static final String DB_URL = "jdbc:mysql://localhost:3307/lmsV2";
    private static final String USER = "root";
    private static final String PASS = "";

    protected String query;
    protected Statement statement;
    protected ResultSet resultSet;
    protected PreparedStatement preparedStatement;
    protected CallableStatement callableStatement;

    protected Connection connect() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        return conn;
    }
}
