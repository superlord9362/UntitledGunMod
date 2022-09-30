package superlord.ugm.common.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;
import superlord.ugm.client.ClientEvents;

public class ScopedRifleItem extends Item {
	public static final int USE_DURATION = 1200;
	public static final float ZOOM_FOV_MODIFIER = 0.1F;

	public ScopedRifleItem(Properties p_41383_) {
		super(p_41383_);
	}

	public int getUseDuration(ItemStack p_151222_) {
		return 1200;
	}

	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ClientEvents.zooming = true;
		return ItemUtils.startUsingInstantly(world, player, hand);
	}

	public void releaseUsing(ItemStack p_151213_, Level p_151214_, LivingEntity p_151215_, int p_151216_) {
		this.stopUsing(p_151215_);
	}

	private void stopUsing(LivingEntity p_151207_) {
		ClientEvents.zooming = false;
		p_151207_.playSound(SoundEvents.SPYGLASS_STOP_USING, 1.0F, 1.0F);
	}

}
