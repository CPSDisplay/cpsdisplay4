package fr.dams4k.cpsdisplay.display;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiEvents {
    public static final Minecraft mc = Minecraft.getMinecraft();
    public static final ComponentsGui componentsGui = new ComponentsGui();

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post event) {
        if (mc.currentScreen instanceof GuiIngameMenu) return;

        // We want components to be drawn at the same time as the hotbar
        if (event.type != RenderGameOverlayEvent.ElementType.HOTBAR) return;

        componentsGui.drawComponents();
    }
}
