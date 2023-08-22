package com.agricraft.agricraft.common.config;

import com.agricraft.agricraft.AgriCraft;
import com.teamresourceful.resourcefulconfig.common.annotations.Config;
import com.teamresourceful.resourcefulconfig.common.annotations.InlineCategory;

@Config(AgriCraft.MOD_ID)
public final class AgriCraftConfig {

	@InlineCategory
	public static StatsConfig statsConfig;

}