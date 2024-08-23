package com.ghostipedia.terminacore.common.data;

import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.block.CoilBlock;

import com.lowdragmc.lowdraglib.client.renderer.IRenderer;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import com.ghostipedia.terminacore.TerminaCore;
import com.ghostipedia.terminacore.common.data.materials.TerminaMaterials;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class TerminaCoilBlock extends CoilBlock implements EntityBlock {

    public TerminaCoilBlock(Properties properties, ICoilType coilType, @Nullable IRenderer renderer,
                            @Nullable IRenderer activeRenderer) {
        super(properties, coilType, renderer, activeRenderer);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return TerminaBlockEntities.CAUSAL_FABRIC_COIL_BLOCK_ENTITY.create(pos, state);
    }

    public enum CoilType implements StringRepresentable, ICoilType {

        PRISMATIC_TUNGSTENSTEEL("prismatic_tungstensteel", 4500, 3, 4, 2, () -> TerminaMaterials.PrismaticTungstensteel,
                TerminaCore.id("block/casings/coils/prismatic_tungstensteel")),
        RESONANT_VIRTUE_MELD("resonant_virtue_meld", 5400, 4, 5, 3, () -> TerminaMaterials.ResonantVirtueMeld,
                TerminaCore.id("block/casings/coils/resonant_virtue_meld")),
        NAQUADIC_SUPERALLOY("naquadric_superalloy", 7200, 5, 6, 4, () -> TerminaMaterials.NaquadicSuperalloy,
                TerminaCore.id("block/casings/coils/naquadric_superalloy")),
        TRINAVINE("reinforced_trinavine", 9500, 3, 7, 4, () -> TerminaMaterials.Trinavine,
                TerminaCore.id("block/casings/coils/trinavine")),
        LIVING_IGNICLAD("living_igniclad", 10800, 7, 8, 5, () -> TerminaMaterials.LivingIgniclad,
                TerminaCore.id("block/casings/coils/living_igniclad")),
        PSIONIC_GALVORN("psionic_galvorn", 12800, 8, 9, 6, () -> TerminaMaterials.PsionicGalvorn,
                TerminaCore.id("block/casings/coils/psionic_galvorn")),
        PROGRAMMABLE_MATTER("programable_matter", 15800, 9, 10, 7, () -> TerminaMaterials.ProgrammableMatter,
                TerminaCore.id("block/casings/coils/programable_matter")),
        SHIMMERING_NEUTRONIUM("shimmering_neutronium", 19840, 10, 11, 8, () -> TerminaMaterials.ShimmeringNeutronium,
                TerminaCore.id("block/casings/coils/shimmering_neutronium")),
        CAUSAL_FABRIC("causal_fabric", 36000, 11, 15, 9, () -> TerminaMaterials.CausalFabric,
                TerminaCore.id("block/casings/coils/causal_fabric"));

        @NotNull
        @Getter
        private final String name;
        // electric blast furnace properties
        @Getter
        private final int coilTemperature;
        @Getter
        private final int tier;
        // multi smelter properties
        @Getter
        private final int level;
        @Getter
        private final int energyDiscount;
        @NotNull
        private final Supplier<Material> material;
        @NotNull
        @Getter
        private final ResourceLocation texture;

        CoilType(String name, int coilTemperature, int tier, int level, int energyDiscount, Supplier<Material> material,
                 ResourceLocation texture) {
            this.name = name;
            this.coilTemperature = coilTemperature;
            this.tier = tier;
            this.level = level;
            this.energyDiscount = energyDiscount;
            this.material = material;
            this.texture = texture;
        }

        public Material getMaterial() {
            return material.get();
        }

        @NotNull
        @Override
        public String toString() {
            return getName();
        }

        @Override
        @NotNull
        public String getSerializedName() {
            return name;
        }
    }
}
