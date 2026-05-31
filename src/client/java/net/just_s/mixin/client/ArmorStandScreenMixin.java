package net.just_s.mixin.client;

import com.mrbysco.armorposer.client.gui.ArmorStandScreen;
import net.just_s.PossessiveModClient;
import net.just_s.camera.ArmorStandCamera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArmorStandScreen.class)
public class ArmorStandScreenMixin {
    @Unique
    private boolean possessive$hasPossessiveButtons = false;

    @Inject(method = "init", at = @At("RETURN"))
    private void possessive$onInit(CallbackInfo ci) {
        Object camera = PossessiveModClient.cameraHandler.getCamera();
        if (!(camera instanceof ArmorStandCamera)) return;
        ArmorStandScreen self = (ArmorStandScreen) (Object) this;
        ArmorStandCamera.addPossessiveButtons(self);
        possessive$hasPossessiveButtons = true;
    }

    @Inject(method = "render", at = @At("RETURN"))
    private void possessive$onRender(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        if (!possessive$hasPossessiveButtons) return;
        ArmorStandCamera.renderPossessiveLabel((ArmorStandScreen) (Object) this, guiGraphics);
    }
}
