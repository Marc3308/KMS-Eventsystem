package me.marc3308.kmseventsystem.befehle;

import me.marc3308.kmseventsystem.objekts.eventzone;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static me.marc3308.kmseventsystem.Eventsystem.zonenlist;


import java.io.File;

public class loadevents implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player)return false;



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
        return false;
    }
}
