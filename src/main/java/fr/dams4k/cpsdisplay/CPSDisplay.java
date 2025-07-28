package fr.dams4k.cpsdisplay;

import fr.dams4k.cpscore.CPSCore;
import fr.dams4k.cpscore.ComponentInterface;
import fr.dams4k.cpscore.component.CText;
import fr.dams4k.cpsdisplay.events.ActionEvents;
import fr.dams4k.cpsdisplay.proxy.ClientProxy;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.nio.file.Path;

@Mod(modid = "cpsdisplay", useMetadata=true, clientSideOnly = true, acceptableRemoteVersions = "*")
public class CPSDisplay {
    @SidedProxy(clientSide = "fr.dams4k.cpsdisplay.proxy.ClientProxy")
    public static ClientProxy clientProxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        clientProxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        clientProxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        clientProxy.postInit();
    }

    public static Path getModFolder() {
        return Loader.instance().getConfigDir().toPath().resolve("cpsdisplay");
    }
}
