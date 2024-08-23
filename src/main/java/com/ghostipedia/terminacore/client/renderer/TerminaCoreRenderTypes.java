package com.ghostipedia.terminacore.client.renderer;

import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.ghostipedia.terminacore.client.TerminaCoreClient;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;

@OnlyIn(Dist.CLIENT)
public class TerminaCoreRenderTypes extends RenderType {

    protected static final ShaderStateShard NEBULAE_SHADER = new ShaderStateShard(TerminaCoreClient::getNebulaeShader);

    private static final RenderType NEBULAE = RenderType.create("nebulae",
            DefaultVertexFormat.POSITION, VertexFormat.Mode.QUADS, 256, false, false,
            RenderType.CompositeState.builder()
                    .setShaderState(NEBULAE_SHADER)
                    .createCompositeState(false));

    private TerminaCoreRenderTypes(String name, VertexFormat format, VertexFormat.Mode mode, int bufferSize,
                                   boolean affectsCrumbling, boolean sortOnUpload, Runnable setupState,
                                   Runnable clearState) {
        super(name, format, mode, bufferSize, affectsCrumbling, sortOnUpload, setupState, clearState);
    }

    public static RenderType nebulae() {
        return NEBULAE;
    }
}
