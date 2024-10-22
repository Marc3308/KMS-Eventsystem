package me.marc3308.kmseventsystem.objekts;

import org.bukkit.Location;

public class eventzone {

    private String Name;
    private Location loc1;
    private Location loc2;
    private Integer Time;
    private Boolean TP;
    private Location TpLock;
    private Double Schaden;
    private String Sound;

    public eventzone(String Name, Location loc1, Location loc2, int Time, boolean Tp, Location TpLockation, double Schaden, String Sound){
        this.Name=Name;
        this.loc1=loc1;
        this.loc2=loc2;
        this.Time=Time;
        this.TP=Tp;
        this.TpLock=TpLockation;
        this.Schaden=Schaden;
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

    public Boolean getTP() {
        return TP;
    }

    public Location getTpLock() {
        return TpLock;
    }

    public Double getSchaden() {
        return Schaden;
    }

    public String getSound() {
        return Sound;
    }
}
