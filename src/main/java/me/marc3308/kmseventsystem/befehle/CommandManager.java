package me.marc3308.kmseventsystem.befehle;

import me.marc3308.kmseventsystem.befehle.subommands.*;
import me.marc3308.kmseventsystem.objekts.eventzone;
import org.bukkit.Sound;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static me.marc3308.kmseventsystem.Eventsystem.zonenlist;

public class CommandManager implements CommandExecutor, TabCompleter {

    public static ArrayList<subcommand> subcommandlist=new ArrayList<>();

    public CommandManager(){
        subcommandlist.add(new infocommand());
        subcommandlist.add(new createcommand());
        subcommandlist.add(new deletecommand());
        subcommandlist.add(new editcommand());
        subcommandlist.add(new loadeventcommand());
        subcommandlist.add(new savecommand());
        subcommandlist.add(new versteckcommand());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player))return false;
        Player p=(Player) sender;
        if(!p.isOp())return false;

        switch (args[0]){
            case "create":
                subcommandlist.get(1).perform(p,args);
                break;
            case "delete":
                subcommandlist.get(2).perform(p,args);
                break;
            case "edit":
                subcommandlist.get(3).perform(p,args);
                break;
            case "load":
                subcommandlist.get(4).perform(p,args);
                break;
            case "save":
                subcommandlist.get(5).perform(p,args);
                break;
            case "Verstecken":
                subcommandlist.get(6).perform(p,args);
                break;
            default:
                subcommandlist.get(0).perform(p,args);
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p= (Player) sender;
        ArrayList<String> list =new ArrayList<>();
        if(!p.isOp())return list;

        try {
            if(args.length == 0)return list;
            if(args.length == 1)for (subcommand sub : subcommandlist)list.add(sub.getName().toString());
            if(args.length >= 2 && (args[0].equals("save") || args[0].equals("load")))return list;
            if(args.length >= 3 && (args[0].equals("create") || args[0].equals("delete") || args[0].equals("info")))return list;
            if(args.length >= 4 && args[0].equals("Verstecken"))return list;
            if(args.length == 2){
                if(args[0].equals("create")){
                    list.add("<Name>");
                } else if(args[0].equals("Verstecken")){
                    list.add("create");
                    list.add("start");
                    list.add("end");
                } else {
                    if(zonenlist.isEmpty())return list;
                    for(eventzone ev : zonenlist)list.add(ev.getName());
                }
            }
            if(args.length == 3){

                if(args[0].equals("Verstecken") && args[1].equals("start") ){
                    list.add("<Sucher>");
                } else {
                    list.add("Name");
                    list.add("Eckpunkt1");
                    list.add("Eckpunkt2");
                    list.add("Zeit");
                    list.add("TpPunkt");
                    list.add("Sound");
                }
            }
            if(args.length==4){
                switch (args[2]){
                    case "Name":
                        list.add("<new-name>");
                        break;
                    case "Zeit":
                        list.add("remove");
                        list.add("<custem>");
                        list.add("1000");
                        list.add("6000");
                        list.add("13000");
                        list.add("18000");
                        break;
                    case "Sound":
                        list.add("remove");
                        for (Sound s : Sound.values())list.add(s.toString());
                        break;
                    default:
                        if(args[2].equals("TpPunkt"))list.add("remove");
                        list.add(p.getLocation().getBlockX()+" "+p.getLocation().getBlockY()+" "+p.getLocation().getBlockZ());
                        break;
                }
            }

            if(args.length==5)list.add(String.valueOf(p.getLocation().getBlockY()));
            if(args.length==6)list.add(String.valueOf(p.getLocation().getBlockZ()));
            if(args.length==7)return list;

            //autocompetion
            ArrayList<String> commpleteList = new ArrayList<>();
            String currentarg = args[args.length-1].toLowerCase();
            for (String s : list){
                if(s==null)return list;
                String s1 =s.toLowerCase();
                if(s1.startsWith(currentarg)){
                    commpleteList.add(s);
                }
            }

            return commpleteList;
        } catch (CommandException e){
            return list;
        }
    }
}
