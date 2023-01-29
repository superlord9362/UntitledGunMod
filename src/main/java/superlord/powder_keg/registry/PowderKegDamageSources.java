package superlord.powder_keg.registry;

import javax.annotation.Nullable;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.Entity;
import superlord.powder_keg.common.entity.AbstractBullet;

public class PowderKegDamageSources {
	
	public static DamageSource bullet(AbstractBullet p_19347_, @Nullable Entity p_19348_) {
	      return (new IndirectEntityDamageSource("bullet", p_19347_, p_19348_)).setProjectile();
	   }


}
