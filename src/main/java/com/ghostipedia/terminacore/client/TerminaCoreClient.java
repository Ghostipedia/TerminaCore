package com.ghostipedia.terminacore.client;

import net.minecraft.client.renderer.ShaderInstance;
import net.minecraftforge.client.event.RegisterShadersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import lombok.Getter;

@SuppressWarnings("unused")
public class TerminaCoreClient {

    private TerminaCoreClient() {}

    @Getter
    private static ShaderInstance nebulaeShader;

    @SubscribeEvent
    public static void shaderRegistry(RegisterShadersEvent event) {
        /*
         * try {
         * //event.registerShader(new ShaderInstance(event.getResourceProvider(), TerminaCore.id("rendertype_nebulae"),
         * DefaultVertexFormat.POSITION), (shaderInstance) -> nebulaeShader = shaderInstance);
         * } catch (IOException e) {
         * throw new RuntimeException(e);
         * }
         */
    }
}
