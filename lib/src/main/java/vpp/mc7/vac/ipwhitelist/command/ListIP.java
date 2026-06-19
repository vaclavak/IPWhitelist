package vpp.mc7.vac.ipwhitelist.command;

import org.bukkit.ChatColor;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import vpp.mc7.vac.ipwhitelist.main.Main;

public class ListIP implements BasicCommand{
	
	private Main m;
	
	public ListIP(Main m) {
		this.m = m;
	}

	@Override
	public void execute(CommandSourceStack stack, String[] args) {
		m.reloadConfig();
		int listLength = m.getConfig().getStringList("allowed-ip-addresses").size();
		stack.getSender().sendMessage("List of allowed IP adresses:");
		int count = 0;
		for(String s : m.getConfig().getStringList("allowed-ip-addresses")) {
			count++;
			stack.getSender().sendMessage(count + ". | " + s);
		}
		
		stack.getSender().sendMessage(listLength + " addresses in total");
	}
	
	
	
	@Override
	public String permission() {
		return "vpp.mc7.command.listip";
	}

}
