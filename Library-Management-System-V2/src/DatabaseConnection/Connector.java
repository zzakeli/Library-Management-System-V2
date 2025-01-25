package DatabaseConnection;

import java.sql.*;

public class Connector {
    private static final String DB_URL = "jdbc:mysql://localhost:3307/lmsv2";
    private static final String USER = "root";
    private static final String PASS = "";

    public String query;
    public Statement statement;
    public ResultSet resultSet;
    public PreparedStatement preparedStatement;
    public CallableStatement callableStatement;

    public Connection connect() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        return conn;
    }

}
