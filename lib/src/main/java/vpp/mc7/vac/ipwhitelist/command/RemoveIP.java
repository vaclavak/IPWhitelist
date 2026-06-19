package vpp.mc7.vac.ipwhitelist.command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import vpp.mc7.vac.ipwhitelist.main.Main;

public class RemoveIP implements BasicCommand{
	
	private Main m;
	
	public RemoveIP(Main m) {
		this.m = m;
	}
	
	@Override
    public void execute(CommandSourceStack source, String[] args) {
        if (args.length == 0) {
        	source.getSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Usage: /removeip <IP Address>"));
            return;
        }
        m.reloadConfig();
        
        List<String> allowedIPs = new ArrayList<>(m.getConfig().getStringList("allowed-ip-addresses"));
        
        if(!allowedIPs.contains(args[0])){
        	source.getSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Adress " + args[0] + " is already not allowed"));
        	return;
        }
        
        allowedIPs.remove(args[0]);
        
        m.getConfig().set("allowed-ip-addresses", allowedIPs);
        m.saveConfig();
        
        
        source.getSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&2Address " + args[0] + " is no longer allowed"));
    }
	
	@Override
	public String permission() {
		return "vpp.mc7.command.removeip";
	}

}
