package com.agricraft.agricraft.compat.jade;

import com.agricraft.agricraft.AgriCraft;
import com.agricraft.agricraft.api.genetic.AgriGenePair;
import com.agricraft.agricraft.common.block.CropBlock;
import com.agricraft.agricraft.common.block.entity.CropBlockEntity;
import com.agricraft.agricraft.common.util.LangUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;
import snownee.jade.api.config.IPluginConfig;

import java.util.Comparator;

@WailaPlugin
public class CropBlockPlugin implements IWailaPlugin {

	@Override
	public void register(IWailaCommonRegistration registration) {
		System.out.println("registering agricraft crop block plugin");
	}

	@Override
	public void registerClient(IWailaClientRegistration registration) {
		System.out.println("registering agricraft crop block plugin client");
		registration.registerBlockComponent(CropBlockComponentProvider.INSTANCE, CropBlock.class);
	}

	public static class CropBlockComponentProvider implements IBlockComponentProvider {

		public static final CropBlockComponentProvider INSTANCE = new CropBlockComponentProvider();

		private static final ResourceLocation ID = new ResourceLocation(AgriCraft.MOD_ID, "crop_block");

		private CropBlockComponentProvider() {
		}

		@Override
		public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
			if (blockAccessor.getBlockEntity() instanceof CropBlockEntity cbe) {
				iTooltip.add(Component.translatable("agricraft.tooltip.jade.growth", cbe.getGrowthPercent()));
				if (Minecraft.getInstance().player.isShiftKeyDown()) {
					iTooltip.add(Component.translatable("agricraft.tooltip.jade.species")
							.append(LangUtils.plantName(cbe.getGenome().getSpeciesGene().getTrait()))
					);
					for (AgriGenePair<Integer> statGene : cbe.getGenome().getStatGenes().stream().sorted(Comparator.comparing(p -> p.getGene().getId())).toList()) {
						iTooltip.add(Component.translatable("agricraft.tooltip.jade.stat." + statGene.getGene().getId(), statGene.getTrait()));
					}
				}
			}
		}

		@Override
		public ResourceLocation getUid() {
			return ID;
		}

	}

}