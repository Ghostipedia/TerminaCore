package com.ghostipedia.terminacore.common.data;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.IRecipeCapabilityHolder;
import com.gregtechceu.gtceu.api.capability.recipe.IRecipeHandler;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.data.*;
import com.gregtechceu.gtceu.common.machine.multiblock.electric.FusionReactorMachine;
import com.gregtechceu.gtceu.utils.GTHashMaps;
import com.gregtechceu.gtceu.utils.ItemStackHashStrategy;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import com.ghostipedia.terminacore.TerminaCore;
import com.ghostipedia.terminacore.api.machine.part.TerminaPartAbility;
import com.ghostipedia.terminacore.api.registries.TerminaRegistration;
import com.ghostipedia.terminacore.common.data.materials.TerminaMaterials;
import com.ghostipedia.terminacore.common.data.recipe.TerminaRecipeModifiers;
import com.ghostipedia.terminacore.common.machine.multiblock.electric.MagneticFieldMachine;
import com.ghostipedia.terminacore.common.machine.multiblock.part.TerminaParallelHatchPartMachine;
import com.ghostipedia.terminacore.gtbridge.TerminaRecipeTypes;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenCustomHashMap;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static com.ghostipedia.terminacore.api.pattern.TerminaPredicates.magnetCoils;
import static com.ghostipedia.terminacore.api.registries.TerminaRegistration.REGISTRATE;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.GTValues.UV;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.FUSION_GLASS;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;

public class TerminaMachines {

    static {
        TerminaRegistration.REGISTRATE.creativeModeTab(() -> TerminaCreativeModeTabs.TERMINA_CORE);
    }

    public static final int[] HIGH_TIERS = GTValues.tiersBetween(GTValues.IV,
            GTCEuAPI.isHighTier() ? GTValues.OpV : GTValues.UHV);

    public static GTRecipe copyOutputs(GTRecipe recipe, ContentModifier modifier) {
        return new GTRecipe(recipe.recipeType, recipe.getId(),
                recipe.inputs,
                recipe.copyContents(recipe.outputs, modifier),
                recipe.tickInputs,
                recipe.copyContents(recipe.tickOutputs, modifier),
                new HashMap<>(recipe.inputChanceLogics), new HashMap<>(recipe.outputChanceLogics),
                new HashMap<>(recipe.tickInputChanceLogics), new HashMap<>(recipe.tickOutputChanceLogics),
                new ArrayList<>(recipe.conditions),
                new ArrayList<>(recipe.ingredientActions),
                recipe.data,
                recipe.duration,
                recipe.isFuel);
    }

    private static MachineDefinition[] registerTieredMachines(String name,
                                                              BiFunction<IMachineBlockEntity, Integer, MetaMachine> factory,
                                                              BiFunction<Integer, MachineBuilder<MachineDefinition>, MachineDefinition> builder,
                                                              int... tiers) {
        MachineDefinition[] definitions = new MachineDefinition[GTValues.TIER_COUNT];
        for (int tier : tiers) {
            var register = REGISTRATE.machine(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_" + name,
                    holder -> factory.apply(holder, tier)).tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }

    public static void init() {
        for (MultiblockMachineDefinition definition : GTMachines.FUSION_REACTOR) {
            if (definition == null) continue;
            definition.setPatternFactory(() -> {
                var casing = blocks(FusionReactorMachine.getCasingState(definition.getTier()));
                return FactoryBlockPattern.start()
                        .aisle("###############", "######OGO######", "###############")
                        .aisle("######ICI######", "####GGAAAGG####", "######ICI######")
                        .aisle("####CC###CC####", "###EAAOGOAAE###", "####CC###CC####")
                        .aisle("###C#######C###", "##EKEG###GEKE##", "###C#######C###")
                        .aisle("##C#########C##", "#GAE#######EAG#", "##C#########C##")
                        .aisle("##C#########C##", "#GAG#######GAG#", "##C#########C##")
                        .aisle("#I###########I#", "OAO#########OAO", "#I###########I#")
                        .aisle("#C###########C#", "GAG#########GAG", "#C###########C#")
                        .aisle("#I###########I#", "OAO#########OAO", "#I###########I#")
                        .aisle("##C#########C##", "#GAG#######GAG#", "##C#########C##")
                        .aisle("##C#########C##", "#GAE#######EAG#", "##C#########C##")
                        .aisle("###C#######C###", "##EKEG###GEKE##", "###C#######C###")
                        .aisle("####CC###CC####", "###EAAOGOAAE###", "####CC###CC####")
                        .aisle("######ICI######", "####GGAAAGG####", "######ICI######")
                        .aisle("###############", "######OSO######", "###############")
                        .where('S', controller(blocks(definition.get())))
                        .where('G', blocks(FUSION_GLASS.get()).or(casing))
                        .where('E', casing.or(
                                blocks(PartAbility.INPUT_ENERGY.getBlockRange(definition.getTier(), UV)
                                        .toArray(Block[]::new))
                                        .setMinGlobalLimited(1).setPreviewCount(16)))
                        .where('C', casing)
                        .where('K', blocks(FusionReactorMachine.getCoilState(definition.getTier())))
                        .where('O', casing.or(abilities(PartAbility.EXPORT_FLUIDS))
                                .or(abilities(PartAbility.EXPORT_ITEMS)))
                        .where('A', air())
                        .where('I', casing.or(abilities(PartAbility.IMPORT_FLUIDS).setMinGlobalLimited(2))
                                .or(abilities(PartAbility.IMPORT_ITEMS)))
                        .where('#', any())
                        .build();
            });
        }
    }
}
