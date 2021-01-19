package oresAboveDiamonds.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import oresAboveDiamonds.OresAboveDiamonds;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.items.CustomArmorItem;
import oresAboveDiamonds.items.CustomAxeItem;
import oresAboveDiamonds.items.CustomHoeItem;
import oresAboveDiamonds.items.CustomPickaxeItem;
import oresAboveDiamonds.items.CustomShovelItem;
import oresAboveDiamonds.items.CustomSwordItem;
import oresAboveDiamonds.items.TooltipBlockItem;
import oresAboveDiamonds.lists.ArmorMaterialList;
import oresAboveDiamonds.lists.ToolMaterialList;

public class ModItems {

	//Thanks to Cadiboo for the tutorial
	static int axedmg = OADConfig.old_combat_mechanics.get() ? 2 : 5;
	static int shoveldmg = OADConfig.old_combat_mechanics.get() ? 0 : 2;
	static int pickdmg = OADConfig.old_combat_mechanics.get() ? 1 : 1;
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OresAboveDiamonds.MODID);
	
	public static final RegistryObject<Item> BLACK_OPAL = ITEMS.register("black_opal", () -> new Item(new Item.Properties().group(ItemGroup.MISC).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", () -> new Item(new Item.Properties().group(ItemGroup.MISC).group(ModItemGroups.OAD_ITEM_GROUP)));
			
	public static final RegistryObject<CustomSwordItem> AMETHYST_SWORD = ITEMS.register("amethyst_sword", () -> new CustomSwordItem(ToolMaterialList.AMETHYST, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<CustomPickaxeItem> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe", () -> new CustomPickaxeItem(ToolMaterialList.AMETHYST, pickdmg, -2.8f, new Item.Properties().group(ItemGroup.TOOLS).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<CustomShovelItem> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel", () -> new CustomShovelItem(ToolMaterialList.AMETHYST, shoveldmg, -3f, new Item.Properties().group(ItemGroup.TOOLS).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<CustomAxeItem> AMETHYST_AXE = ITEMS.register("amethyst_axe", () -> new CustomAxeItem(ToolMaterialList.AMETHYST, axedmg, -3f, new Item.Properties().group(ItemGroup.TOOLS).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<CustomHoeItem> AMETHYST_HOE = ITEMS.register("amethyst_hoe", () -> new CustomHoeItem(ToolMaterialList.AMETHYST, -4, 1f, new Item.Properties().group(ItemGroup.TOOLS).group(ModItemGroups.OAD_ITEM_GROUP)));
			
	public static final RegistryObject<CustomSwordItem> BLACK_OPAL_SWORD = ITEMS.register("black_opal_sword", () -> new CustomSwordItem(ToolMaterialList.BLACK_OPAL, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<CustomPickaxeItem> BLACK_OPAL_PICKAXE = ITEMS.register("black_opal_pickaxe", () -> new CustomPickaxeItem(ToolMaterialList.BLACK_OPAL, pickdmg, -2.8f, new Item.Properties().group(ItemGroup.TOOLS).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<CustomShovelItem> BLACK_OPAL_SHOVEL = ITEMS.register("black_opal_shovel", () -> new CustomShovelItem(ToolMaterialList.BLACK_OPAL, shoveldmg, -3f, new Item.Properties().group(ItemGroup.TOOLS).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<CustomAxeItem> BLACK_OPAL_AXE = ITEMS.register("black_opal_axe", () -> new CustomAxeItem(ToolMaterialList.BLACK_OPAL, axedmg, -3f, new Item.Properties().group(ItemGroup.TOOLS).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<CustomHoeItem> BLACK_OPAL_HOE = ITEMS.register("black_opal_hoe", () -> new CustomHoeItem(ToolMaterialList.BLACK_OPAL, -5, 2f, new Item.Properties().group(ItemGroup.TOOLS).group(ModItemGroups.OAD_ITEM_GROUP)));
			
	public static final RegistryObject<CustomSwordItem> NETHERITE_OPAL_SWORD = ITEMS.register("netherite_opal_sword", () -> new CustomSwordItem(ToolMaterialList.NETHERITE_OPAL, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT).group(ModItemGroups.OAD_ITEM_GROUP).isImmuneToFire()));
	public static final RegistryObject<CustomPickaxeItem> NETHERITE_OPAL_PICKAXE = ITEMS.register("netherite_opal_pickaxe", () -> new CustomPickaxeItem(ToolMaterialList.NETHERITE_OPAL, pickdmg, -2.8f, new Item.Properties().group(ItemGroup.TOOLS).group(ModItemGroups.OAD_ITEM_GROUP).isImmuneToFire()));
	public static final RegistryObject<CustomShovelItem> NETHERITE_OPAL_SHOVEL = ITEMS.register("netherite_opal_shovel", () -> new CustomShovelItem(ToolMaterialList.NETHERITE_OPAL, shoveldmg, -3f, new Item.Properties().group(ItemGroup.TOOLS).group(ModItemGroups.OAD_ITEM_GROUP).isImmuneToFire()));
	public static final RegistryObject<CustomAxeItem> NETHERITE_OPAL_AXE = ITEMS.register("netherite_opal_axe", () -> new CustomAxeItem(ToolMaterialList.NETHERITE_OPAL, axedmg, -3f, new Item.Properties().group(ItemGroup.TOOLS).group(ModItemGroups.OAD_ITEM_GROUP).isImmuneToFire()));
	public static final RegistryObject<CustomHoeItem> NETHERITE_OPAL_HOE = ITEMS.register("netherite_opal_hoe", () -> new CustomHoeItem(ToolMaterialList.NETHERITE_OPAL, -6, 2f, new Item.Properties().group(ItemGroup.TOOLS).group(ModItemGroups.OAD_ITEM_GROUP).isImmuneToFire()));
			
	public static final RegistryObject<CustomArmorItem> AMETHYST_HELMET = ITEMS.register("amethyst_helmet", () -> new CustomArmorItem(ArmorMaterialList.AMETHYST, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<CustomArmorItem> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate", () -> new CustomArmorItem(ArmorMaterialList.AMETHYST, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<CustomArmorItem> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings", () -> new CustomArmorItem(ArmorMaterialList.AMETHYST, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<CustomArmorItem> AMETHYST_BOOTS = ITEMS.register("amethyst_boots", () -> new CustomArmorItem(ArmorMaterialList.AMETHYST, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT).group(ModItemGroups.OAD_ITEM_GROUP)));
			
	public static final RegistryObject<CustomArmorItem> BLACK_OPAL_HELMET = ITEMS.register("black_opal_helmet", () ->new CustomArmorItem(ArmorMaterialList.BLACK_OPAL, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<CustomArmorItem> BLACK_OPAL_CHESTPLATE = ITEMS.register("black_opal_chestplate", () -> new CustomArmorItem(ArmorMaterialList.BLACK_OPAL, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<CustomArmorItem> BLACK_OPAL_LEGGINGS = ITEMS.register("black_opal_leggings", () -> new CustomArmorItem(ArmorMaterialList.BLACK_OPAL, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<CustomArmorItem> BLACK_OPAL_BOOTS = ITEMS.register("black_opal_boots", () -> new CustomArmorItem(ArmorMaterialList.BLACK_OPAL, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT).group(ModItemGroups.OAD_ITEM_GROUP)));
			
	public static final RegistryObject<CustomArmorItem> NETHERITE_OPAL_HELMET = ITEMS.register("netherite_opal_helmet", () -> new CustomArmorItem(ArmorMaterialList.NETHERITE_OPAL, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).group(ModItemGroups.OAD_ITEM_GROUP).isImmuneToFire()));
	public static final RegistryObject<CustomArmorItem> NETHERITE_OPAL_CHESTPLATE = ITEMS.register("netherite_opal_chestplate", () -> new CustomArmorItem(ArmorMaterialList.NETHERITE_OPAL, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT).group(ModItemGroups.OAD_ITEM_GROUP).isImmuneToFire()));
	public static final RegistryObject<CustomArmorItem> NETHERITE_OPAL_LEGGINGS = ITEMS.register("netherite_opal_leggings", () -> new CustomArmorItem(ArmorMaterialList.NETHERITE_OPAL, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT).group(ModItemGroups.OAD_ITEM_GROUP).isImmuneToFire()));
	public static final RegistryObject<CustomArmorItem> NETHERITE_OPAL_BOOTS = ITEMS.register("netherite_opal_boots", () -> new CustomArmorItem(ArmorMaterialList.NETHERITE_OPAL, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT).group(ModItemGroups.OAD_ITEM_GROUP).isImmuneToFire()));
			
	public static final RegistryObject<TooltipBlockItem> AMETHYST_ORE = ITEMS.register("amethyst_ore", () -> new TooltipBlockItem(ModBlocks.AMETHYST_ORE.get(), new Item.Properties().group(ItemGroup.MISC).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<TooltipBlockItem> NETHER_AMETHYST_ORE = ITEMS.register("nether_amethyst_ore", () -> new TooltipBlockItem(ModBlocks.NETHER_AMETHYST_ORE.get(), new Item.Properties().group(ItemGroup.MISC).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<TooltipBlockItem> END_AMETHYST_ORE = ITEMS.register("end_amethyst_ore", () -> new TooltipBlockItem(ModBlocks.END_AMETHYST_ORE.get(), new Item.Properties().group(ItemGroup.MISC).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<TooltipBlockItem> BLACK_OPAL_ORE = ITEMS.register("black_opal_ore", () -> new TooltipBlockItem(ModBlocks.BLACK_OPAL_ORE.get(), new Item.Properties().group(ItemGroup.MISC).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<TooltipBlockItem> NETHER_BLACK_OPAL_ORE = ITEMS.register("nether_black_opal_ore", () -> new TooltipBlockItem(ModBlocks.NETHER_BLACK_OPAL_ORE.get(), new Item.Properties().group(ItemGroup.MISC).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<TooltipBlockItem> END_BLACK_OPAL_ORE = ITEMS.register("end_black_opal_ore", () -> new TooltipBlockItem(ModBlocks.END_BLACK_OPAL_ORE.get(), new Item.Properties().group(ItemGroup.MISC).group(ModItemGroups.OAD_ITEM_GROUP)));

	public static final RegistryObject<BlockItem> AMETHYST_BLOCK = ITEMS.register("amethyst_block", () -> new BlockItem(ModBlocks.AMETHYST_BLOCK.get(), new Item.Properties().group(ItemGroup.MISC).group(ModItemGroups.OAD_ITEM_GROUP)));
	public static final RegistryObject<BlockItem> BLACK_OPAL_BLOCK = ITEMS.register("black_opal_block", () -> new BlockItem(ModBlocks.BLACK_OPAL_BLOCK.get(), new Item.Properties().group(ItemGroup.MISC).group(ModItemGroups.OAD_ITEM_GROUP)));
	
}
