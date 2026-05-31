package net.just_s.camera;

import com.mrbysco.armorposer.client.gui.ArmorStandScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.language.I18n;

public class AnimatableArmorStandScreen extends ArmorStandScreen {
    private final ArmorStandCamera camera;

    public AnimatableArmorStandScreen(ArmorStandCamera armorStandCamera) {
        super(armorStandCamera.getPossessed());
        camera = armorStandCamera;
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        String translatedLabel = I18n.get("armorposer.gui.label.animate_button", new Object[0]);
        guiGraphics.drawString(
                this.font,
                translatedLabel,
                this.width - 20 - 100 - this.font.width(translatedLabel) - 10,
                174 + (10 - 9 / 2),
                16777215,
                true
        );
    }
}
