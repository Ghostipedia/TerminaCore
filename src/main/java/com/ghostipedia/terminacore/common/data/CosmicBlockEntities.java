package com.ghostipedia.terminacore.common.data;

import com.ghostipedia.terminacore.common.blockentity.CosmicCoilBlockEntity;
import com.lowdragmc.lowdraglib.client.renderer.ATESRRendererProvider;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class CosmicBlockEntities {
    public static final BlockEntityEntry<CosmicCoilBlockEntity> CAUSAL_FABRIC_COIL_BLOCK_ENTITY = REGISTRATE
            .blockEntity("causal_fabric_coil", CosmicCoilBlockEntity::new)
            .renderer(() -> ctx -> new ATESRRendererProvider<>())
            .validBlocks(CosmicBlocks.COIL_CAUSAL_FABRIC)
            .register();


    public static void init() {

    }
}
