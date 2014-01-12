package andrew.powersuits.modules;

import andrew.powersuits.common.AddonUtils;
import cpw.mods.fml.common.FMLCommonHandler;
import ic2.api.energy.IEnergyNet;
import ic2.api.energy.tile.IEnergyConductor;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergySource;
import net.machinemuse.api.IModularItem;
import net.machinemuse.api.moduletrigger.IRightClickModule;
import net.machinemuse.powersuits.common.ModCompatability;
import net.machinemuse.powersuits.item.ItemComponent;
import net.machinemuse.powersuits.powermodule.PowerModuleBase;
import net.machinemuse.utils.MuseCommonStrings;
import net.machinemuse.utils.MuseItemUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import java.text.DecimalFormat;
import java.util.List;

public class EUReaderModule extends PowerModuleBase implements IRightClickModule, IEnergyNet {
	
	public static final String MODULE_EU_READER = "EU Reader";
	
	public EUReaderModule(List<IModularItem> validItems) {
		super(validItems);
		addInstallCost(MuseItemUtils.copyAndResize(ItemComponent.controlCircuit, 1));
		addInstallCost(ModCompatability.getIC2Item("ecMeter"));
	}

	@Override
	public String getTextureFile() {
		return "eureader";
	}

	@Override
	public String getCategory() {
		return MuseCommonStrings.CATEGORY_ENERGY;
	}

	@Override
	public String getDataName() {
		return MODULE_EU_READER;
	}

    @Override
    public String getLocalizedName() {
        return StatCollector.translateToLocal("module.euReader.name");
    }

	@Override
	public String getDescription() {
		return "An IC2 EU Reader integrated in your power tool.";
	}

	@Override
	public void onRightClick(EntityPlayer player, World world, ItemStack item) {
		
	}

	@Override
	public void onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		
	}

	@Override
	public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

	    if ((((tileEntity instanceof IEnergySource)) || ((tileEntity instanceof IEnergyConductor)) || ((tileEntity instanceof IEnergySink))) && (!FMLCommonHandler.instance().getEffectiveSide().isClient())) {
	      NBTTagCompound nbtData = AddonUtils.getNBTTag(itemStack);

	      long currentTotalEnergyEmitted = getTotalEnergyEmitted(tileEntity);
	      long currentTotalEnergySunken = getTotalEnergySunken(tileEntity);
	      long currentMeasureTime = world.getWorldTime();

	      if ((nbtData.getInteger("lastMeasuredTileEntityX") != x) || (nbtData.getInteger("lastMeasuredTileEntityY") != y) || (nbtData.getInteger("lastMeasuredTileEntityZ") != z))
	      {
	        nbtData.setInteger("lastMeasuredTileEntityX", x);
	        nbtData.setInteger("lastMeasuredTileEntityY", y);
	        nbtData.setInteger("lastMeasuredTileEntityZ", z);

<<<<<<< HEAD:src/main/scala/andrew/powersuits/modules/EUReaderModule.java
	        player.addChatMessage("Starting new measurement");
=======
	        player.sendChatToPlayer(ChatMessageComponent.createFromText("Starting new measurement"));
>>>>>>> First pass at updating MPSA for 1.6.4.:src/minecraft/andrew/powersuits/modules/EUReaderModule.java
	      } 
	      else {
	        long measurePeriod = currentMeasureTime - nbtData.getLong("lastMeasureTime");
	        if (measurePeriod < 1L) measurePeriod = 1L;

	        double deltaEmitted = (currentTotalEnergyEmitted - nbtData.getLong("lastTotalEnergyEmitted")) / measurePeriod;
	        double deltaSunken = (currentTotalEnergySunken - nbtData.getLong("lastTotalEnergySunken")) / measurePeriod;

	        DecimalFormat powerFormat = new DecimalFormat("0.##");

<<<<<<< HEAD:src/main/scala/andrew/powersuits/modules/EUReaderModule.java
	        player.addChatMessage("Measured power [EU/t]: " + powerFormat.format(deltaSunken) + " in " + powerFormat.format(deltaEmitted) + " out " + powerFormat.format(deltaSunken - deltaEmitted) + " gain" + " (avg. over " + measurePeriod + " ticks)");
=======
	        player.sendChatToPlayer(ChatMessageComponent.createFromText("Measured power [EU/t]: " + powerFormat.format(deltaSunken) + " in " + powerFormat.format(deltaEmitted) + " out " + powerFormat.format(deltaSunken - deltaEmitted) + " gain" + " (avg. over " + measurePeriod + " ticks)"));
>>>>>>> First pass at updating MPSA for 1.6.4.:src/minecraft/andrew/powersuits/modules/EUReaderModule.java
	      }

	      nbtData.setLong("lastTotalEnergyEmitted", currentTotalEnergyEmitted);
	      nbtData.setLong("lastTotalEnergySunken", currentTotalEnergySunken);
	      nbtData.setLong("lastMeasureTime", currentMeasureTime);

	      return true;
	    }

	    return false;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int par4) {
		
	}

	//Added Methods
	
	@Override
	public TileEntity getTileEntity(World world, int x, int y, int z) {
		
		return null;
	}

	@Override
	public TileEntity getNeighbor(TileEntity te, ForgeDirection dir) {
		
		return null;
	}

	@Override
	public long getTotalEnergyEmitted(TileEntity tileEntity) {
		
		return 0;
	}

	@Override
	public long getTotalEnergySunken(TileEntity tileEntity) {
		
		return 0;
	}

	@Override
	public int getPowerFromTier(int tier) {
		
		return 0;
	}
}
