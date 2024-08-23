package com.ghostipedia.terminacore.forge;

import net.minecraftforge.fml.common.Mod;

import com.ghostipedia.terminacore.TerminaCore;

@Mod.EventBusSubscriber(modid = TerminaCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeCommonEventListener {

    // @SubscribeEvent
    // public static void entityPlacementEventHandler(BlockEvent.EntityPlaceEvent event) {
    // if (event.getPlacedBlock().getBlock() instanceof MetaMachineBlock block && block.getMachine(event.getLevel(),
    // event.getPos()) instanceof SoulHatchPartMachine soulHatch
    // && event.getEntity() instanceof Player player) {
    // soulHatch.attachSoulNetwork(player);
    // }
    // }
}
