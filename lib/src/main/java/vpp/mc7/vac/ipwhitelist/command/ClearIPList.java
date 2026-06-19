package vpp.mc7.vac.ipwhitelist.command;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import vpp.mc7.vac.ipwhitelist.main.Main;

public class ClearIPList implements BasicCommand{
	
	private Main m;
	
	public ClearIPList(Main m) {
		this.m = m;
	}

	@Override
	public void execute(CommandSourceStack stack, String[] args) {
		m.reloadConfig();
		ArrayList<String> IPList = new ArrayList<String>(m.getConfig().getStringList("allowed-addresses"));
		
		int IPAmount = IPList.size();
		
		IPList.clear();
		m.getConfig().set("allowed-ip-addresses", IPList);
		m.saveConfig();
		
		stack.getSender().sendMessage("Cleared " + IPAmount + " addresses");
	}
	
	@Override
	public String permission() {
		return "vpp.mc7.command.clearip";
	}

}
