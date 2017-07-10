package gc.megafone;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import gc.megafone.comando.CmdMegafone;


public class Megafone extends JavaPlugin{

	public static Megafone plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		sendMessages();
		setupComandos();
		saveDefaultConfig();
	}
	
	private void sendMessages(){
		ConsoleCommandSender console = getServer().getConsoleSender();
		console.sendMessage(ChatColor.GREEN + "#########################################");
		console.sendMessage(ChatColor.GREEN + "# GcMegafone desenvolvido por @GCunhaBR #");
		console.sendMessage(ChatColor.GREEN + "#########################################");
	}
	
	private void setupComandos(){
		getCommand("megafone").setExecutor(new CmdMegafone());
	}
	
}
