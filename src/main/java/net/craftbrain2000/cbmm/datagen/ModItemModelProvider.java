package net.craftbrain2000.cbmm.datagen;

import net.craftbrain2000.cbmm.CBMM;
import net.craftbrain2000.cbmm.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CBMM.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ASH);
        simpleItem(ModItems.BOURSSITE_INGOT);
        simpleItem(ModItems.RAW_BOURSSITE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("Layer0",
                new ResourceLocation(CBMM.MOD_ID,"item/" + item.getId().getPath()));
    }
}
