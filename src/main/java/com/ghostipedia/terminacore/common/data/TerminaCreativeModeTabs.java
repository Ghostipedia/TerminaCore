package com.ghostipedia.terminacore.common.data;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;

import net.minecraft.world.item.*;

import com.ghostipedia.terminacore.TerminaCore;
import com.tterrag.registrate.util.entry.RegistryEntry;

import static com.ghostipedia.terminacore.api.registries.TerminaRegistration.REGISTRATE;

public class TerminaCreativeModeTabs {

    public static RegistryEntry<CreativeModeTab> TERMINA_CORE = REGISTRATE.defaultCreativeTab(TerminaCore.MOD_ID,
            builder -> builder
                    .displayItems(
                            new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(TerminaCore.MOD_ID, REGISTRATE))
                    .title(REGISTRATE.addLang("itemGroup", TerminaCore.id("creative_tab"), "Termina Core"))
                    .icon(TerminaItems.DONK::asStack)
                    .build())
            .register();

    public static void init() {}
}
