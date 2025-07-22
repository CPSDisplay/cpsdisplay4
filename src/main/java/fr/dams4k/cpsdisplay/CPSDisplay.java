package fr.dams4k.cpsdisplay;

import fr.dams4k.cpscore.CPSCore;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "cpsdisplay", useMetadata=true)
public class CPSDisplay {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("Dirt: " + Blocks.dirt.getUnlocalizedName());
		// Below is a demonstration of an access-transformed class access.
        System.out.println("Color State: " + new GlStateManager.Color());

        CPSCore core = new CPSCore();
        core.testGson();
    }
}
