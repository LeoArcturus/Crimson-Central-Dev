package com.crimsoncentral.survival;

public class RegionSelection
{
    public Player p;
    public World w;
    public Location pos1;
    public Location pos2;
    
    public RegionSelection(Player p, World w)
    {
        this.p = p;
        this.w = w;
    }
    
    public RegionSelection(Player p, World w, Location pos1)
    {
        this.p = p;
        this.w = w;
        this.pos1 = pos1;
    }
    
    public RegionSelection(Player p, World w, Location pos1, Location pos2)
    {
        this.p = p;
        this.w = w;
        this.pos1 = pos1;
        this.pos2 = pos2;
    }
    
    public Player getPlayer()
    {
        return this.p;
    }
    
    public World getWorld()
    {
        return this.w;
    }
    
    public Location getPos1()
    {
        return this.pos1;
    }
    
    public Location getPos2()
    {
        return this.pos2;
    }
    
    public void setPlayer(Player p)
    {
        this.p = p;
    }
    
    public void setWorld(World w)
    {
        this.w = w;
    }
    
    public void setPos1(Location loc)
    {
        this.pos1 = loc;
    }
    
    public void setPos2(Location loc)
    {
        this.pos2 = loc;
    }
}
