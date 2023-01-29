package superlord.powder_keg.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.powder_keg.PowderKeg;
import superlord.powder_keg.common.entity.Bullet;

public class PowderKegEntities {
	
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, PowderKeg.MOD_ID);
    
    public static final RegistryObject<EntityType<Bullet>> BULLET = REGISTER.register("bullet", () -> EntityType.Builder.<Bullet>of(Bullet::new, MobCategory.MISC).sized(0.5F, 0.5F).build(new ResourceLocation(PowderKeg.MOD_ID, "bullet").toString()));
    
}
