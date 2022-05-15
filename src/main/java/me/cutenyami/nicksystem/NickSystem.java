package me.cutenyami.nicksystem;

import cn.nukkit.Server;
import cn.nukkit.plugin.PluginBase;
import me.cutenyami.nicksystem.commands.NickCMD;
import me.cutenyami.nicksystem.listener.JoinListener;
import me.cutenyami.nicksystem.mysql.MySQL;
import me.cutenyami.nicksystem.utils.Config;

public class NickSystem extends PluginBase {

    private static NickSystem instance;

    private MySQL mySQL;

    public Config config;

    @Override
    public void onEnable() {
        instance = this;

        config = new Config();

        config.getProfile().connect();

        mySQL = config.getProfile().getMySQL();
        mySQL.update("CREATE TABLE IF NOT EXISTS Players(NAME varchar(64), UUID varchar(64), NICKNAME varchar(64));");

        Server.getInstance().getCommandMap().register("nick", new NickCMD());

        this.getServer().getPluginManager().registerEvents(new JoinListener(), this);

        this.getLogger().info("§cThe Plugin have been enabled!");
    }

    @Override
    public void onDisable() {

    }

    public MySQL getMySQL() {
        return mySQL;
    }

    public static NickSystem getInstance() {
        return instance;
    }
}
