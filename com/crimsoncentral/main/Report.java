package com.crimsoncentral.main.BanReport;

public class Report
{
    public Player player;
    public List<String> discriptions = new ArrayList<String>();
    pulbic List<Player> accusers = new ArrayList<Player>();
    
    public Report(Player p, String message)
    {
         this.player = p
         this.discriptions.add(message);
         this.accusers.add(p);
         ReportManager.reports.add(this);
    }
    
    public void addAccusation(Player p, String message)
    {
        this.discriptions.add(message);
        this.accusers.add(p);
    }
    
    public Player getPlayer()
    {
        return this.player;
    }
    
    public ArrayList<Player> getAccusers()
    {
        return this.accusers;
    }
    
    public ArrayList<String> getAccusations()
    {
        return this.discriptions;
    }
}
