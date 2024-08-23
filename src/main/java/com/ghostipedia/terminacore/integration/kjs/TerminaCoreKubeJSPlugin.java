package com.ghostipedia.terminacore.integration.kjs;


import com.ghostipedia.terminacore.TerminaCore;
import com.ghostipedia.terminacore.common.data.TerminaBlocks;
import com.ghostipedia.terminacore.common.data.TerminaItems;
import com.ghostipedia.terminacore.common.data.TerminaMachines;
import com.ghostipedia.terminacore.common.data.materials.TerminaElements;
import com.ghostipedia.terminacore.common.data.materials.TerminaMaterials;
import com.ghostipedia.terminacore.gtbridge.TerminaRecipeTypes;
import com.ghostipedia.terminacore.integration.kjs.recipe.TerminaCoreRecipeSchema;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.RecipeComponentFactoryRegistryEvent;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import dev.latvian.mods.kubejs.script.ScriptType;
import dev.latvian.mods.kubejs.util.ClassFilter;

public class TerminaCoreKubeJSPlugin extends KubeJSPlugin {

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
        filter.allow("com.ghostipedia.terminacore");
    }

    @Override
    public void registerRecipeSchemas(RegisterRecipeSchemasEvent event) {
        for (var entry : GTRegistries.RECIPE_TYPES.entries()) {
            event.register(entry.getKey(), TerminaCoreRecipeSchema.SCHEMA);
        }
    }

    @Override
    public void registerRecipeComponents(RecipeComponentFactoryRegistryEvent event) {
    }

    @Override
    public void registerBindings(BindingsEvent event) {
        super.registerBindings(event);
        event.add("TerminaMaterials", TerminaMaterials.class);
        event.add("TerminaElements", TerminaElements.class);
        event.add("TerminaBlocks", TerminaBlocks.class);
        event.add("TerminaMachines", TerminaMachines.class);
        event.add("TerminaItems", TerminaItems.class);
        event.add("TerminaRecipeTypes", TerminaRecipeTypes.class);

        event.add("TerminaCore", TerminaCore.class);
    }
}
