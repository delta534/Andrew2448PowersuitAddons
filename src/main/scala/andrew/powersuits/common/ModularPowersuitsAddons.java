package andrew.powersuits.common;

//import andrew.powersuits.book.ItemBook;
import andrew.powersuits.client.ClientProxy;
import andrew.powersuits.network.AndrewPacketHandler;
import cpw.mods.fml.common.Mod;
<<<<<<< HEAD:src/main/scala/andrew/powersuits/common/ModularPowersuitsAddons.java
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
=======
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
>>>>>>> First pass at updating MPSA for 1.6.4.:src/minecraft/andrew/powersuits/common/ModularPowersuitsAddons.java
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.machinemuse.utils.MuseFileUtils;
import net.minecraftforge.common.Configuration;

<<<<<<< HEAD:src/main/scala/andrew/powersuits/common/ModularPowersuitsAddons.java
import java.io.File;

@Mod(modid = ModularPowersuitsAddons.modid, name = "Andrew's Modular Powersuits Addons", version = "@VERSION@", dependencies = "required-after:powersuits", acceptedMinecraftVersions = "[1.6,)")
@NetworkMod(clientSideRequired = true, serverSideRequired = true,
=======
@Mod(modid = "PowersuitAddons", name = "Andrew's Modular Powersuits Addons", version = "${env.BUILD_NUMBER}", dependencies = "required-after:powersuits", acceptedMinecraftVersions = "[1.6,)")
@NetworkMod(clientSideRequired = true, serverSideRequired = false,
>>>>>>> First pass at updating MPSA for 1.6.4.:src/minecraft/andrew/powersuits/common/ModularPowersuitsAddons.java
        clientPacketHandlerSpec = @SidedPacketHandler(channels = {"psa"}, packetHandler = AndrewPacketHandler.class),
        serverPacketHandlerSpec = @SidedPacketHandler(channels = {"psa"}, packetHandler = AndrewPacketHandler.class))
public class ModularPowersuitsAddons {

    public static GuiHandler guiHandler = new GuiHandler();

    //public static ItemBook book;

    @Instance("PowersuitAddons")
    public static ModularPowersuitsAddons INSTANCE;

    public final static String modid = "powersuitaddons";

    @SidedProxy(clientSide = "andrew.powersuits.client.ClientProxy", serverSide = "andrew.powersuits.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	INSTANCE = this;
    	File oldConfig = event.getSuggestedConfigurationFile();
        File newConfig = new File(event.getModConfigurationDirectory() + "/machinemuse/andrew/PowersuitsAddons.cfg");
        if (oldConfig.exists()) {
            try {
                MuseFileUtils.copyFile(oldConfig, newConfig);
                oldConfig.delete();
            } catch (Throwable e) {
            }
        }
        AddonConfig.init(new Configuration(newConfig));
        AddonConfig.setConfigFolderBase(event.getModConfigurationDirectory());
<<<<<<< HEAD:src/main/scala/andrew/powersuits/common/ModularPowersuitsAddons.java
        

        
=======
        AddonConfig.extractLang(AddonConfig.languages);
>>>>>>> First pass at updating MPSA for 1.6.4.:src/minecraft/andrew/powersuits/common/ModularPowersuitsAddons.java
        AddonConfig.initItems();
        proxy.registerRenderers();
        //proxy.readManuals();
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        //book = new ItemBook(AddonConfig.manualID);
        AddonComponent.populate();
        AddonConfig.loadPowerModules();
<<<<<<< HEAD:src/main/scala/andrew/powersuits/common/ModularPowersuitsAddons.java
        ClientProxy.loadCurrentLanguage();
=======
        AddonConfig.loadLang();
>>>>>>> First pass at updating MPSA for 1.6.4.:src/minecraft/andrew/powersuits/common/ModularPowersuitsAddons.java
        AddonConfig.loadOptions();
        proxy.registerHandlers();
        NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
        AddonRecipeManager.cheatyLeather();
        AddonRecipeManager.addRecipes();



    }

<<<<<<< HEAD:src/main/scala/andrew/powersuits/common/ModularPowersuitsAddons.java

=======
>>>>>>> First pass at updating MPSA for 1.6.4.:src/minecraft/andrew/powersuits/common/ModularPowersuitsAddons.java
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {


       AddonConfig.getConfig().save();



    }

}
