package net.craftbrain2000.cbmm.datagen.loot;

import net.craftbrain2000.cbmm.block.ModBlocks;
import net.craftbrain2000.cbmm.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.BOURSSITE_BLOCK.get());
        //this.dropSelf(ModBlocks.RAW_BOURSSITE_BLOCK.get());

        this.add(ModBlocks.BOURSSITE_ORE.get(),
                block -> createOreDrop(ModBlocks.BOURSSITE_ORE.get(), ModItems.RAW_BOURSSITE.get()));
        this.add(ModBlocks.DEEPSLATE_BOURSSITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_BOURSSITE_ORE.get(), ModItems.RAW_BOURSSITE.get()));


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
