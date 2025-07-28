package fr.dams4k.cpsdisplay.events;

import fr.dams4k.cpscore.CPSCore;
import fr.dams4k.cpscore.ComponentInterface;
import fr.dams4k.cpsdisplay.CPSDisplay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionEvents {
    private final Minecraft mc = Minecraft.getMinecraft();
    private final GameSettings gs = mc.gameSettings;

    public static Map<KeyBinding, List<Long>> clicks = new HashMap<>();

    @SubscribeEvent
    public void onMouseEvent(MouseEvent event) {
        onAction();
    }

    @SubscribeEvent
    public void onKeyboardEvent(InputEvent.KeyInputEvent event) {
        onAction();
    }

    public void onAction() {
        long time = System.currentTimeMillis();
        for (KeyBinding keyBinding : gs.keyBindings) {
            if (keyBinding.isKeyDown()) {
                clicks.putIfAbsent(keyBinding, new ArrayList<>());
                List<Long> keybindClicks = clicks.get(keyBinding);
                keybindClicks.add(time);
            }
        }
    }

    public static Integer getKeybindPS(KeyBinding keyBinding) {
        long time = System.currentTimeMillis();
        List<Long> keybindClicks = clicks.getOrDefault(keyBinding, new ArrayList<>());
        keybindClicks.removeIf(e -> e + 1000l < time);
        return keybindClicks.size();
    }
}
