package vpp.mc7.vac.ipwhitelist.listener;

import java.net.InetAddress;
import java.util.ArrayList;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import net.md_5.bungee.api.ChatColor;
import vpp.mc7.vac.ipwhitelist.main.Main;

public class JoinListener implements Listener{
	
	private Main m;
	
	public JoinListener(Main m) {
		this.m = m;
	}
	
	
	@EventHandler
	public void onPreLogin(AsyncPlayerPreLoginEvent e) {
		String UUID = e.getUniqueId().toString();
		String name = e.getName();
		InetAddress ip = e.getAddress();
		m.reloadConfig();
		
		boolean logs = m.getConfig().getBoolean("enable-logging");
		
		if(!m.getConfig().getBoolean("enabled")) {
			return;
		}
		
		ArrayList<String> allowedIPs = new ArrayList<String>(m.getConfig().getStringList("allowed-ip-addresses"));
		
		if(allowedIPs.contains(ip.getHostAddress())) {
			if(logs) {
				m.getLogger().info("ALLOWED CONNECTION: " + name + " | IP:" + ip.getHostAddress() + " | UUID:" + UUID);
			}
			return;
		}
		
		String message = m.getConfig().getString("kick-message");
		message = message.replace("{IP}", ip.toString());
		message = message.replace("{NAME}", name);
		message = message.replace("{UUID}", UUID);
		
		e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatColor.translateAlternateColorCodes('&', message));
		
		if(logs) {
			m.getLogger().info("BLOCKED CONNECTION: " + name + " | IP:" + ip.getHostAddress() + " | UUID:" + UUID + " | " + message);
		}
		
		
	}

}
