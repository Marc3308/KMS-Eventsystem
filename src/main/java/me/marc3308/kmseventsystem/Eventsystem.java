package me.marc3308.kmseventsystem;

import me.marc3308.kmseventsystem.befehle.loadevents;
import me.marc3308.kmseventsystem.befehle.saveevents;
import me.marc3308.kmseventsystem.objekts.eventzone;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

public final class Eventsystem extends JavaPlugin {

    public static ArrayList<eventzone> zonenlist=new ArrayList<>();

    @Override
    public void onEnable() {
        //runner
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {

                for (Player p : Bukkit.getOnlinePlayers()){

                    //start logic

                }
            }
        },0,20*2);

        //make the list from the YML
        File file = new File("plugins/KMS Plugins/Eventsystem","Eventzonen.yml");
        FileConfiguration con= YamlConfiguration.loadConfiguration(file);

        //load eventzonen
        for (int i = 0; i < 300; i++) {
            if(con.get(i+".Name")==null)break;
            zonenlist.add(new eventzone(
                    con.getString(i+".Name")
                    ,con.getLocation(i+".loc1")
                    ,con.getLocation(i+".loc2")
                    ,con.getInt(i+".Time")
                    ,con.getBoolean(i+".Tp")
                    ,con.getLocation(i+".TpLocation")
                    ,con.getDouble(i+".Schaden")
                    ,con.getString(i+".Sound")));
        }


        //commands
        getCommand("saveevents").setExecutor(new saveevents());
        getCommand("loadevents").setExecutor(new loadevents());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
