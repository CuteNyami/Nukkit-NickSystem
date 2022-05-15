package me.cutenyami.nicksystem.listener;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import me.cutenyami.nicksystem.manager.NickManager;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        NickManager nickManager = new NickManager(player);
        nickManager.createUser();

        player.setDisplayName(nickManager.getName());
    }

}
