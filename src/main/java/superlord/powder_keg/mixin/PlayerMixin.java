package superlord.powder_keg.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import superlord.powder_keg.registry.PowderKegItems;

@Mixin(Player.class)
public class PlayerMixin {

    @SuppressWarnings("resource")
    @Inject(at = @At("HEAD"), method = "isScoping()Z", cancellable = true)
	private void isScoping(CallbackInfoReturnable<Boolean> callBack) {
    	Player player = Minecraft.getInstance().player;
    	callBack.setReturnValue(player.isUsingItem() && player.getUseItem().is(Items.SPYGLASS) || player.isUsingItem() && player.getUseItem().is(PowderKegItems.SCOPED_RIFLE.get()));
    }
	
}