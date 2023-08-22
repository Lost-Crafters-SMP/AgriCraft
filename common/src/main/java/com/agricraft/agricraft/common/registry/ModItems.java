package com.agricraft.agricraft.common.registry;

import com.agricraft.agricraft.AgriCraft;
import com.agricraft.agricraft.common.item.DebuggerItem;
import com.agricraft.agricraft.common.item.MagnifyingGlassItem;
import com.agricraft.agricraft.common.item.RakeItem;
import com.agricraft.agricraft.common.util.PlatformUtils;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class ModItems {
	public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(BuiltInRegistries.ITEM, AgriCraft.MOD_ID);

	public static final RegistryEntry<Item> DEBUGGER = ITEMS.register("debugger", () -> new DebuggerItem(new Item.Properties()));

	public static final RegistryEntry<Item> RAKE_WOOD = ITEMS.register("rake_wood", () -> new RakeItem(new Item.Properties()));
	public static final RegistryEntry<Item> RAKE_IRON = ITEMS.register("rake_iron", () -> new RakeItem(new Item.Properties()));
	public static final RegistryEntry<Item> MAGNIFYING_GLASS = ITEMS.register("magnifying_glass", () -> new MagnifyingGlassItem(new Item.Properties().stacksTo(1)));
	public static final RegistryEntry<Item> SEED = ITEMS.register("seed", () -> PlatformUtils.createAgriSeedItem(new Item.Properties()));


	public static void addItemsToTabs(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {
		AgriCraft.LOGGER.info("register item in tab");
		output.accept(ModItems.DEBUGGER.get());
		output.accept(ModItems.RAKE_WOOD.get());
		output.accept(ModItems.RAKE_IRON.get());
		output.accept(ModItems.MAGNIFYING_GLASS.get());
	}

}