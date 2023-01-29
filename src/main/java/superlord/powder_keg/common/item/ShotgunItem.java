package superlord.powder_keg.common.item;

import java.util.function.Predicate;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.Level;
import superlord.powder_keg.common.entity.AbstractBullet;
import superlord.powder_keg.registry.PowderKegItems;

public class ShotgunItem extends ProjectileWeaponItem implements Vanishable {

	public ShotgunItem(Properties p_43009_) {
		super(p_43009_);
	}
	
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		boolean flag = player.getAbilities().instabuild;
		ItemStack stack = new ItemStack(this);
		ItemStack itemstack = player.getProjectile(stack);
		if (!itemstack.isEmpty() && itemstack.getCount() >= 3 || flag) {
			if (itemstack.isEmpty()) {
				itemstack = new ItemStack(PowderKegItems.BULLET.get());
			}
			boolean flag1 = player.getAbilities().instabuild;
			if (!world.isClientSide) {
				BulletItem bulletitem = (BulletItem)(itemstack.getItem() instanceof BulletItem ? itemstack.getItem() : PowderKegItems.BULLET.get());
				AbstractBullet bullet = bulletitem.createBullet(world, itemstack, player);
				AbstractBullet bullet1 = bulletitem.createBullet(world, itemstack, player);
				AbstractBullet bullet2 = bulletitem.createBullet(world, itemstack, player);
				bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 5F, 10.0F);
				bullet1.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 5F, 0.0F);
				bullet2.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 5F, -10.0F);
				bullet.setBaseDamage(5.0D);
				bullet1.setBaseDamage(5.0D);
				bullet2.setBaseDamage(5.0D);
				world.addFreshEntity(bullet);
				world.addFreshEntity(bullet1);
				world.addFreshEntity(bullet2);
				stack.hurtAndBreak(1, player, (p_40665_) -> {
					p_40665_.broadcastBreakEvent(player.getUsedItemHand());
				});
				player.getCooldowns().addCooldown(this, 75);
			}
			world.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
			if (!flag1 && !player.getAbilities().instabuild) {
				itemstack.shrink(3);
				if (itemstack.isEmpty()) {
					player.getInventory().removeItem(itemstack);
				}
			}
			player.awardStat(Stats.ITEM_USED.get(this));
			return InteractionResultHolder.consume(stack);
		} else {
			return InteractionResultHolder.fail(stack);
		}
	}
	
	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return BULLET_ONLY;
	}

	@Override
	public int getDefaultProjectileRange() {
		return 25;
	}

	public static final Predicate<ItemStack> BULLET_ONLY = (p_43017_) -> {
		return p_43017_.is(PowderKegItems.BULLET.get());
	};

}
