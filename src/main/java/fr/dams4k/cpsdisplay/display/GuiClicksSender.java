package fr.dams4k.cpsdisplay.display;

import fr.dams4k.cpscore.ComponentInterface;
import fr.dams4k.cpsdisplay.events.ActionEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

public class GuiClicksSender implements ComponentInterface {
    private final Minecraft mc = Minecraft.getMinecraft();
    private final GameSettings gs = mc.gameSettings;

    @Override
    public Integer getFPS() {
        return 0;
    }

    @Override
    public Integer getClicks(int i) {
        return 0;
    }

    @Override
    public Integer getBPS() {
        return 0;
    }

    @Override
    public Integer getAttack() {
        return ActionEvents.getKeybindPS(gs.keyBindAttack);
    }

    @Override
    public Integer getUseItem() {
        return ActionEvents.getKeybindPS(gs.keyBindUseItem);
    }
}
