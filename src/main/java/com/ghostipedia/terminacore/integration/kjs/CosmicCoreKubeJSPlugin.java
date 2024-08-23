package com.ghostipedia.terminacore.integration.kjs;


import com.ghostipedia.terminacore.TerminaCore;
import com.ghostipedia.terminacore.common.data.CosmicBlocks;
import com.ghostipedia.terminacore.common.data.CosmicItems;
import com.ghostipedia.terminacore.common.data.CosmicMachines;
import com.ghostipedia.terminacore.common.data.materials.CosmicElements;
import com.ghostipedia.terminacore.common.data.materials.CosmicMaterials;
import com.ghostipedia.terminacore.gtbridge.CosmicRecipeTypes;
import com.ghostipedia.terminacore.integration.kjs.recipe.CosmicCoreRecipeSchema;
import com.ghostipedia.terminacore.integration.kjs.recipe.components.CosmicRecipeComponent;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.RecipeComponentFactoryRegistryEvent;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import dev.latvian.mods.kubejs.script.ScriptType;
import dev.latvian.mods.kubejs.util.ClassFilter;

public class CosmicCoreKubeJSPlugin extends KubeJSPlugin {

    @Override
    public void initStartup() {
        super.initStartup();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void registerClasses(ScriptType type, ClassFilter filter) {
        super.registerClasses(type, filter);
        // allow user to access all gtceu classes by importing them.
        filter.allow("com.ghostipedia.cosmiccore");
    }

    @Override
    public void registerRecipeSchemas(RegisterRecipeSchemasEvent event) {
        for (var entry : GTRegistries.RECIPE_TYPES.entries()) {
            event.register(entry.getKey(), CosmicCoreRecipeSchema.SCHEMA);
        }
    }

    @Override
    public void registerRecipeComponents(RecipeComponentFactoryRegistryEvent event) {
    }

    @Override
    public void registerBindings(BindingsEvent event) {
        super.registerBindings(event);
        event.add("CosmicMaterials", CosmicMaterials.class);
        event.add("CosmicElements", CosmicElements.class);
        event.add("CosmicBlocks", CosmicBlocks.class);
        event.add("CosmicMachines", CosmicMachines.class);
        event.add("CosmicItems", CosmicItems.class);
        event.add("CosmicRecipeTypes", CosmicRecipeTypes.class);

        event.add("CosmicCore", TerminaCore.class);
    }
}
