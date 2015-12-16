package uk.debosoft.rewarders;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import uk.debosoft.PDPlayer;
import uk.debosoft.Rewarder;
import uk.debosoft.payday;

public class ItemRewarder extends Rewarder {

	@Override
	public void pay(PDPlayer pp) {
		PlayerInventory pi = pp.getP().getInventory();
		if(pp.getGroup().getLimit() >=0.D || getAmount(pi, (int)payday.conf.getRewardItem())>pp.getGroup().getLimit()) {
			pi.addItem(new ItemStack(payday.conf.getRewardItem(), (int) pp.getGroup().getAmount()));
		}
	}
	
	public static int getAmount(PlayerInventory inventory, int id)
	{
		ItemStack[] items = inventory.getContents();
		int has = 0;
		for (ItemStack item : items)
		{
			if ((item != null) && (item.getTypeId() == id) && (item.getAmount() > 0))
			{
	                has += item.getAmount();
	        }
		}
		return has;
	}
}
