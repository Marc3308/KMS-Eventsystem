package me.marc3308.kmseventsystem.befehle;

import me.marc3308.kmseventsystem.verstecken.versteckutill;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class joinverstecken implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player))return false;
        Player p= (Player) sender;
        if(args.length<1)return false;
        if(!versteckutill.versteckliste.containsKey(args[0])){
            p.sendMessage("Dieses Spiel existiert nicht mehr");
            return false;
        }
        versteckutill.versteckliste.get(args[0]).add(p);

        return false;
    }
}
