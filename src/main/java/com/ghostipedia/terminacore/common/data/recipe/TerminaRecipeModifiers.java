package com.ghostipedia.terminacore.common.data.recipe;

import com.gregtechceu.gtceu.api.capability.IParallelHatch;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;

import com.ghostipedia.terminacore.common.machine.multiblock.electric.MagneticFieldMachine;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class TerminaRecipeModifiers {

    public static GTRecipe magnetRecipe(MetaMachine machine, @NotNull GTRecipe recipe) {
        if (machine instanceof MagneticFieldMachine magnetMachine) {
            final var magnetStrength = magnetMachine.getFieldStrength();
            if (!recipe.data.contains("min_field") || recipe.data.getInt("min_field") > magnetStrength) {
                return null;
            }
            if (!magnetMachine.isGenerator()) {
                if (RecipeHelper.getRecipeEUtTier(recipe) > magnetMachine.getTier()) {
                    return null;
                }
            }

            return recipe;
        }
        return null;
    }

    public static GTRecipe vomahineChemicalPlantParallel(MetaMachine machine, @NotNull GTRecipe recipe) {
        if (machine instanceof WorkableElectricMultiblockMachine vomahineMachine) {
            Optional<IParallelHatch> optional = vomahineMachine.getParts().stream()
                    .filter(IParallelHatch.class::isInstance)
                    .map(IParallelHatch.class::cast).findAny();
            if (optional.isPresent()) {
                IParallelHatch hatch = optional.get();
                if (hatch.getCurrentParallel() != 0) {
                    var result = GTRecipeModifiers.accurateParallel(machine, recipe, hatch.getCurrentParallel(), false);
                    recipe = result.getFirst() == recipe ? result.getFirst().copy() : result.getFirst();
                    var smartDuration = (recipe.duration * hatch.getCurrentParallel()) / 2;
                    int parallelValue = result.getSecond();
                    recipe.duration = smartDuration;
                    return recipe;
                }
            }
            var result = GTRecipeModifiers.accurateParallel(machine, recipe, 0, false);
            recipe = result.getFirst() == recipe ? result.getFirst().copy() : result.getFirst();
            var smartDuration = recipe.duration / 2;
            int parallelValue = result.getSecond();
            recipe.duration = smartDuration;
            return recipe;
        }
        return null;
    }
}
