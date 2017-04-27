package com.crimsoncentral.survival;

public class PlotClaim implements Listerner
{
    public boolean checkPlotsContainsLocation(Location loc)
    {
        ArrayList<RegionSelection> plots = getClaims();
        boolean b = false;
        for(RegionSelection rs : plots)
        {
            if(rs.getPos1().getX() > loc.getX())
            {
                if(rs.getPos2().getX() < loc.getX())
                {
                    if(rs.getPos1().getZ() > loc.getZ())
                    {
                        if(rs.getPos2().getZ() < loc.getZ())
                        {
                            b = true;
                        }
                    }else if(rs.getPos1().getZ() < loc.getZ())
                    {
                        if(rs.getPos2().getZ() > loc.getZ())
                        {
                            b = true;
                        }
                    }
                }
            }else if(rs.getPos1().getX() < loc.getX())
            {
                if(rs.getPos2().getX() > loc.getX())
                {
                    if(rs.getPos1().getZ() > loc.getZ())
                    {
                        if(rs.getPos2().getZ() < loc.getZ())
                        {
                            b = true;
                        }
                    }else if(rs.getPos1().getZ() < loc.getZ())
                    {
                        if(rs.getPos2().getZ() > loc.getZ())
                        {
                            b = true;
                        }
                    }
                }
            }
        }
        return b;
    }

    public ArrayList<RegionSelection> getClaims()
    {
        ArrayList<RegionSelection> plots = new ArrayList<RegionSelection>();
        for(Player p : Bukkit.getOfflinePlayers())
        {
            PlotConfig pc = new PlotConfig(p.getUniqueID());
            pc.createPlayerConfig();
            for(i = 1, i < pc.getPlotQuantity(), i++)
            {
                RegionSelection rs = new RegionSelection(p, pc.getPlotWorld(i), pc.getPos1(i), pc.getPos2(i));
                plots.add(rs);
            }
        }
        AdminClaimConfig ac = new AdminClaimConfig();
        for(i = 1, i < ac.getPlotQuantity(), i++)
        {
            RegionSelection rs = new RegionSelection(null, pc.getPlotWorld(i), pc.getPos1(i), pc.getPos2(i));
            plots.add(rs);
        }
    }
}
