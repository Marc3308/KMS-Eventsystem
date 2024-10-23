package me.marc3308.kmseventsystem.befehle.subommands;

import me.marc3308.kmseventsystem.befehle.subcommand;
import me.marc3308.kmseventsystem.objekts.eventzone;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;


import static me.marc3308.kmseventsystem.Eventsystem.zonenlist;

public class editcommand extends subcommand {
    @Override
    public String getName() {
        return "edit";
    }

    @Override
    public String getDescription() {
        return "edit a event zone";
    }

    @Override
    public String getSyntax() {
        return "/event edit <Name> <wert> <Neuerwert>";
    }

    @Override
    public void perform(Player p, String[] args) {

        for(eventzone ev : zonenlist)if(ev.getName().equals(args[1])) {
            try {

                switch (args[2]){
                    case "Name":
                        ev.setName(args[3]);
                        break;
                    case "Eckpunkt1":
                        ev.setLoc1(new Location(p.getWorld(),Integer.valueOf(args[3]),Integer.valueOf(args[4]),Integer.valueOf(args[5])));
                        break;
                    case "Eckpunkt2":
                        ev.setLoc2(new Location(p.getWorld(),Integer.valueOf(args[3]),Integer.valueOf(args[4]),Integer.valueOf(args[5])));
                        break;
                    case "Zeit":
                        ev.setTime(args[3].equals("remove") ? null : Integer.valueOf(args[3]));
                        break;
                    case "TpPunkt":
                        ev.setTpLock(args[3].equals("remove") ? null : new Location(p.getWorld(),Integer.valueOf(args[3]),Integer.valueOf(args[4]),Integer.valueOf(args[5])));
                        break;
                    case "Sound":
                        ev.setSound(args[3].equals("remove") ? null : args[3]);
                        break;
                    default:
                        p.sendMessage(ChatColor.RED+"Did not Find "+args[2]);
                        break;
                }

                //mesage
                String alltheargs=args[3];
                for (int i=4;i<args.length;i++)alltheargs+=" "+args[i];
                p.sendMessage(ChatColor.DARK_GREEN+args[2]+" wurde erfolgreich geändert zu: "+ ChatColor.GREEN+alltheargs);


            } catch (IllegalArgumentException e){
                p.sendMessage(ChatColor.RED+"Flasche angabe");
            } catch (ArrayIndexOutOfBoundsException e){
                p.sendMessage(ChatColor.RED+"Die Eingaben wahren zu kurtz");
            }
        }
    }
}
