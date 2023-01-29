package superlord.powder_keg.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import superlord.powder_keg.PowderKeg;
import superlord.powder_keg.client.model.BulletModel;
import superlord.powder_keg.client.render.BulletRenderer;
import superlord.powder_keg.registry.PowderKegEntities;

@Mod.EventBusSubscriber(modid = PowderKeg.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

	public static ModelLayerLocation BULLET = new ModelLayerLocation(new ResourceLocation(PowderKeg.MOD_ID + "bullet"), "bullet");
	
	@SubscribeEvent
	public static void layerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ClientEvents.BULLET, BulletModel::createBodyLayer);
	}

	@SubscribeEvent
	public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		EntityRenderers.register(PowderKegEntities.BULLET.get(), BulletRenderer::new);
	}

}
