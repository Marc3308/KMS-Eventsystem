package me.marc3308.kmseventsystem.verstecken;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class hitit implements Listener {

    @EventHandler
    public void onhit(EntityDamageByEntityEvent e){
        if(!(e.getDamager() instanceof Player && e.getEntity() instanceof Player))return;

    }
}
