package com.ghostipedia.terminacore.api.item.armor;

import net.minecraft.network.chat.Component;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import com.ghostipedia.terminacore.common.data.tag.item.TerminaItemTags;
import earth.terrarium.adastra.api.systems.OxygenApi;
import earth.terrarium.adastra.common.constants.ConstantComponents;
import earth.terrarium.adastra.common.registry.ModFluids;
import earth.terrarium.adastra.common.utils.FluidUtils;
import earth.terrarium.adastra.common.utils.TooltipUtils;
import earth.terrarium.botarium.common.fluid.FluidConstants;

import java.util.List;
import java.util.stream.StreamSupport;

public interface ISpaceSuite {

    default void tickOxygen(Level Level, Player player, ItemStack itemStack) {
        if (Level.isClientSide) return;
        if (player.isCreative() || player.isSpectator()) return;
        if (!(itemStack.getItem() instanceof SpaceArmorComponentItem suit)) return;
        player.setTicksFrozen(0);
        if (player.tickCount % 12 == 0 && suit.hasOxygen(player)) {
            if (!OxygenApi.API.hasOxygen(player)) suit.consumeOxygen(itemStack, 1);
            if (player.isEyeInFluid(FluidTags.WATER)) {
                suit.consumeOxygen(itemStack, 1);
                player.setAirSupply(Math.min(player.getMaxAirSupply(), player.getAirSupply() + 4 * 10));
            }
        }
    }

    static boolean hasFullNanoSet(LivingEntity entity) {
        return hasFullSet(entity, TerminaItemTags.NANOMUSCLE_SPACE_SUITE);
    }

    static boolean hasFullQuantumSet(LivingEntity entity) {
        return hasFullSet(entity, TerminaItemTags.QUARKTECH_SPACE_SUITE);
    }

    static boolean hasFullSet(LivingEntity entity, TagKey<Item> tagKey) {
        return StreamSupport.stream(entity.getArmorSlots().spliterator(), false)
                .allMatch(itemStack -> itemStack.is(tagKey));
    }

    default void onArmorTick(Level Level, Player player, ItemStack itemStack, ArmorItem.Type type) {
        if (type == ArmorItem.Type.CHESTPLATE) this.tickOxygen(Level, player, itemStack);
    }

    default void addInfo(ItemStack itemStack, List<Component> lines, ArmorItem.Type type) {
        if (type == ArmorItem.Type.CHESTPLATE && itemStack.getItem() instanceof SpaceArmorComponentItem suit) {
            lines.add(TooltipUtils.getFluidComponent(
                    FluidUtils.getTank(itemStack),
                    FluidConstants.fromMillibuckets(suit.getFluidContainer(itemStack).getTankCapacity(0)),
                    ModFluids.OXYGEN.get()));
            TooltipUtils.addDescriptionComponent(lines, ConstantComponents.SPACE_SUIT_INFO);
        }
    }
}
