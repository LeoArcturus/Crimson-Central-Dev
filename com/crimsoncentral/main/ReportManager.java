package com.crimsoncentral.main.ReportManager

public ReportManager implements CommandSender, Listener
{
    public static List<Report> reports = new ArrayList<Report>();

    @SuppressWarnings({ "deprecation", "unused" })
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
    {
        if(sender instanceof Player)
        {
		        Player player = (Player) sender;
            if(cmd.equalsIgnoreCase("/report"))
            {
                if(args.length() >= 2 && args.length() <= 7)
                {
                    if(Bukkit.getPlayer(args[0]) != null)
					          {
						            Player plr = Bukkit.getPlayer(pl);
                        boolean b = false;
                        for(Report r : reports)
                        {
                            if(r.getPlayer = plr)
                            {
                                b = true;
                            }
                        }

                        if(b != true)
                        {
                            switch(args.length())
                                case 2:
                                    Report r = new Report(plr, player, args[1]);
                                case 3:
                                    Report r = new Report(plr, player, args[1] + args[2]);
                                case 4:
                                    Report r = new Report(plr, player, args[1] + args[2] + args[3]);
                                case 5:
                                    Report r = new Report(plr, player, args[1] + args[2] + args[3] + args[4]);
                                case 6:
                                    Report r = new Report(plr, player, args[1] + args[2] + args[3] + args[4] + args[5]);
                                case 7:
                                    Report r = new Report(plr, player, args[1] + args[2] + args[3] + args[4] + args[5] + args[6]);
                        }else{
                            Report report;
                            for(Report r : reports)
                            {
                                if(r.getPlayer = plr)
                                {
                                    r = report;
                                }
                            }
                            
                            switch(args.length())
                                case 2:
                                    report.addAcusation(plr, player, args[1]);
                                case 3:
                                    report.addAcusation(plr, player, args[1] + args[2]);
                                case 4:
                                    report.addAcusation(plr, player, args[1] + args[2] + args[3]);
                                case 5:
                                    report.addAcusation(plr, player, args[1] + args[2] + args[3] + args[4]);
                                case 6:
                                    report.addAcusation(plr, player, args[1] + args[2] + args[3] + args[4] + args[5]);
                                case 7:
                                    report.addAcusation(plr, player, args[1] + args[2] + args[3] + args[4] + args[5] + args[6]);
                        }
                    }else{
                        player.sendMessage(ChatColor.RED + "Invalid Player Name!");
                        player.sendMessage(ChatColor.RED + "Usage: /report [Player Name] (Five word discription of offense)");
                    }
                    
                }else if(args.length() >= 7){
                    player.sendMessage(ChatColor.RED + "To many words in description!");
                    player.sendMessage(ChatColor.RED + "Usage: /report [Player Name] (Five word discription of offense)");
                }else{
                    player.sendMessage(ChatColor.RED + "Invalid use!");
                    player.sendMessage(ChatColor.RED + "Usage: /report [Player Name] (Five word discription of offense)");
                }
            }
        }
    }
    
    @EventHandler
    public void onPunch(PlayerInteractEvent e)
    {
        Player p = e.getPlayer();
        ItemStack item = event.getItem();

		    if (player.getItemInHand().getItemMeta().getDisplayName().contains("")) 
        {
            Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLUE + "Reports");
            int i = 0;
            for(Report r : reports)
            {
                while(i < 54)
                {
                    Player plr = r.getPlayer();
                    ItemStack report = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                    SkullMeta skullMeta = (SkullMeta) report.getItemMeta();
                    skullMeta.setOwner(pn);
                    skullMeta.setDisplayName(ChatColor.GOLD + plr.getName());
                    ArrayList<String> lore = new ArrayList<String>();
                    lore.add("Total Reports" + r.getAccusers().size());
                    lore.add("");
                    for(String s : r.getAccusations)
                    {
                        lore.add(ChatColor.GRAY + s);
                    }
                    skullMeta.setLore(lore);
                    report.setItemMeta(skullMeta);
                    inv.setItem(i, report);
                    i++;
                }
            }
            p.openInventory(inv);            
        }
    }
}
