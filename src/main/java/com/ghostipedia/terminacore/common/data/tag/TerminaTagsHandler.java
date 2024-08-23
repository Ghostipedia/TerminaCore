package com.ghostipedia.terminacore.common.data.tag;

import com.ghostipedia.terminacore.common.data.tag.item.TerminaItemTagsLoader;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class TerminaTagsHandler {

    public static void initItem(RegistrateTagsProvider<Item> provider) {
        TerminaItemTagsLoader.init(provider);
    }

    public static void initBlock(RegistrateTagsProvider<Block> provider) {}

    public static void initFluid(RegistrateTagsProvider<Fluid> provider) {}

    public static void initEntity(RegistrateTagsProvider<EntityType<?>> provider) {}

}
