package com.ghostipedia.terminacore.gtbridge;

import com.gregtechceu.gtceu.api.GTValues;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.ghostipedia.terminacore.common.data.materials.TerminaMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Water;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.DISTILLATION_RECIPES;

public class TerminaCoreRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        // SOUL_TESTER_RECIPES.recipeBuilder("dirt_to_soul")
        // .inputItems(Blocks.DIRT.asItem(), 1)
        // .output(SoulRecipeCapability.CAP, 1000000)
        // .duration(10)
        // .save(provider);
        //

        DISTILLATION_RECIPES.recipeBuilder("diluted_prisma_to_prisma_and_water")
                .inputFluids(DilutedPrisma.getFluid(5000))
                .outputFluids(Prisma.getFluid(1000))
                .outputFluids(Water.getFluid(4000))
                .duration(40)
                .EUt(GTValues.VA[GTValues.HV])
                .save(provider);
        // GROVE_RECIPES.recipeBuilder("dirt_movement")
        // .input(SoulRecipeCapability.CAP, 100)
        // .notConsumable(TerminaItems.DONK)
        // .notConsumable(Items.ZOMBIE_HEAD)
        // .outputItems(Items.ROTTEN_FLESH, 1)
        // .duration(20)
        // .EUt(GTValues.VA[GTValues.HV])
        // .save(provider);
        // GROVE_RECIPES.recipeBuilder("killing_mobs")
        // .output(SoulRecipeCapability.CAP, 1000)
        // .notConsumable(Items.ZOMBIE_HEAD)
        // .duration(20)
        // .EUt(GTValues.VA[GTValues.HV])
        // .save(provider);
        // NAQUAHINE_REACTOR.recipeBuilder("dirt_to_power")
        // .inputItems(Blocks.DIRT.asItem(), 1)
        // .EUt(-GTValues.V[GTValues.UV])
        // .duration(10)
        // .save(provider);
    }
}
