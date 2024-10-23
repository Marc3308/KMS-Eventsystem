package me.marc3308.kmseventsystem.befehle.subommands;

import me.marc3308.kmseventsystem.befehle.subcommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static me.marc3308.kmseventsystem.utilitys.savepoints;

public class savecommand extends subcommand {
    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "saves the liste";
    }

    @Override
    public String getSyntax() {
        return "/event save";
    }

    @Override
    public void perform(Player p, String[] args) {
        savepoints();
        p.sendMessage(ChatColor.DARK_GREEN+"Die liste wurde erfolgreich gespeichert");
    }
}
