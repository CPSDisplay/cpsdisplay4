package fr.dams4k.cpsdisplay.proxy;

import fr.dams4k.cpscore.CPSCore;
import fr.dams4k.cpscore.ComponentManager;
import fr.dams4k.cpscore.component.CPosition;
import fr.dams4k.cpscore.component.CText;
import fr.dams4k.cpscore.component.Component;
import fr.dams4k.cpsdisplay.CPSDisplay;
import fr.dams4k.cpsdisplay.display.GuiClicksSender;
import fr.dams4k.cpsdisplay.display.GuiEvents;
import fr.dams4k.cpsdisplay.events.ActionEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy {
    public static final KeyBinding CPS_OVERLAY_CONFIG = new KeyBinding("cpsdisplay.key.opengui", Keyboard.KEY_P, "cpsdisplay.category.cpsdisplay");

    @Override
    public void preInit() {
    }

    @Override
    public void init() {
        ClientRegistry.registerKeyBinding(CPS_OVERLAY_CONFIG);
        MinecraftForge.EVENT_BUS.register(new ActionEvents());
        MinecraftForge.EVENT_BUS.register(new GuiEvents());

        CPSCore.init(CPSDisplay.getModFolder(), new GuiClicksSender());
        ComponentManager.load();

        Component component = new Component();
        component.position = new CPosition(50, 50, 1);
        component.setName("default");
//        component.text = new CText("[{$attack} | {$useItem}] CPS", "ffffff");²

        ComponentManager.saveComponent(component);
    }

    public static boolean getUnicodeFlag() {
        // Doing this for futur minecraft version, not all minecraft version have "fontRenderObj" called this way
        return Minecraft.getMinecraft().fontRendererObj.getUnicodeFlag();
    }
}
