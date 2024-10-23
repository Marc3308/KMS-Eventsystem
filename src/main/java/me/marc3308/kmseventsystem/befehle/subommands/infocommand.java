package me.marc3308.kmseventsystem.befehle.subommands;

import me.marc3308.kmseventsystem.befehle.subcommand;
import me.marc3308.kmseventsystem.objekts.eventzone;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static me.marc3308.kmseventsystem.Eventsystem.zonenlist;

public class infocommand extends subcommand {
    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "information about a Eventzone";
    }

    @Override
    public String getSyntax() {
        return "/event info <Name>";
    }

    @Override
    public void perform(Player p, String[] args) {
        for(eventzone ev : zonenlist)if(ev.getName().equals(args[1])) {

            //what happens when loc null
            p.sendMessage(ChatColor.DARK_GREEN+"------------Info-----------");
            p.sendMessage(ChatColor.DARK_GREEN+"Name: "+ChatColor.GREEN+ev.getName());
            TextComponent loc1=new TextComponent(ChatColor.DARK_GREEN+"Eckpunkt 1: "+ChatColor.YELLOW+"["+(int) ev.getLoc1().getX()+"x "+(int) ev.getLoc1().getY()+"y "+(int) ev.getLoc1().getZ()+"z ]");
            loc1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/tp "+ev.getLoc1().getX() +" "+ev.getLoc1().getY()+ " "+ ev.getLoc1().getZ()));
            p.sendMessage(loc1);
            TextComponent loc2=new TextComponent(ChatColor.DARK_GREEN+"Eckpunkt 2: "+ChatColor.YELLOW+"["+(int) ev.getLoc2().getX()+"x "+(int) ev.getLoc2().getY()+"y "+(int) ev.getLoc2().getZ()+"z ]");
            loc2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/tp "+ev.getLoc2().getX() +" "+ev.getLoc2().getY()+ " "+ ev.getLoc2().getZ()));
            p.sendMessage(loc2);
            p.sendMessage(ChatColor.DARK_GREEN+"Time: "+ChatColor.GREEN+ev.getTime());
            TextComponent loc3=new TextComponent(ChatColor.DARK_GREEN+"Tp Location: "+ChatColor.YELLOW+"["+(int) ev.getTpLock().getX()+"x "+(int) ev.getTpLock().getY()+"y "+(int) ev.getTpLock().getZ()+"z ]");
            loc3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/tp "+ev.getTpLock().getX() +" "+ev.getTpLock().getY()+ " "+ ev.getTpLock().getZ()));
            p.sendMessage(loc3);
            p.sendMessage(ChatColor.DARK_GREEN+"Sound: "+ChatColor.GREEN+ev.getSound());
            p.sendMessage(ChatColor.DARK_GREEN+"---------------------------");


        }
    }
}
