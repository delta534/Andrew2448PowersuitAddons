package andrew.powersuits.common;


import cpw.mods.fml.common.registry.GameRegistry;
import net.machinemuse.numina.recipe.JSONRecipeList;
import net.machinemuse.powersuits.common.ModCompatability;
import net.machinemuse.powersuits.item.ItemComponent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.logging.Level;
import java.util.logging.Logger;


public class AddonRecipeManager {

    public static void cheatyLeather() {
        if (AddonConfig.useCheatyLeatherRecipe && ModCompatability.isThermalExpansionLoaded()){

        cofh.util.ThermalExpansionHelper.addFurnaceRecipe(1350, new ItemStack(Item.rottenFlesh), new ItemStack(Item.leather));
        }
    }

    public static void oreRegistration() {

        OreDictionary.registerOre("ingotIron", new ItemStack(Item.ingotIron));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.glass));
        OreDictionary.registerOre("blockLapis", new ItemStack(Block.blockLapis));


    }

    public static void loadTERecipes () {

            GameRegistry.addRecipe(new ShapedOreRecipe(AddonComponent.solarPanel, true, new Object[]{"GGG", "CLC", " E ", Character.valueOf('G'), "blockGlass", Character.valueOf('C'), "conduitEnergyHardened", Character.valueOf('L'), "blockLapis", Character.valueOf('E'), "powerCoilSilver"}));
            GameRegistry.addRecipe(new ShapedOreRecipe(AddonComponent.magnet, true, new Object[] {"IGI", "SSS", "IGI", Character.valueOf('I'), "ingotIron", Character.valueOf('G'), "powerCoilGold", Character.valueOf('S'), "componentSolenoid" }));
            GameRegistry.addRecipe(new ShapedOreRecipe(AddonComponent.computerChip, true, new Object[] {" O ", "GMS", " E ", Character.valueOf('G'), "powerCoilGold", Character.valueOf('M'), "gearTin", Character.valueOf('S'), "powerCoilSilver", Character.valueOf('O'), "componentSolenoid", Character.valueOf('E'), "powerCoilElectrum" }));

    }


    public static void addRecipes() {
        ItemStack circuit = ItemComponent.wiring;
        ItemStack glass = new ItemStack(Block.glass);
        ItemStack glassPane = new ItemStack(Block.thinGlass);
        ItemStack lapis = new ItemStack(Item.dyePowder, 1, 4);
        ItemStack lapisBlock = new ItemStack(Block.blockLapis);
        ItemStack ironIngot = new ItemStack(Item.ingotIron);
        ItemStack redstoneBlock = new ItemStack(Block.blockRedstone);
        ItemStack diamond = new ItemStack(Item.diamond);
        ItemStack comparator = new ItemStack(Item.comparator);
        ItemStack goldIngot = new ItemStack(Item.ingotGold);
        ItemStack leather = new ItemStack(Item.leather);
        ItemStack rottenFlesh = new ItemStack(Item.rottenFlesh);
        ItemStack sugar = new ItemStack(Item.sugar);


       if (ModCompatability.vanillaRecipesEnabled()) {

            //===========================================================================================================================
            GameRegistry.addRecipe(new ShapedOreRecipe(AddonComponent.solarPanel, true, "PPP", "PLP", "PPP", 'P', glassPane, 'L', lapisBlock));
            GameRegistry.addRecipe(new ShapedOreRecipe(AddonComponent.magnet, true, "III", "SSS", "III", 'I', ironIngot, 'S', ItemComponent.solenoid));
            GameRegistry.addRecipe(new ShapedOreRecipe(AddonComponent.computerChip, true, "RCR", "GDG", 'R', redstoneBlock, 'C', comparator, 'G', goldIngot, 'D', diamond));
            //===========================================================================================================================
        }

        if (ModCompatability.UERecipesEnabled() && ModCompatability.isBasicComponentsLoaded()) {
            String basicCircuit = "basicCircuit";
            String advancedCircuit = "advancedCircuit";
            String eliteCircuit = "eliteCircuit";

            //===========================================================================================================================
            GameRegistry.addRecipe(new ShapedOreRecipe(AddonComponent.solarPanel, true, "GGG", "CLC", "SSS", 'G', glass, 'C', basicCircuit, 'L', lapisBlock, 'S', "plateSteel"));
            GameRegistry.addRecipe(new ShapedOreRecipe(AddonComponent.magnet, "ICI", "SSS", "ICI", 'I', ironIngot, 'C', advancedCircuit, 'S', ItemComponent.solenoid));
            GameRegistry.addRecipe(new ShapedOreRecipe(AddonComponent.computerChip, "CRC", "GDG", 'C', eliteCircuit, 'R', redstoneBlock, 'G', goldIngot, 'D', diamond));
            //===========================================================================================================================
        }

        if (ModCompatability.IC2RecipesEnabled() && ModCompatability.isIndustrialCraftLoaded()) {
            circuit = ModCompatability.getIC2Item("electronicCircuit");
            ItemStack advCircuit = ModCompatability.getIC2Item("advancedCircuit");
            String refIron = "ingotRefinedIron";
            String tin = "ingotTin";
            String copper = "ingotCopper";
            ItemStack reBattery = ModCompatability.getIC2Item("reBattery");
            ItemStack fullBattery = ModCompatability.getIC2Item("chargedReBattery");
            ItemStack energyCrystal = ModCompatability.getIC2Item("energyCrystal");
            ItemStack lapotronCrystal = ModCompatability.getIC2Item("lapotronCrystal");
            ItemStack iridiumOre = ModCompatability.getIC2Item("iridiumOre");
            ItemStack carbonPlate = ModCompatability.getIC2Item("carbonPlate");
            ItemStack machine = ModCompatability.getIC2Item("machine");
            ItemStack advMachine = ModCompatability.getIC2Item("advancedMachine");
            ItemStack gen = ModCompatability.getIC2Item("generator");
            ItemStack ovscanner = ModCompatability.getIC2Item("ovScanner");
            ovscanner.setItemDamage(1);
            ItemStack goldCable = ModCompatability.getIC2Item("doubleInsulatedGoldCableItem");

            //===========================================================================================================================
            GameRegistry.addRecipe(new ShapedOreRecipe(AddonComponent.solarPanel, true, "LGL", "GLG", "CBC", 'L', lapis, 'G', glass, 'C', circuit, 'B', gen));
            GameRegistry.addRecipe(new ShapedOreRecipe(AddonComponent.magnet, "ICI", "SSS", "ICI", 'I', ironIngot, 'C', advCircuit, 'S', ItemComponent.solenoid));
            GameRegistry.addRecipe(new ShapedOreRecipe(AddonComponent.computerChip, "CSC", "GGG", 'C', advCircuit, 'S', ovscanner, 'G', goldCable));
            //===========================================================================================================================
        }

        if (ModCompatability.GregTechRecipesEnabled() && ModCompatability.isIndustrialCraftLoaded() && ModCompatability.isGregTechLoaded()) {
            String energyFlowCircuit = "craftingCircuitTier07";
            String superConductor = "craftingSuperconductor";
            String dataStorageCircuit = "craftingCircuitTier05";
            ItemStack reinforcedGlass = ModCompatability.getIC2Item("reinforcedGlass");
            ItemStack advCircuit = ModCompatability.getIC2Item("advancedCircuit");
            ItemStack ovscanner = ModCompatability.getIC2Item("ovScanner");
            ovscanner.setItemDamage(1);

            //===========================================================================================================================
            GameRegistry.addRecipe(new ShapedOreRecipe(AddonComponent.solarPanel, true, "GGG", "PCP", 'G', reinforcedGlass, 'P', "plateAlloyIridium", 'C', energyFlowCircuit));
            GameRegistry.addRecipe(new ShapedOreRecipe(AddonComponent.magnet, true, "ICI", "SSS", "ICI", 'I', "ingotTitanium", 'C', superConductor, 'S', ItemComponent.solenoid));
            GameRegistry.addRecipe(new ShapedOreRecipe(AddonComponent.computerChip, true, "ADA", "DOD", "ADA", 'A', advCircuit, 'D', dataStorageCircuit, 'O', ovscanner));
            //===========================================================================================================================
        }





    }
}	
