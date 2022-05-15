package me.cutenyami.nicksystem.mysql;

public class Profile {

    private final String host, database, user, password;

    private final int port;

    private MySQL mySQL;

    public Profile(String host,int port, String user, String database, String password) {
        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;
        this.port = port;
    }

    public void connect() {
        mySQL = new MySQL(host, port, database, user, password);
        mySQL.connect();
    }

    public void close() {
        mySQL.close();
    }

    public String getHost() {
        return host;
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

    public int getPort() {
        return port;
    }

    public MySQL getMySQL() {
        return mySQL;
    }
}
