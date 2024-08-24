package com.ghostipedia.terminacore.integration.tfc.ore;

import com.ghostipedia.terminacore.api.registries.TerminaRegistration;
import com.ghostipedia.terminacore.mixin.RegistryEntryAccessor;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.tterrag.registrate.Registrate;
import net.dries007.tfc.common.blocks.GroundcoverBlock;
import net.dries007.tfc.common.blocks.rock.Ore;
import net.dries007.tfc.util.Helpers;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.function.Supplier;

public class TerminaOre {

    public static Map<Material, Map<Ore.Grade, RegistryObject<Item>>> ORES;

    public static Map<Material, RegistryObject<Block>> SMALL_MATERIAL_ROCK;
    public static Map<Material, Map<Ore.Grade, RegistryObject<Block>>> MATERIAL_ORE;

    public static void addMaterialOres(Material mat) {
        ORES.put(mat, Helpers.mapOfKeys(Ore.Grade.class, grade -> register("ore/" + grade.name() + "_" + mat.getName().toLowerCase())));

        SMALL_MATERIAL_ROCK.put(mat, register("ore/small_" + mat.getName(), () -> GroundcoverBlock.looseOre(BlockBehaviour.Properties.of().strength(0.05f, 0.0f).sound(SoundType.NETHER_ORE).noCollission())));
    }

    @SuppressWarnings("unchecked")
    private static <T extends Item> RegistryObject<T> register(String name) {
        var itemEntry = TerminaRegistration.REGISTRATE.item(name, Item::new).register();
        return ((RegistryEntryAccessor<T>)itemEntry).getDelegate();
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier) {
        var blockEntry = TerminaRegistration.REGISTRATE.block(name, Block::new).register();
        return ((RegistryEntryAccessor<T>)blockEntry).getDelegate();
    }
}
