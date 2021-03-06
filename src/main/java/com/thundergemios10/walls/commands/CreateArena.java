package com.thundergemios10.walls.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import com.thundergemios10.walls.GameManager;
import com.thundergemios10.walls.MessageManager;
import com.thundergemios10.walls.SettingsManager;



public class CreateArena implements SubCommand{

    public boolean onCommand(Player player, String[] args) {
        if(!player.hasPermission(permission()) && !player.isOp()){
            MessageManager.getInstance().sendFMessage(MessageManager.PrefixType.ERROR, "error.nopermission", player);
            return true;
        }
        GameManager.getInstance().createArenaFromSelection(player);
        return true;
    }

    public String help(Player p) {
        return "/w createarena - " + SettingsManager.getInstance().getMessageConfig().getString("messages.help.createarena", "Create a new arena with the current WorldEdit selection");
    }

	public String permission() {
		return "walls.admin.createarena";
	}
}