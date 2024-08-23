package com.ghostipedia.terminacore.common.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

import static com.gregtechceu.gtceu.data.lang.LangHandler.replace;

public class TerminaLangHandler {

    public static void init(RegistrateLangProvider provider) {
        replace(provider,"terminacore.recipe.soulIn","Soul Input: %s");
        replace(provider,"terminacore.recipe.soulOut", "Soul Output: %s");
        replace(provider,"terminacore.wire_coil.magnet_capacity", "  §fMax Field Strength: §f%s Tesla");
        replace(provider,"terminacore.wire_coil.magnet_regen", "  §5Field Regen Rate: %s Tesla/t");
        replace(provider,"terminacore.wire_coil.eu_multiplier", "  §aMagnet EU Cost: §c%s EU/t");
        replace(provider,"terminacore.wire_coil.magnet_stats", "§8Magnet Stats");
        replace(provider,"tooltip.terminacore.soul_hatch.input", "§cMax Recipe Input§f:§6 %s");
        replace(provider,"tooltip.terminacore.soul_hatch.output", "§cMax Soul Network Capacity§f:§6 %s");
        replace(provider,"gui.terminacore.soul_hatch.label.import", "Soul Input Hatch");
        replace(provider,"gui.terminacore.soul_hatch.label.export", "Soul Output Hatch");
        replace(provider,"gui.terminacore.soul_hatch.owner", "Network Owner: %d");
        replace(provider,"gui.terminacore.soul_hatch.lp", "LP Stored: %s");
        replace(provider,"tooltip.terminacore.soul_hatch.output", "§cMax Soul Network Capacity§f:§6 %s");
        replace(provider,"terminacore.multiblock.magnetic_field_strength", "§fMax Field Strength§f:§6 %s");
        replace(provider,"terminacore.multiblock.magnetic_regen", "§aField Recovery Rate§f:§6 %sT/t");
        replace(provider,"gtceu.naquahine_reactor", "§bNaquahine Reactor");
        replace(provider,"terminacore.multiblock.current_field_strength", "§fField Strength: %s");
        replace(provider,"terminacore.recipe.minField", "§fMin. Field Strength: %sT");
        replace(provider,"terminacore.recipe.fieldDecay", "§fField Decay: %sT/t");
        replace(provider,"terminacore.recipe.fieldSlam", "§fField Consumed: %sT");
        replace(provider,"tagprefix.leached_ore", "Leached %s Ore");
        replace(provider,"tagprefix.prisma_frothed_ore", "Prisma Frothed %s Ore");
        replace(provider,"block.gtceu.iv_naquahine_mini_reactor", "§3Micro Naquahine Reactor§r");
        replace(provider,"block.gtceu.luv_naquahine_mini_reactor", "§dAdvanced Micro Naquahine Reactor§r");
        replace(provider,"block.gtceu.zpm_naquahine_mini_reactor", "§cElite Micro Naquahine Reactor§r");
        replace(provider,"block.gtceu.uv_naquahine_mini_reactor", "§3Ultimate Micro Naquahine Reactor§r");
        replace(provider,"block.gtceu.uhv_naquahine_mini_reactor", "§4Epic Micro Naquahine Reactor§r");

    }
}
