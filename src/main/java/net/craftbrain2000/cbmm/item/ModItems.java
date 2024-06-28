package net.craftbrain2000.cbmm.item;

import net.craftbrain2000.cbmm.CBMM;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CBMM.MOD_ID);

    //Resources
    public static final RegistryObject<Item> ASH = ITEMS.register("ash",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_BOURSSITE = ITEMS.register("raw_bourssite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BOURSSITE_INGOT = ITEMS.register("bourssite_ingot",
            () -> new Item(new Item.Properties()));

    //Tools & Weapons

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
