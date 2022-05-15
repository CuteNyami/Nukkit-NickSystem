package me.cutenyami.nicksystem.manager;

import cn.nukkit.Player;
import me.cutenyami.nicksystem.NickSystem;
import me.cutenyami.nicksystem.handler.INickHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NickManager implements INickHandler {

    private final Player player;

    public NickManager(Player player) {
        this.player = player;
    }

    @Override
    public void createUser() {
        if (!existsPlayer()) {
            NickSystem.getInstance().getMySQL().update("INSERT INTO Players(NAME, UUID, NICKNAME) VALUES('" + player.getName() + "', '" + player.getUniqueId() + "', 'null');");
        }
    }

    @Override
    public void updateNick(String name) {
        if (existsPlayer()) {
            NickSystem.getInstance().getMySQL().update("UPDATE Players SET NICKNAME='" + name + "';");
        }
    }

    @Override
    public void resetNick() {
        if (existsPlayer()) {
            NickSystem.getInstance().getMySQL().update("UPDATE Players SET NICKNAME='null';");
        }
    }

    @Override
    public boolean existsPlayer() {
        try {
            ResultSet rs = NickSystem.getInstance().getMySQL().query("SELECT * FROM Players WHERE UUID='" + player.getUniqueId() + "'");

            if (rs.next()) {
                return rs.getString("UUID") != null;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getName() {
        String name = player.getName();

        if (existsPlayer()) {
            try {
                ResultSet rs = NickSystem.getInstance().getMySQL().query("SELECT NICKNAME FROM Players WHERE UUID='" + player.getUniqueId() + "'");
                if ((rs.next())) {
                    name = !rs.getString("NICKNAME").equals("null") ? rs.getString("NICKNAME") : player.getName();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

    public Player getPlayer() {
        return player;
    }
}
