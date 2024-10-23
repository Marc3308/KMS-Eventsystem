package me.marc3308.kmseventsystem;

import me.marc3308.kmseventsystem.objekts.eventzone;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

import static me.marc3308.kmseventsystem.Eventsystem.zonenlist;

public class utilitys {

    public static void savepoints(){

        File file = new File("plugins/KMS Plugins/Eventsystem","Eventzonen.yml");
        FileConfiguration con= YamlConfiguration.loadConfiguration(file);

        //remove
        for (int i=0;i<100;i++)con.set(String.valueOf(i),null);

        //save
        for (eventzone s : zonenlist){
            con.set(zonenlist.indexOf(s)+".Name",s.getName());
            con.set(zonenlist.indexOf(s)+".loc1",s.getLoc1());
            con.set(zonenlist.indexOf(s)+".loc2",s.getLoc2());
            con.set(zonenlist.indexOf(s)+".Time",s.getTime());
            con.set(zonenlist.indexOf(s)+".TpLocation",s.getTpLock());
            con.set(zonenlist.indexOf(s)+".Sound",s.getSound());
        }

        //final save
        try {
            con.save(file);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static int ineventsone(Location loc){
        if(zonenlist.isEmpty())return -1;
        for(eventzone s : zonenlist){
            double minx = s.getLoc1().getX()<s.getLoc2().getX() ? s.getLoc1().getX() : s.getLoc2().getX();
            double miny = s.getLoc1().getY()<s.getLoc2().getY() ? s.getLoc1().getY() : s.getLoc2().getY();
            double minz = s.getLoc1().getZ()<s.getLoc2().getZ() ? s.getLoc1().getZ() : s.getLoc2().getZ();
            double maxx = s.getLoc1().getX()>s.getLoc2().getX() ? s.getLoc1().getX() : s.getLoc2().getX();
            double maxy = s.getLoc1().getY()>s.getLoc2().getY() ? s.getLoc1().getY() : s.getLoc2().getY();
            double maxz = s.getLoc1().getZ()>s.getLoc2().getZ() ? s.getLoc1().getZ() : s.getLoc2().getZ();

            if(minx<=loc.getX() && maxx>=loc.getX()
                    && miny<=loc.getY() && maxy>=loc.getY()
                    && minz<=loc.getZ() && maxz>=loc.getZ())return zonenlist.indexOf(s);
        }
        return -1;
    }
}
