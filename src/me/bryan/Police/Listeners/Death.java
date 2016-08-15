package me.bryan.Police.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.bryan.Police.Main;
import me.bryan.Police.Wanted.WantedSystem;

public class Death implements Listener {
	Main main;

	public Death(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		if (player instanceof Player) {
			if (Main.policeMode.contains(player.getName())) {
				Main.saveInventory(player);
			}

			if (WantedSystem.wanted.containsKey(player.getName())) {
				WantedSystem.wanted.remove(player.getName());
			}
			if (WantedSystem.wantedLevel.containsKey(player.getName())) {
				WantedSystem.wantedLevel.remove(player.getName());
			}
		}

	}

}
