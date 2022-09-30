package superlord.ugm.client.render;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.ugm.UGM;
import superlord.ugm.common.entity.Bullet;

@OnlyIn(Dist.CLIENT)
public class BulletRenderer extends EntityRenderer<Bullet> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(UGM.MOD_ID, "textures/entity/bullet.png");

    public BulletRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(Bullet entity) {
        return TEXTURE;
    }
    
}
