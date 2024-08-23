package com.ghostipedia.terminacore;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.addon.events.KJSRecipeKeyEvent;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import net.minecraft.data.recipes.FinishedRecipe;

import com.ghostipedia.terminacore.api.capability.recipe.TerminaRecipeCapabilities;
import com.ghostipedia.terminacore.api.data.TerminaCoreMaterialIconType;
import com.ghostipedia.terminacore.api.data.TerminaCoreTagPrefix;
import com.ghostipedia.terminacore.api.registries.TerminaRegistration;
import com.ghostipedia.terminacore.common.data.materials.TerminaElements;
import com.ghostipedia.terminacore.common.data.recipe.TerminaCoreOreRecipeHandler;
import com.ghostipedia.terminacore.gtbridge.TerminaCoreRecipes;
import com.ghostipedia.terminacore.gtbridge.TerminaRecipeTypes;

import java.util.function.Consumer;

@GTAddon
public class TerminaCoreGTAddon implements IGTAddon {

    @Override
    public GTRegistrate getRegistrate() {
        return TerminaRegistration.REGISTRATE;
    }

    @Override
    public void registerTagPrefixes() {
        TerminaCoreMaterialIconType.init();
        TerminaCoreTagPrefix.initTagPrefixes();
    }

    @Override
    public void initializeAddon() {
        TerminaCore.LOGGER.info("TerminaCoreGTAddon has loaded!");
    }

    @Override
    public void registerElements() {
        IGTAddon.super.registerElements();
        TerminaElements.init();
    }

    @Override
    public String addonModId() {
        return TerminaCore.MOD_ID;
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        TerminaRecipeTypes.init();
        TerminaCoreRecipes.init(provider);
        TerminaCoreOreRecipeHandler.init(provider);
    }

    @Override
    public void registerRecipeCapabilities() {
        TerminaRecipeCapabilities.init();
    }

    @Override
    public void registerRecipeKeys(KJSRecipeKeyEvent event) {}
}
