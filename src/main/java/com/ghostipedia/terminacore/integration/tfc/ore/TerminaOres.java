package com.ghostipedia.terminacore.integration.tfc.ore;

import com.ghostipedia.terminacore.api.metals.TerminaPropertyKeys;
import com.ghostipedia.terminacore.api.registries.TerminaRegistration;
import com.ghostipedia.terminacore.common.material.property.TFCOreProperty;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.OreProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.dries007.tfc.common.blocks.GroundcoverBlock;
import net.dries007.tfc.common.blocks.rock.Ore;
import net.dries007.tfc.common.blocks.rock.Rock;
import net.dries007.tfc.util.Helpers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.Tags;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class TerminaOres {

    public static Map<Material, RegistryEntry<Block>> SMALL_MATERIAL_ROCK;
    public static Map<Rock, Map<Material, Map<Ore.Grade, RegistryEntry<Block>>>> ORES = new EnumMap<>(Rock.class);

    public static void init() {
        for (Rock rock : Rock.VALUES) {
            for (Material material : GTCEuAPI.materialManager.getRegisteredMaterials()) {
                if (material.hasProperty(TerminaPropertyKeys.TFC_ORE_PROPERTY)) {
                    ORES.computeIfAbsent(rock, $ -> new HashMap<>()).put(material, createMaterialOres(rock, material));
                }
            }
        }
    }

    public static Map<Ore.Grade, RegistryEntry<Block>> createMaterialOres(Rock rock, Material material) {
        EnumMap<Ore.Grade, RegistryEntry<Block>> map;
        TFCOreProperty property = material.getProperty(TerminaPropertyKeys.TFC_ORE_PROPERTY);
        if (!property.isGraded()) {
            map = new EnumMap<>(Ore.Grade.class);
            map.put(Ore.Grade.NORMAL, registerOre(Ore.Grade.NORMAL, material, rock, Block::new));
        } else {
            map = Helpers.mapOfKeys(Ore.Grade.class, grade -> registerOre(grade, material, rock, Block::new));
        }
        SMALL_MATERIAL_ROCK.put(material, registerSmallOre(material, GroundcoverBlock::looseOre));
        return map;
    }

    private static <T extends Block> RegistryEntry<T> registerOre(Ore.Grade grade, Material material, Rock rock, NonNullFunction<BlockBehaviour.Properties, T> supplier) {
        return TerminaRegistration.REGISTRATE.block("ore/" + grade.name() + "_" + material.getName() + "/" + rock.name(), supplier)
                .properties(p -> p.sound(SoundType.STONE).strength(3, 10).requiresCorrectToolForDrops())
                .tag(Tags.Blocks.ORES)
                .item()
                .tag(Tags.Items.ORES)
                .build()
                .register();
    }

    private static <T extends Block> RegistryEntry<T> registerSmallOre(Material material, NonNullFunction<BlockBehaviour.Properties, T> supplier) {
        return TerminaRegistration.REGISTRATE.block("ore/small_" + material.getName(), supplier)
                .properties(p -> p.strength(0.05f, 0.0f).sound(SoundType.NETHER_ORE).noCollission())
                .tag(Tags.Blocks.ORES)
                .item()
                .tag(Tags.Items.ORES)
                .build()
                .register();
    }

    public static void addMaterialProperties() {
        for (Material material : GTCEuAPI.materialManager.getRegisteredMaterials()) {
            OreProperty oreProperty = material.getProperty(PropertyKey.ORE);
            if (oreProperty != null) {
                material.setProperty(TerminaPropertyKeys.TFC_ORE_PROPERTY, new TFCOreProperty(oreProperty));
            }
        }
    }
}
