package uk.debosoft;

import org.bukkit.entity.Player;
import uk.debosoft.config.group;

public class PDPlayer {
	private Player p;
	private boolean ignore = false;
	private group Group;
	
	public PDPlayer(Player p) {
		super();
		this.p = p;
	}
	public Player getP() {
		return p;
	}
	public void setP(Player p) {
		this.p = p;
	}
	public boolean isIgnore() {
		return ignore;
	}
	public void setIgnore(boolean ignore) {
		this.ignore = ignore;
	}
	
	public group getGroup() {
		return Group;
	}
	public void setGroup(group group) {
		Group = group;
	}
	
	public void findGroup() {
		this.ignore = true;
		for (group g : payday.conf.getGroups()) {
			if (this.p.hasPermission("payday." + g.getName())) {
				this.Group = g;
				this.ignore = false;
				return;
			}
		}
	}
}
