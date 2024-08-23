package com.ghostipedia.terminacore.integration.kjs.recipe;

import com.gregtechceu.gtceu.integration.kjs.recipe.GTRecipeSchema;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import lombok.experimental.Accessors;

import static com.gregtechceu.gtceu.integration.kjs.recipe.GTRecipeSchema.*;


public interface TerminaCoreRecipeSchema {

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    @Accessors(chain = true, fluent = true)
    class TerminaRecipeJS extends GTRecipeSchema.GTRecipeJS {
        public GTRecipeSchema.GTRecipeJS magnetStats(int minField, int decayRate,boolean perTick){
            this.addData("min_field", minField);
            this.addData("decay_rate", decayRate);
            this.addDataBool("per_tick", perTick);
            return this;
        }
        public GTRecipeSchema.GTRecipeJS magnetStats(int minField, int decayRate){
            this.addData("min_field", minField);
            this.addData("decay_rate", decayRate);
            this.addDataBool("per_tick", true);
            return this;
        }
    }

    RecipeSchema SCHEMA = new RecipeSchema(TerminaRecipeJS.class, TerminaRecipeJS::new, DURATION, DATA, CONDITIONS,
            ALL_INPUTS, ALL_TICK_INPUTS, ALL_OUTPUTS, ALL_TICK_OUTPUTS,
            INPUT_CHANCE_LOGICS, OUTPUT_CHANCE_LOGICS, TICK_INPUT_CHANCE_LOGICS, TICK_OUTPUT_CHANCE_LOGICS,
            IS_FUEL)
            .constructor((recipe, schemaType, keys, from) -> recipe.id(from.getValue(recipe, ID)), ID)
            .constructor(DURATION, CONDITIONS, ALL_INPUTS, ALL_OUTPUTS, ALL_TICK_INPUTS, ALL_TICK_OUTPUTS);

}
