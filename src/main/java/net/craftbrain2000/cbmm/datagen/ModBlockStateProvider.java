package net.craftbrain2000.cbmm.datagen;

import net.craftbrain2000.cbmm.CBMM;
import net.craftbrain2000.cbmm.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CBMM.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BOURSSITE_BLOCK);
        blockWithItem(ModBlocks.RAW_BOURSSITE_BLOCK);

        blockWithItem(ModBlocks.BOURSSITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_BOURSSITE_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
