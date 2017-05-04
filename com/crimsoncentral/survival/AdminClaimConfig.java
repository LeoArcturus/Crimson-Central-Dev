package com.crimsoncentral.survival;

public class AdminClaimConfim
{
    public File plotConfig;
    public FileConfiguration plotData;
    
    public AdminClaimConfim()
    {      
        plotConfig = new File("plugins/CrimsonCentralv1/Survival/PlotClaim/Server_Claim.yml");
        plotData = YamlConfiguration.loadConfiguration(plotConfig);
    }
	
    public void createClaimDefaults(World w, Location loc1, Location loc2)
    {
	int i = getPlotQuantity() + 1;
        plotData.set("Claim" + i + ".World", w.getName());
        plotData.set("Claim" + i + ".Pos 1", pos1.getX() + ", " + pos1.getY() + ", " + pos1.getZ());
        plotData.set("Claim" + i + ".Pos 2", pos2.getX() + ", " + pos2.getY() + ", " + pos2.getZ());
        plotData.set("Claim" + i + ".Trusts", null);    
    }
	
    public int getPlotQuantity()
    {
        int highest = 0;
        for(String s : arenaConfiguration.getKeys(true))
	      {
            if(s.startsWith(Claim))
            {
                StringTokenizer st = new StringTokenizer(s);
                st.nextToken();
                int i = Integer.parseInt(st.nextToken());
                if(i > highest)
                {
                    i = highest;
                }
            }
	      }
        return highest;
    }
    
    public World getPlotWorld()
    {
        String s = plotData.getString("World");
        return Bukkit.getWorld(s);
    }
    
    public void setPlotWorld(World w)
    {
        plotData.set("World", w.getName());
    }
    
    public Location getPos1(int i)
    {
        String location = plotData.getInt("Claim " + i + ".Pos 1");
        Location loc;
	      StringTokenizer st = new StringTokenizer(s);
	      loc.setX(st.nextToken());
	      loc.setY(st.nextToken());
	      loc.setZ(st.nextToken());
	      return loc;
    }
    
    public void setPos1(int i, Location loc)
    {
        plotData.set("Claim" + i + ".Pos 1", loc.getX() + ", " + loc.getY() + ", " + loc.getZ())
    }
    
    public Location getPos2(int i)
    {
        return plotData.getInt("Claim " + i + ".Pos 2");
        StringTokenizer st = new StringTokenizer(s);
	      loc.setX(st.nextToken());
	      loc.setY(st.nextToken());
	      loc.setZ(st.nextToken());
	      return loc;
    }
    
    public void setPos2(int i, Location loc)
    {
        plotData.set("Claim" + i + ".Pos 2", loc.getX() + ", " + loc.getY() + ", " + loc.getZ())
    }
}
