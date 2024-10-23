package me.marc3308.kmseventsystem.befehle.subommands;

import me.marc3308.kmseventsystem.befehle.subcommand;
import me.marc3308.kmseventsystem.objekts.eventzone;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

import static me.marc3308.kmseventsystem.Eventsystem.zonenlist;

public class loadeventcommand extends subcommand {
    @Override
    public String getName() {
        return "load";
    }

    @Override
    public String getDescription() {
        return "loads the liste from yml";
    }

    @Override
    public String getSyntax() {
        return "/event load";
    }

    @Override
    public void perform(Player p, String[] args) {
        //make the list from the YML
        File file = new File("plugins/KMS Plugins/Eventsystem","Eventzonen.yml");
        FileConfiguration con= YamlConfiguration.loadConfiguration(file);

        zonenlist.clear();

        //load eventzonen
        for (int i = 0; i < 300; i++) {
            if(con.get(i+".Name")==null)break;
            zonenlist.add(new eventzone(
                    con.getString(i+".Name")
                    ,con.getLocation(i+".loc1")
                    ,con.getLocation(i+".loc2")
                    ,con.getInt(i+".Time")
                    ,con.getLocation(i+".TpLocation")
                    ,con.getString(i+".Sound")));
        }
        p.sendMessage(ChatColor.DARK_GREEN+"Liste wurde erfolgreich geladen: ");
        if(zonenlist.isEmpty())return;
        for (eventzone ev : zonenlist)p.sendMessage(ChatColor.DARK_GREEN+""+zonenlist.indexOf(ev)+": "+ChatColor.GREEN+ev.getName());
    }
}
