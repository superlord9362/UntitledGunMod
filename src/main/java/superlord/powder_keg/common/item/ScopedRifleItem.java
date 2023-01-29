package superlord.powder_keg.common.item;

import java.util.function.Predicate;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import superlord.powder_keg.common.entity.AbstractBullet;
import superlord.powder_keg.registry.PowderKegItems;

public class ScopedRifleItem extends ProjectileWeaponItem  {
	public static final int USE_DURATION = 1200;
	public static final float ZOOM_FOV_MODIFIER = 0.1F;

	public ScopedRifleItem(Properties p_41383_) {
		super(p_41383_);
	}

	public int getUseDuration(ItemStack p_151222_) {
		return 1200;
	}

	public UseAnim getUseAnimation(ItemStack p_151224_) {
		return UseAnim.SPYGLASS;
	}

	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		return ItemUtils.startUsingInstantly(world, player, hand);
	}

	public void releaseUsing(ItemStack p_151213_, Level p_151214_, LivingEntity p_151215_, int p_151216_) {
		this.stopUsing(p_151215_);
	}

	private void stopUsing(LivingEntity p_151207_) {
		p_151207_.playSound(SoundEvents.SPYGLASS_STOP_USING, 1.0F, 1.0F);
		Player player = (Player) p_151207_;
		Level world = p_151207_.level;
		boolean flag = player.getAbilities().instabuild;
		ItemStack stack = new ItemStack(this);
		ItemStack itemstack = player.getProjectile(stack);
		if (!itemstack.isEmpty() || flag) {
			if (itemstack.isEmpty()) {
				itemstack = new ItemStack(PowderKegItems.BULLET.get());
			}
			boolean flag1 = player.getAbilities().instabuild;
			if (!world.isClientSide) {
				BulletItem bulletitem = (BulletItem)(itemstack.getItem() instanceof BulletItem ? itemstack.getItem() : PowderKegItems.BULLET.get());
				AbstractBullet bullet = bulletitem.createBullet(world, itemstack, player);
				bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
				bullet.setBaseDamage(5.0D);
				world.addFreshEntity(bullet);
				stack.hurtAndBreak(1, player, (p_40665_) -> {
					p_40665_.broadcastBreakEvent(player.getUsedItemHand());
				});
				player.getCooldowns().addCooldown(this, 50);
			}
			world.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
			if (!flag1 && !player.getAbilities().instabuild) {
				itemstack.shrink(1);
				if (itemstack.isEmpty()) {
					player.getInventory().removeItem(itemstack);
				}
			}
		}
	}

	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return BULLET_ONLY;
	}

	@Override
	public int getDefaultProjectileRange() {
		return 50;
	}

	public static final Predicate<ItemStack> BULLET_ONLY = (p_43017_) -> {
		return p_43017_.is(PowderKegItems.BULLET.get());
	};

}
