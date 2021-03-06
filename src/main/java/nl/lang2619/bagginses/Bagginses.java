package nl.lang2619.bagginses;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import nl.lang2619.bagginses.config.ConfigHandler;
import nl.lang2619.bagginses.items.ModItems;
import nl.lang2619.bagginses.proxy.CommonProxy;
import nl.lang2619.bagginses.references.Defaults;

import java.io.File;

/**
 * Created by Tim on 7/29/2014.
 */
@Mod(modid = Defaults.MODID, version = Defaults.VERSION, name = Defaults.NAME)
public class Bagginses {
    @Mod.Instance(Defaults.MODID)
    public static Bagginses instance;

    @SidedProxy(clientSide = Defaults.CLIENTPROXY, serverSide = Defaults.COMMONPROXY)
    public static CommonProxy proxy;

    public static GuiHandler guiHandler = new GuiHandler();

    public static CreativeTabs BagTab = new BagTab(CreativeTabs.getNextID(), "Bagginses");

    public static String path;

    public static Configuration configuration;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        path = event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Defaults.MODID.toLowerCase() + File.separator;
        ConfigHandler.init(path);

        ModItems.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        instance = this;
        NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
