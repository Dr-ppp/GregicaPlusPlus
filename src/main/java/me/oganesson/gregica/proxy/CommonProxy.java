package me.oganesson.gregica.proxy;

import gregtech.api.block.VariantItemBlock;
import me.oganesson.gregica.common.gregtech.GCMetaEntities;
import me.oganesson.gregica.common.gregtech.tileentity.EssentiaHatch;
import me.oganesson.gregica.common.item.itemUpgrades;
import me.oganesson.gregica.common.thaumcraft.LargeEssentiaEnergyData;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Function;

import static me.oganesson.gregica.common.gregtech.CommonBlocks.ESSENTIA_HATCH;
import static me.oganesson.gregica.common.gregtech.GCMetaBlocks.GC_BLOCK_CASING;

public class CommonProxy {

    public static Item Upgrades = new itemUpgrades();

    public static final CreativeTabs Tab = new CreativeTabs("gregica") {
        @Override
        @Nonnull
        public ItemStack createIcon() {
            return new ItemStack(Upgrades, 1, 0);
        }
    };

    public void preInit( FMLPreInitializationEvent event ) {
        GCMetaEntities.register();
        LargeEssentiaEnergyData.processEssentiaData();
    }

    public void init( FMLInitializationEvent event ) {
    }

    public void registerItems(RegistryEvent.Register<Item> event) {
        Upgrades.setCreativeTab(Tab);
        event.getRegistry().register(Upgrades);
        event.getRegistry().register(createItemBlock(GC_BLOCK_CASING, VariantItemBlock::new));
        event.getRegistry().register(createItemBlock(ESSENTIA_HATCH, ItemBlock::new));
    }

    public void registerBlocks(RegistryEvent.Register<Block> event) {
        GC_BLOCK_CASING.setCreativeTab(Tab);
        ESSENTIA_HATCH.setCreativeTab(Tab);
        event.getRegistry().register(GC_BLOCK_CASING);
        event.getRegistry().register(ESSENTIA_HATCH);
        GameRegistry.registerTileEntity(EssentiaHatch.class, Objects.requireNonNull(ESSENTIA_HATCH.getRegistryName()));
    }

    public void onModelRegister() {

    }

    private static <T extends Block> ItemBlock createItemBlock(@Nonnull T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }
}