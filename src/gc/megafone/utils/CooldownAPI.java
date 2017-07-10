package gc.megafone.utils;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.entity.Player;

public class CooldownAPI {
	
	private HashMap<Player, Long> cd = new HashMap<>();
	private int tempo;
	
	public CooldownAPI(int tempo) {
		this.tempo = tempo;
	}
	
	public void addCD(Player p){
		cd.put(p, TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis()));
	}
	
	public boolean hasCD(Player p){
		if(!cd.containsKey(p)) return false;
		int resultado = (int) (TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis()) - cd.get(p));
		if(resultado < this.tempo) return true;
		return false;
	}
	
}
