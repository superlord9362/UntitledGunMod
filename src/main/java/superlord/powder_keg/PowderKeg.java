package superlord.powder_keg;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import com.google.gson.JsonElement;

import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import superlord.powder_keg.registry.PowderKegEntities;
import superlord.powder_keg.registry.PowderKegItems;

@Mod(PowderKeg.MOD_ID)
@Mod.EventBusSubscriber(modid = PowderKeg.MOD_ID)
public class PowderKeg {

	public static final String MOD_ID = "powder_keg";

	
	public PowderKeg() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		PowderKegItems.REGISTER.register(bus);	
		PowderKegEntities.REGISTER.register(bus);
	}

	public final static CreativeModeTab GROUP = new CreativeModeTab(PowderKeg.MOD_ID + ".item_group") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(PowderKegItems.BULLET.get());
		}
	};
	
	class UGMItemModels {
		private final BiConsumer<ResourceLocation, Supplier<JsonElement>> output;
		
		public UGMItemModels(BiConsumer<ResourceLocation, Supplier<JsonElement>> p_125082_) {
			this.output = p_125082_;
		}
		
		private void generateFlatItem(Item p_125089_, ModelTemplate p_125090_) {
			p_125090_.create(ModelLocationUtils.getModelLocation(p_125089_), TextureMapping.layer0(p_125089_), this.output);
		}

		@SubscribeEvent
		public void run() {
		      this.generateFlatItem(PowderKegItems.BULLET.get(), ModelTemplates.FLAT_ITEM);
		}
	}
}
