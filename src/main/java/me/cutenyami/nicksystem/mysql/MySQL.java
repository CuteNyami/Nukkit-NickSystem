package me.cutenyami.nicksystem.mysql;

import me.cutenyami.nicksystem.NickSystem;

import java.sql.*;

public class MySQL {

    private final String host, database, user, password;

    private final int port;

    private Connection connection;

    public MySQL(String host, int port, String database, String user, String password) {
        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;
        this.port = port;
    }

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=false", user, password);
            NickSystem.getInstance().getLogger().info("[MySQL] The connection to MySQL has been established!");
        } catch (SQLException | ClassNotFoundException e) {
            NickSystem.getInstance().getLogger().error("[MySQL] The connection to MySQL failed => " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
                NickSystem.getInstance().getLogger().info("[MySQL] The connection to MySQL was terminated successfully!");
            }
        } catch (SQLException e) {
            NickSystem.getInstance().getLogger().error("[MySQL] Error terminating connection to MySQL => " + e.getMessage());
        }
    }

    public void update(String qry) {
        try {
            if (connection.isClosed()) {
                connect();
            }
            Statement st = connection.createStatement();
            st.executeUpdate(qry);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String qry) {
        ResultSet rs = null;

        try {
            if (connection.isClosed()) {
                connect();
            }
            Statement st = connection.createStatement();
            st.executeQuery(qry);
            rs = st.getResultSet();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}

