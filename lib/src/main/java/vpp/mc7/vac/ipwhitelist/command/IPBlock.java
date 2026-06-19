package vpp.mc7.vac.ipwhitelist.command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.bukkit.ChatColor;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import vpp.mc7.vac.ipwhitelist.main.Main;

public class IPBlock implements BasicCommand{
	
	private Main m;
	
	public IPBlock(Main m) {
		this.m = m;
	}
	
	@Override
	public void execute(CommandSourceStack stack, String[] args) {
		if(args.length == 0) {
			stack.getSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"&4Usage: /ipblock true|false|reload"));
			return;
		}
		
		if(args[0].equalsIgnoreCase("reload")) {
			m.reloadConfig();
			stack.getSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&2Reloaded config!"));
			return;
		}
		
		m.reloadConfig();
		m.getConfig().set("enabled", Boolean.valueOf(args[0]));
		stack.getSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&2IP Blocking is now set to: " + args[0]));
		m.saveConfig();
	}
	
	@Override
	public String permission() {
		return "vpp.mc7.command.ipblock";
	}

	@Override
	public Collection<String> suggest(final CommandSourceStack stack, final String[] args) {
		ArrayList<String> suggestions = new ArrayList<String>();
		suggestions.add("true");
		suggestions.add("false");
		suggestions.add("reload");
        return suggestions;
    }
	
	

}
