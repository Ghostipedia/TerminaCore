package com.ghostipedia.terminacore.common.data;
import com.ghostipedia.terminacore.TerminaCore;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.*;

import static com.ghostipedia.terminacore.api.registries.CosmicRegistration.REGISTRATE;


public class CosmicCreativeModeTabs {
    public static RegistryEntry<CreativeModeTab> COSMIC_CORE = REGISTRATE.defaultCreativeTab(TerminaCore.MOD_ID,
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(TerminaCore.MOD_ID, REGISTRATE))
                            .title(REGISTRATE.addLang("itemGroup", TerminaCore.id("creative_tab"), "Cosmic Core"))
                            .icon(CosmicItems.DONK::asStack)
                            .build())
            .register();

    public static void init() {

    }
}
