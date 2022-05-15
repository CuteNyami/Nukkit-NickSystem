package me.cutenyami.nicksystem.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import me.cutenyami.nicksystem.manager.NickManager;

import java.util.Objects;

public class NickCMD extends Command {
    public NickCMD() {
        super("nick", "change your username", "/nick <name> /nick reset");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            NickManager nickManager = new NickManager(player);

            if (player.hasPermission("system.nick")) {
                if (args.length == 0) {
                    player.sendMessage("§7[§6System§7] §cWrong Usage: §7/nick <name> | /nick reset");
                    return false;
                }
                if (args.length == 1 && !Objects.equals(args[0], "reset")) {
                    player.setDisplayName(args[0]);
                    nickManager.updateNick(args[0]);
                    player.sendMessage("§7[§6System§7] §7Successfully changed your nickname to §a" + args[0]);
                    return false;
                }
                if (args[0].equalsIgnoreCase("reset")) {
                    player.setDisplayName(player.getName());
                    nickManager.resetNick();
                    player.sendMessage("§7[§6System§7] §7Your nickname has been reset!");
                    return false;
                }
            } else {
                if (args.length == 0) {
                    player.sendMessage("§7[§6System§7] §cYou don't have permissions for that command!");
                    return false;
                }
            }
        }
        return false;
    }
}
