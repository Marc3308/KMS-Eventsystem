package me.marc3308.kmseventsystem;

import me.marc3308.kmseventsystem.befehle.CommandManager;
import me.marc3308.kmseventsystem.befehle.loadevents;
import me.marc3308.kmseventsystem.befehle.saveevents;
import me.marc3308.kmseventsystem.objekts.eventzone;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

import static me.marc3308.kmseventsystem.utilitys.ineventsone;
import static me.marc3308.kmseventsystem.utilitys.savepoints;

public final class Eventsystem extends JavaPlugin {

    public static ArrayList<eventzone> zonenlist=new ArrayList<>();

    public static Eventsystem plugin;


    @Override
    public void onEnable() {


        plugin=this;

        //runner
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {

                for (Player p : Bukkit.getOnlinePlayers()){

                    //start logic
                    if(ineventsone(p.getLocation())!=-1 && p.getGameMode().equals(GameMode.SURVIVAL)){

                        eventzone ev=zonenlist.get(ineventsone(p.getLocation()));

                        //time
                        if(ev.getTime()!=null){
                            p.setPlayerTime(ev.getTime(),false);
                            Bukkit.getScheduler().runTaskLater(plugin, () -> {if(ineventsone(p.getLocation())==-1 || ev.getTime()==null)p.resetPlayerTime();}, 60L);
                        }
                        if(ev.getTpLock()!=null)p.teleport(ev.getTpLock());
                        if(ev.getSound()!=null)p.playSound(p.getLocation(),Sound.valueOf(ev.getSound()),1,1);


                    }
                }
            }
        },0,5);

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
                    ,con.getLocation(i+".TpLocation")
                    ,con.getString(i+".Sound")));
        }


        //commands
        getCommand("event").setExecutor(new CommandManager());
        getCommand("saveevents").setExecutor(new saveevents());
        getCommand("loadevents").setExecutor(new loadevents());

    }

    @Override
    public void onDisable() {
        savepoints();
    }
}
