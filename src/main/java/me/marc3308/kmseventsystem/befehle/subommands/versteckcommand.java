package me.marc3308.kmseventsystem.befehle.subommands;

import me.marc3308.kmseventsystem.befehle.subcommand;
import me.marc3308.kmseventsystem.verstecken.versteckutill;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class versteckcommand extends subcommand {
    @Override
    public String getName() {
        return "Verstecken";
    }

    @Override
    public String getDescription() {
        return "a verstecken spiel";
    }

    @Override
    public String getSyntax() {
        return "/event Verstecken <befehl>";
    }

    @Override
    public void perform(Player p, String[] args) {

        //create the game
        if(args[1].equals("create")){
            p.getNearbyEntities(64,64,64).forEach(pl -> {
                if(pl instanceof Player){
                    TextComponent joingame = new TextComponent(ChatColor.DARK_GREEN + "Du wurdest zu Verstecken eingeladen "+ChatColor.YELLOW+"[Beitreten]");
                    joingame.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/joinverstecken "+p.getName()));
                    pl.sendMessage(joingame);
                }
            });

            versteckutill.versteckliste.put(p.getName(),new ArrayList<Player>());

        }
    }
}
