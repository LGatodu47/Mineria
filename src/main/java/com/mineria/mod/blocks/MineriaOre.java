package com.mineria.mod.blocks;

import com.mineria.mod.init.BlocksInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class MineriaOre extends OreBlock
{
	public MineriaOre(int harvestLevel, float hardness, float resistance, SoundType sound)
	{
		super(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(hardness, resistance).sound(sound).harvestLevel(harvestLevel).harvestTool(ToolType.PICKAXE));
	}

	@Override
	protected int getExperience(Random rand)
	{
		return this == BlocksInit.LONSDALEITE_ORE ? MathHelper.nextInt(rand, 4, 10) : super.getExperience(rand);
	}
}
