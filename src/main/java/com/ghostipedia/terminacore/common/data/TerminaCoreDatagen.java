package com.ghostipedia.terminacore.common.data;

import com.ghostipedia.terminacore.api.registries.TerminaRegistration;
import com.ghostipedia.terminacore.common.data.lang.TerminaLangHandler;
import com.ghostipedia.terminacore.common.data.tag.TerminaTagsHandler;
import com.tterrag.registrate.providers.ProviderType;

public class TerminaCoreDatagen {

    public static void init() {
        TerminaRegistration.REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, TerminaTagsHandler::initItem);
        TerminaRegistration.REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, TerminaTagsHandler::initBlock);
        TerminaRegistration.REGISTRATE.addDataGenerator(ProviderType.FLUID_TAGS, TerminaTagsHandler::initFluid);
        TerminaRegistration.REGISTRATE.addDataGenerator(ProviderType.ENTITY_TAGS, TerminaTagsHandler::initEntity);
        TerminaRegistration.REGISTRATE.addDataGenerator(ProviderType.LANG, TerminaLangHandler::init);
    }

}
