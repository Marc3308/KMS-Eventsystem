package me.marc3308.kmseventsystem.befehle.subommands;

import me.marc3308.kmseventsystem.befehle.subcommand;
import me.marc3308.kmseventsystem.objekts.eventzone;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static me.marc3308.kmseventsystem.Eventsystem.zonenlist;

public class deletecommand extends subcommand {
    @Override
    public String getName() {
        return "delete";
    }

    @Override
    public String getDescription() {
        return "delets a eventzone";
    }

    @Override
    public String getSyntax() {
        return "/event delete <Name>";
    }

    @Override
    public void perform(Player p, String[] args) {

        for(eventzone ev : zonenlist)if(ev.getName().equals(args[1]))zonenlist.remove(ev);
        p.sendMessage(ChatColor.GREEN + "Die EventZone " + ChatColor.DARK_RED + args[1] + ChatColor.GREEN + " wurde erfolgreich gelöscht");

    }
}
