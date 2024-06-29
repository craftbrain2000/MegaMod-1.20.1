package net.craftbrain2000.cbmm.item;

import net.craftbrain2000.cbmm.CBMM;
import net.craftbrain2000.cbmm.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CBMM.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CBMM_TAB = CREATIVE_MODE_TABS.register("cbmm_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ASH.get()))
                    .title(Component.translatable("creative_tab.cbmm_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ASH.get());
                        pOutput.accept(ModItems.RAW_BOURSSITE.get());
                        pOutput.accept(ModItems.BOURSSITE_INGOT.get());
                        //pOutput.accept(ModItems.BATARANG.get());


                        pOutput.accept(ModBlocks.BOURSSITE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_BOURSSITE_BLOCK.get());

                        pOutput.accept(ModBlocks.BOURSSITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_BOURSSITE_ORE.get());

                    })
                    .build());

     public static void register(IEventBus eventBus) {
         CREATIVE_MODE_TABS.register(eventBus);
     }
}
