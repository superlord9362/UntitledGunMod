package superlord.ugm.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.ugm.UGM;
import superlord.ugm.common.entity.Bullet;

public class UGMEntities {
	
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, UGM.MOD_ID);
    
    public static final RegistryObject<EntityType<Bullet>> BULLET = REGISTER.register("bullet", () -> EntityType.Builder.<Bullet>of(Bullet::new, MobCategory.MISC).sized(0.5F, 0.5F).build(new ResourceLocation(UGM.MOD_ID, "bullet").toString()));
    
}
