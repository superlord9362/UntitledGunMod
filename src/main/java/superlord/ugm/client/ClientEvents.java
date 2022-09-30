package superlord.ugm.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import superlord.ugm.UGM;
import superlord.ugm.client.model.BulletModel;
import superlord.ugm.client.render.BulletRenderer;
import superlord.ugm.registry.UGMEntities;

@Mod.EventBusSubscriber(modid = UGM.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

	public static boolean zooming = false;

	public static ModelLayerLocation BULLET = new ModelLayerLocation(new ResourceLocation(UGM.MOD_ID + "bullet"), "bullet");

	@SubscribeEvent
	public static void increaseFov(net.minecraftforge.client.event.FOVModifierEvent event) {
		if (zooming) {
			event.setNewfov(0.1F);
		}
	}
	
	@SubscribeEvent
	public static void layerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ClientEvents.BULLET, BulletModel::createBodyLayer);
	}

	@SubscribeEvent
	public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		EntityRenderers.register(UGMEntities.BULLET.get(), BulletRenderer::new);
	}

}
