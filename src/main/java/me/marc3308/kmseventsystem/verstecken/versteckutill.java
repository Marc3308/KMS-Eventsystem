package me.marc3308.kmseventsystem.verstecken;

import me.marc3308.kmseventsystem.Eventsystem;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;

public class versteckutill {
    public static HashMap<String, ArrayList<Player>> versteckliste=new HashMap<>();

    public static void startbar(String s){

        new BukkitRunnable(){
            @Override
            public void run() {
                if(!versteckliste.containsKey(s)){
                    cancel();
                    return;
                }



            }
        }.runTaskTimer(Eventsystem.plugin,0,40);

    }

}
