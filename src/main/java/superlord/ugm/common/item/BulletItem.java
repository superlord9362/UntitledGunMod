package superlord.ugm.common.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import superlord.ugm.common.entity.AbstractBullet;
import superlord.ugm.common.entity.Bullet;

public class BulletItem extends Item {
	public BulletItem(Item.Properties p_40512_) {
		super(p_40512_);
	}

	public AbstractBullet createBullet(Level level, ItemStack stack, LivingEntity entity) {
		Bullet bullet = new Bullet(level, entity);
		return bullet;
	}

}
