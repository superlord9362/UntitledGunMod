package superlord.ugm.common.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import superlord.ugm.registry.UGMEntities;
import superlord.ugm.registry.UGMItems;

public class Bullet extends AbstractBullet {

	public Bullet(EntityType<? extends Bullet> bullet, Level world) {
		super(bullet, world);
	}

	public Bullet(Level level, double p_36862_, double p_36863_, double p_36864_) {
		super(UGMEntities.BULLET.get(), p_36862_, p_36863_, p_36864_, level);
	}

	public Bullet(Level p_36866_, LivingEntity p_36867_) {
		super(UGMEntities.BULLET.get(), p_36867_, p_36866_);
	}

	public Item getDefaultItem() {
		return UGMItems.BULLET.get();
	}

}
