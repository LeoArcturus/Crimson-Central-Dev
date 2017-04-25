package com.crimsoncentral.survival;

public class PlotConfig
{
    public UUID u;
    public File plotConfig;
    public FileConfiguration plotData;
    
    public PlotConfig(UUID u)
    {
        this.u = u;
        
        plotConfig = new File("plugins/CrimsonCentralv1/Survival/PlotClaim/" + u + ".yml");
        plotData = YamlConfiguration.loadConfiguration(plotConfig);
    }
    
    public void createPlayerConfig()
	  {
		    try{
			      plotConfig.createNewFile();
		    }catch(IOException e){
			      e.printStackTrace();
		    }
	  } 
    
    public void createDefaults()
    {
        Player player = Bukkit.getPlayer(u);
        PlayerConfig u = new PlayerConfig(u);
        
        if(plotData.length <= 0){
            plotData.set("Name", player.getName());
        }else if(plotData.length <= 22){
            plotData.set("Block Claimed", 0)
        }else if(plotData.length <= 42){
            swtich(u.getRank)
            {
                case "No Rank":
                    plotData.set("Total Blocks", 10000);
                    break;
                case "Crimson":
                    plotData.set("Total Blocks", 25000);
                    break;
                case "Mage":
                    plotData.set("Total Blocks", 50000);
                    break;
                 case "Legend":
                    plotData.set("Total Blocks", 75000);
                    break;
                 case "Rogue":
                    plotData.set("Total Blocks", 150000);
                    break;
                 case "Guardian":
                    plotData.set("Total Blocks", 250000);
                    break
                 case "Helper":
                 case "Admin":
                 case "CoOwner":
                 case "Owner":
                    plotData.set("Total Blocks", "-1");
             }
        }
    }
    
    public void createClaimDefaults(World w, Location pos1, Location pos2)
    {
        int i = getPlotQuantity() + 1;
        plotData.set("Claim" + i + ".Blocks", setBlocksPerPlot(pos1, pos2))
        plotData.set("Claim" + i + ".World", w.getName());
        plotData.set("Claim" + i + ".Pos 1", pos1.getX() + ", " + pos1.getY() + ", " + pos1.getZ());
        plotData.set("Claim" + i + ".Pos 2", pos2.getX() + ", " + pos2.getY() + ", " + pos2.getZ());
        plotData.set("Claim" + i + ".Trusts", null);
    }
    
    public int getClaimedBlocks()
    {
        return plotData.getInt("Claimed Blocks");
    }
    
    public void addClaimedBlocks(int i)
    {
        plotData.set("Claimed Blocks", plotData.getInt("Claimed Blocks") + i);
    }
    
    public void subtractClaimedBlocks(int i)
    {
        plotData.set("Claimed Blocks", plotData.getInt("Claimed Blocks") - i)
    }
    
    public int getTotalBlocks()
    {
        return plotData.getInt("Total Blocks");
    }
    
    public void setTotalBlocks(int i)
    {
        plotData.set("Total Blocks", i)
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
    
    public World getPlotWorld(int i)
    {
        String s = plotData.getString("Claim" + i + ".World");
        return Bukkit.getWorld(s);
    }
    
    public void setPlotWorld(int i World w)
    {
        plotData.set("Claim" + i + ".World", w.getName());
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
    
    public int getBlocksPerPlot(int i)
    {
        return plotData.getInt("Claim " + i + ".Block");
    }
    
    public void setBlocksPerPlot(int i, Location pos1, Location pos2)
    {
        int x1 = pos1.getX();
        int z1 = pos1.getZ();
        int x2 = pos2.getX();
        int z2 = pos2.getZ();
        int xlength = x2 - x1;
        int ylength = y2 - y1;
        int area = xlength * ylength;
        plotData.set("Claim" + i + ".Blocks", area);
    }
    
    public ArrayList<Player> getTrusts(int i)
    {
        return plotData.getList("Claim " + i + ".Trust");
    }
    
    public void addTrust(int i, Player p)
    {
        ArrayList<Player> trusts = plotData.getList("Claim " + i + ".Trust");
        if(!trusts.contains(p))
        {
            plotData.getList("Claim " + i + ".Trust").add(p.getName());
        }
    }
    
    public void removeTrust(int i, Player p)
    {
        ArrayList<Player> trusts = plotData.getList("Claim " + i + ".Trust");
        if(trusts.contains(p))
        {
            plotData.getList("Claim " + i + ".Trust").remove(p.getName());
        }
    }
}
