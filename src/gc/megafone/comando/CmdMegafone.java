package gc.megafone.comando;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import gc.megafone.Megafone;
import gc.megafone.utils.CooldownAPI;

public class CmdMegafone implements CommandExecutor{
	
	private CooldownAPI cd;
	private String msgPerm;
	private List<String> msgMegafone;
	
	public CmdMegafone() {
		this.cd = new CooldownAPI(Megafone.plugin.getConfig().getInt("Delay"));
		this.msgMegafone = Megafone.plugin.getConfig().getStringList("Msg");
		this.msgPerm = Megafone.plugin.getConfig().getString("SemPerm").replace("&", "§");
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player p = (Player) sender;
		
		
		if(cmd.getName().equalsIgnoreCase("megafone")){
			if(!p.hasPermission("gcmegafone.usar")){
				p.sendMessage(msgPerm);
				return true;
			}
			
			if(cd.hasCD(p)){
				p.sendMessage("§cVocê deve aguardar para usar esse comando.");
				return true;
			}
			
			if(args.length == 0){
				p.sendMessage("§cErro de Sintaxe");
				p.sendMessage("§cUse: §6/megafone <mensagem>");
				return true;
			}
			
			String mensagem = String.join(" ", args);
			
			for(String msg : msgMegafone){
				msg = msg.replace("{jogador}", p.getName()).replace("{mensagem}", mensagem).replace("&", "§");
				Bukkit.broadcastMessage(msg);
			}
			
			cd.addCD(p);
			
		}
		
		return false;
	}

}
