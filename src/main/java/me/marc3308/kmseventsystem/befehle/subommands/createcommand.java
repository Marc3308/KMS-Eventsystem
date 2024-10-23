package me.marc3308.kmseventsystem.befehle.subommands;

import me.marc3308.kmseventsystem.befehle.subcommand;
import me.marc3308.kmseventsystem.objekts.eventzone;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static me.marc3308.kmseventsystem.Eventsystem.zonenlist;

public class createcommand extends subcommand {
    @Override
    public String getName() {
        return "create";
    }

    @Override
    public String getDescription() {
        return "create a eventzone";
    }

    @Override
    public String getSyntax() {
        return "/event create <Name>";
    }

    @Override
    public void perform(Player p, String[] args) {
        zonenlist.add(new eventzone(args[1],p.getLocation(),p.getLocation(),null,null,null));
        p.sendMessage(ChatColor.GREEN + "Die EventZone " + ChatColor.DARK_RED + args[1] + ChatColor.GREEN + " wurde erfolgreich erstellt");
    }
}
