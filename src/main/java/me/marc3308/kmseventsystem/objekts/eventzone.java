package me.marc3308.kmseventsystem.objekts;

import org.bukkit.Location;

public class eventzone {

    private String Name;
    private Location loc1;
    private Location loc2;
    private Integer Time;
    private Location TpLock;
    private String Sound;

    public eventzone(String Name, Location loc1, Location loc2, Integer Time, Location TpLockation, String Sound){
        this.Name=Name;
        this.loc1=loc1;
        this.loc2=loc2;
        this.Time=Time;
        this.TpLock=TpLockation;
        this.Sound=Sound;
    }

    public String getName() {
        return Name;
    }

    public Location getLoc1() {
        return loc1;
    }

    public Location getLoc2() {
        return loc2;
    }

    public Integer getTime() {
        return Time;
    }
    public Location getTpLock() {
        return TpLock;
    }

    public String getSound() {
        return Sound;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setLoc1(Location loc1) {
        this.loc1 = loc1;
    }

    public void setLoc2(Location loc2) {
        this.loc2 = loc2;
    }

    public void setTime(Integer time) {
        Time = time;
    }

    public void setTpLock(Location tpLock) {
        TpLock = tpLock;
    }

    public void setSound(String sound) {
        Sound = sound;
    }
}
