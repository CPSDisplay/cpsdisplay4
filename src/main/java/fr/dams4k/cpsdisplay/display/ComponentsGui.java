package fr.dams4k.cpsdisplay.display;

import fr.dams4k.cpscore.ComponentManager;
import fr.dams4k.cpscore.component.Component;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class ComponentsGui extends Gui {
    public final Minecraft mc = Minecraft.getMinecraft();

    public void drawComponents() {
        ComponentManager.components.forEach(component -> drawComponent(component));
    }

    public void drawComponent(Component component) {
        System.out.println(component.text.getText());
    }
}
