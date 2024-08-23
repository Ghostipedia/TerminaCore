package com.ghostipedia.terminacore.api;

import com.ghostipedia.terminacore.api.block.IMagnetType;
import com.ghostipedia.terminacore.common.block.MagnetBlock;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CosmicCoreAPI {
    public static final Map<IMagnetType, Supplier<MagnetBlock>> MAGNET_COILS = new HashMap<>();
}
