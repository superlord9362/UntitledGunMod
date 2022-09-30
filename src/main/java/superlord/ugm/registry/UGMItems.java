package superlord.ugm.registry;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.ugm.UGM;
import superlord.ugm.common.item.BulletItem;
import superlord.ugm.common.item.RifleItem;
import superlord.ugm.common.item.ScopedRifleItem;

public class UGMItems {
	
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, UGM.MOD_ID);
    
    public static final RegistryObject<BulletItem> BULLET = REGISTER.register("bullet", () -> new BulletItem(new Item.Properties().tab(UGM.GROUP)));
    public static final RegistryObject<RifleItem> RIFLE = REGISTER.register("rifle", () -> new RifleItem(new Item.Properties().tab(UGM.GROUP).stacksTo(1)));
    public static final RegistryObject<ScopedRifleItem> SCOPED_RIFLE = REGISTER.register("scoped_rifle", () -> new ScopedRifleItem(new Item.Properties().tab(UGM.GROUP).stacksTo(1)));

}
