package net.craftbrain2000.cbmm.datagen;

import net.craftbrain2000.cbmm.CBMM;
import net.craftbrain2000.cbmm.block.ModBlocks;
import net.craftbrain2000.cbmm.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CBMM.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BOURSSITE_BLOCK.get(),
                        ModBlocks.BOURSSITE_ORE.get(),
                        ModBlocks.RAW_BOURSSITE_BLOCK.get(),
                        ModBlocks.DEEPSLATE_BOURSSITE_ORE.get()
                        );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BOURSSITE_BLOCK.get(),
                        ModBlocks.BOURSSITE_ORE.get(),
                        ModBlocks.DEEPSLATE_BOURSSITE_ORE.get()
                        );

        //this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                //.add(ModBlocks.BOURSSITE_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.RAW_BOURSSITE_BLOCK.get());
    }
}
