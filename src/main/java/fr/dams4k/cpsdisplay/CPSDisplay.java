package fr.dams4k.cpsdisplay;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.dams4k.cpscore.CPSCore;
import fr.dams4k.cpscore.Component;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

@Mod(modid = "cpsdisplay", useMetadata=true)
public class CPSDisplay {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) throws IOException {
        CPSCore.init(getModFolder());

        GameSettings gs = Minecraft.getMinecraft().gameSettings;
//        gs.

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Component component = new Component();
        component.text = "[{0} | {1}] CPS";
        gson.toJson(component, new FileWriter(getModFolder().resolve("0.json").toString()));
    }

    public static Path getModFolder() {
        return Loader.instance().getConfigDir().toPath().resolve("cpsdisplay");
    }
}
