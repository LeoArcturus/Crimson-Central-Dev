package com.crimsoncentral.survival;

public class PlotClaimCommands implements CommandExecutor
{
    public HashMap<Player, RegionSelection> selections = new <PLayer, RegionSelection>();
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("plotclaim") || cmd.getName().equalsIgnoreCase("pc") cmd.getName().equalsIgnoreCase("sp")) 
        {
            if(args[0] = "pos1")
            {
                if(checkPlotsContainsLocation(p.getLocation()) == false){
                    if(selections.get(player) != null)
                    {
                        RegionSelection rs = selections.get(player);
                        rs.setPos1(p.getLocation);
                        if(rs.getWorld() != player.getWorld())
                        {
                            rs.setWorld(player.getWorld);
                            rs.setPos2(null);
                        }
                    }else{
                        RegionSelection rs = new RegionSelection(player, player.getWorld(), player.getLocation());
                        selections.put(p, rs);
                    }
                }else{
                    p.sendMessage(ChatColor.RED + "You cannot claim in another persons plot.");
                }
            }else if(args[0] = "pos2")
            {
                if(checkPlotsContainsLocation(p.getLocation()) == false){
                    if(selections.get(player) != null)
                    {
                        RegionSelection rs = selections.get(player);
                        rs.setPos2(p.getLocation);
                        if(rs.getWorld() != player.getWorld())
                        {
                            rs.setWorld(player.getWorld);
                            rs.setPos1(null);
                        }
                    }else{
                        RegionSelection rs = new RegionSelection(player, player.getWorld(), null, player.getLocation())
                        selections.put(p, rs);
                    }
                }else{
                    p.sendMessage(ChatColor.RED + "You cannot claim in another persons plot.");
                }
            }else if(args[0] = "claim")
            {
                boolean b = false;
                RegionSelection playerPlot = selections.get(p);
                for(RegionSelection rs : getClaims)
                {
                    if(rs.getPos1().getX() < loc.getX())
                    {
                        if(rs.getPos2().getX() > loc.getX())
                        {
                            if(rs.getPos1().getZ() < loc.getZ())
                            {
                                if(rs.getPos2().getZ() > loc.getZ())
                                {
                                    b = true;
                                }
                            }else if(rs.getPos1().getZ() > loc.getZ())
                            {
                                if(rs.getPos2().getZ() < loc.getZ())
                                {
                                    b = true;
                                }
                            }
                        }
                    }else if(rs.getPos1().getX() > loc.getX())
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
                    }
                }
                
                if(b == false)
                {
                    PlotConfig pc = new PlotConfig(p.getUniqueID());
                    pc.createClaimDefaults(playerPlot.getWorld(), playerPlot.getPos1(), playerPlot.getPos2());
                }else{
                    p.sendMessage(ChatColor.RED + "Your region selection overlaps another plot and cannot be claimed!");
                }
            }else if(args[0] = "trust")
            {
                if(Bukkit.getPlayer(args[1]) != null)
                {
                    Player plr = Bukkit.getPlayer(args[1]);
                    PlotConfig pc = new PlotConfig(p.getUniqueID());
                    ArrayList<RegionSelection> plots = new ArrayList<RegionSelection>();
                    HashMap<Integer, RegionSelection> plotNumbers = new HashMap<Integer, RegionSelection>();
                    RegionSelection playerRegion = null;
                    boolean b;
                    for(int i; i <= pc.getPlotQuantity; i++)
                    {
                        RegionSelection rs = new RegionSelection(p, pc.getWorld(i), pc.getPos1(i), pc.getPos2(i));
                        plots.add(rs);
                    }
                    for(RegionSelection rs : plots)
                    {
                        if(checkPlotContainsLocation(rs, p.getLocation()) == true)
                        {
                            rs = playerRegion;
                        }
                    }
                    if(playerRegion != null)
                    {
                        int i = plotNumbers.get(playerRegion);
                        for(Player player : pc.getTrusts)
                        {
                            if(player != plr)
                            {
                                pc.addTrust(plr);
                            }else{
                                p.sendMessage(ChatColor.RED + "That player is already trusted to this plot!");
                            }
                        }
                    }else{
                        p.sendMessage(ChatColor.RED + "You must stand inside one of your plots for this to work!");
                    }
                }else{
                    p.sendMessage(ChatColor.RED + args[1] + " is not a valid player!");
                }
            }
        }
    }
}
