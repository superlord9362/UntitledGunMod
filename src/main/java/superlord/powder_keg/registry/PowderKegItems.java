package superlord.powder_keg.registry;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.powder_keg.PowderKeg;
import superlord.powder_keg.common.item.BulletItem;
import superlord.powder_keg.common.item.RevolverItem;
import superlord.powder_keg.common.item.RifleItem;
import superlord.powder_keg.common.item.ScopedRifleItem;
import superlord.powder_keg.common.item.ShotgunItem;

public class PowderKegItems {
	
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, PowderKeg.MOD_ID);
    
    public static final RegistryObject<BulletItem> BULLET = REGISTER.register("bullet", () -> new BulletItem(new Item.Properties().tab(PowderKeg.GROUP)));
    public static final RegistryObject<RifleItem> RIFLE = REGISTER.register("rifle", () -> new RifleItem(new Item.Properties().tab(PowderKeg.GROUP).stacksTo(1)));
    public static final RegistryObject<ScopedRifleItem> SCOPED_RIFLE = REGISTER.register("scoped_rifle", () -> new ScopedRifleItem(new Item.Properties().tab(PowderKeg.GROUP).stacksTo(1)));
    public static final RegistryObject<RevolverItem> REVOLVER = REGISTER.register("revolver", () -> new RevolverItem(new Item.Properties().tab(PowderKeg.GROUP).stacksTo(1)));
    public static final RegistryObject<ShotgunItem> SHOTGUN = REGISTER.register("shotgun", () -> new ShotgunItem(new Item.Properties().tab(PowderKeg.GROUP).stacksTo(1)));
    
}
