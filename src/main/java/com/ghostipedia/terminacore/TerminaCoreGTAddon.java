package com.ghostipedia.terminacore;


import com.ghostipedia.terminacore.api.capability.recipe.TerminaRecipeCapabilities;
import com.ghostipedia.terminacore.api.data.CosmicCoreMaterialIconType;
import com.ghostipedia.terminacore.api.data.CosmicCoreTagPrefix;
import com.ghostipedia.terminacore.api.registries.CosmicRegistration;
import com.ghostipedia.terminacore.common.data.materials.CosmicElements;
import com.ghostipedia.terminacore.common.data.recipe.CosmicCoreOreRecipeHandler;
import com.ghostipedia.terminacore.gtbridge.CosmicRecipeTypes;
import com.ghostipedia.terminacore.gtbridge.CosmicCoreRecipes;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.addon.events.KJSRecipeKeyEvent;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

@GTAddon
public class TerminaCoreGTAddon implements IGTAddon {

    @Override
    public GTRegistrate getRegistrate() {
        return CosmicRegistration.REGISTRATE;
    }

    @Override
    public void registerTagPrefixes() {
        CosmicCoreMaterialIconType.init();
        CosmicCoreTagPrefix.initTagPrefixes();
    }

    @Override
    public void initializeAddon() {
        TerminaCore.LOGGER.info("CosmicCoreGTAddon has loaded!");
    }

    @Override
    public void registerElements() {
        IGTAddon.super.registerElements();
        CosmicElements.init();
    }

    @Override
    public String addonModId() {
        return TerminaCore.MOD_ID;
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        CosmicRecipeTypes.init();
        CosmicCoreRecipes.init(provider);
        CosmicCoreOreRecipeHandler.init(provider);
    }

    @Override
    public void registerRecipeCapabilities() {
        TerminaRecipeCapabilities.init();
    }

    @Override
    public void registerRecipeKeys(KJSRecipeKeyEvent event) {
    }
}