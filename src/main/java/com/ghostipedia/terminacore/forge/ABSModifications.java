package com.ghostipedia.terminacore.forge;

import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.data.recipe.misc.alloyblast.CustomAlloyBlastRecipeProducer;

import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.ghostipedia.terminacore.TerminaCore;
import com.ghostipedia.terminacore.common.data.materials.TerminaMaterials;

@Mod.EventBusSubscriber(modid = TerminaCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ABSModifications {

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void addAlloyBlastProperties(PostMaterialEvent event) {
        TerminaMaterials.ResonantVirtueMeld.getProperty(PropertyKey.ALLOY_BLAST)
                .setRecipeProducer(new CustomAlloyBlastRecipeProducer(-1, -1, 32));
    }
}
