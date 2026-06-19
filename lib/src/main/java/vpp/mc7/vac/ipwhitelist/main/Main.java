package vpp.mc7.vac.ipwhitelist.main;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import vpp.mc7.vac.ipwhitelist.command.AllowIP;
import vpp.mc7.vac.ipwhitelist.command.ClearIPList;
import vpp.mc7.vac.ipwhitelist.command.IPBlock;
import vpp.mc7.vac.ipwhitelist.command.ListIP;
import vpp.mc7.vac.ipwhitelist.command.RemoveIP;
import vpp.mc7.vac.ipwhitelist.listener.JoinListener;

public class Main extends JavaPlugin{
	
	public static String version = "1.0";
	
	@Override
    public void onEnable() {
		saveDefaultConfig();
		
		getLogger().info("IPWhitelist v" + version + " is now enabled \n IPWhitelist by vaclavak and 7mc");
		getLogger().info("IPWhitelist uses bStats to collect the number of servers using the plugin. This can be disabled in the bStats config file.");
		
		
		int pluginId = 32088;
		Metrics metrics = new Metrics(this, pluginId);
		getServer().getPluginManager().registerEvents(new JoinListener(this), this);
		
		this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            event.registrar().register("allowip", "Allows an IP address", new AllowIP(this));
            event.registrar().register("removeip", "Removes an IP address", new RemoveIP(this));
            event.registrar().register("listip", "Lists the allowed IP addresses", new ListIP(this));
            event.registrar().register("ipwhitelist", "Enables or disables the IP blocking", new IPBlock(this));
            event.registrar().register("cleariplist", "Clears the list of allowed IP addresses", new ClearIPList(this));
        });
    }
	
	@Override
	public void onDisable() {
		getLogger().info("Disabling IPWhitelist");
	}
	
	
}
