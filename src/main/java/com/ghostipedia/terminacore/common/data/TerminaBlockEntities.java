package com.ghostipedia.terminacore.common.data;

import com.ghostipedia.terminacore.common.blockentity.TerminaCoilBlockEntity;
import com.lowdragmc.lowdraglib.client.renderer.ATESRRendererProvider;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class TerminaBlockEntities {
    public static final BlockEntityEntry<TerminaCoilBlockEntity> CAUSAL_FABRIC_COIL_BLOCK_ENTITY = REGISTRATE
            .blockEntity("causal_fabric_coil", TerminaCoilBlockEntity::new)
            .renderer(() -> ctx -> new ATESRRendererProvider<>())
            .validBlocks(TerminaBlocks.COIL_CAUSAL_FABRIC)
            .register();


    public static void init() {

    }
}
