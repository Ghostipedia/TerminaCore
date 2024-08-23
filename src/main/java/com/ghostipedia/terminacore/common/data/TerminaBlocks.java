package com.ghostipedia.terminacore.common.data;

import com.ghostipedia.terminacore.TerminaCore;
import com.ghostipedia.terminacore.api.TerminaCoreAPI;
import com.ghostipedia.terminacore.api.block.IMagnetType;
import com.ghostipedia.terminacore.client.renderer.block.NebulaeCoilRenderer;
import com.ghostipedia.terminacore.common.block.MagnetBlock;
import com.ghostipedia.terminacore.common.data.recipe.RecipeTags;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.block.RendererBlock;
import com.gregtechceu.gtceu.api.block.RendererGlassBlock;
import com.gregtechceu.gtceu.api.item.RendererBlockItem;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.lowdragmc.lowdraglib.Platform;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import static com.ghostipedia.terminacore.api.registries.TerminaRegistration.REGISTRATE;


public class TerminaBlocks {
    static {
        REGISTRATE.creativeModeTab(() -> TerminaCreativeModeTabs.TERMINA_CORE);

    }
    //Coil Register


    public static final BlockEntry<CoilBlock> COIL_PRISMATIC_TUNGSTENSTEEL = createCoilBlock(TerminaCoilBlock.CoilType.PRISMATIC_TUNGSTENSTEEL);
    public static final BlockEntry<CoilBlock> COIL_RESONANT_VIRTUE_MELD = createCoilBlock(TerminaCoilBlock.CoilType.RESONANT_VIRTUE_MELD);
    public static final BlockEntry<CoilBlock> COIL_NAQUADIC_SUPERALLOY = createCoilBlock(TerminaCoilBlock.CoilType.NAQUADIC_SUPERALLOY);
    public static final BlockEntry<CoilBlock> COIL_TRANAVINE = createCoilBlock(TerminaCoilBlock.CoilType.TRINAVINE);
    public static final BlockEntry<CoilBlock> COIL_PSIONIC_GALVORN = createCoilBlock(TerminaCoilBlock.CoilType.PSIONIC_GALVORN);
    public static final BlockEntry<CoilBlock> COIL_LIVING_IGNICLAD = createCoilBlock(TerminaCoilBlock.CoilType.LIVING_IGNICLAD);
    public static final BlockEntry<CoilBlock> COIL_PROGRAMMABLE_MATTER = createCoilBlock(TerminaCoilBlock.CoilType.PROGRAMMABLE_MATTER);
    public static final BlockEntry<CoilBlock> COIL_SHIMMERING_NEUTRONIUM = createCoilBlock(TerminaCoilBlock.CoilType.SHIMMERING_NEUTRONIUM);
    public static final BlockEntry<CoilBlock> COIL_CAUSAL_FABRIC = createCoilBlock(TerminaCoilBlock.CoilType.CAUSAL_FABRIC,
            Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_all"),
                    Map.of("all", TerminaCore.id("block/casings/coils/causal_fabric_off"))) : null,
            Platform.isClient() ? new NebulaeCoilRenderer(new ResourceLocation("block/cube_all"),
                    Map.of("all", TerminaCoilBlock.CoilType.CAUSAL_FABRIC.getTexture())) : null

            );
    public static final BlockEntry<Block> CASING_DYSON_CELL = createCasingBlock("dyson_solar_cell", TerminaCore.id("block/casings/solid/dyson_solar_cell"));
    public static final BlockEntry<Block> NAQUADAH_PRESSURE_RESISTANT_CASING = createCasingBlock("naquadah_pressure_resistant_casing", TerminaCore.id("block/casings/solid/naquadah_pressure_resistant_casing"));
    public static final BlockEntry<Block> RESONANTLY_TUNED_VIRTUE_MELD_CASING = createCasingBlock("resonantly_tuned_virtue_meld_casing", TerminaCore.id("block/casings/solid/resonantly_tuned_virtue_meld_casing"));
    public static final BlockEntry<Block> ALTERNATOR_FLUX_COILING = createCasingBlock("alternator_flux_coiling", TerminaCore.id("block/casings/solid/alternator_flux_coiling_copper"));
    public static final BlockEntry<Block> PLATED_AEROCLOUD = createCasingBlock("plated_aerocloud", TerminaCore.id("block/casings/solid/plated_aerocloud"));

    public static final BlockEntry<MagnetBlock> MAGNET_HIGH_POWERED = createMagnetBlock(MagnetBlock.MagnetType.HIGH_POWERED);
    public static final BlockEntry<MagnetBlock> MAGNET_FUSION_GRADE = createMagnetBlock(MagnetBlock.MagnetType.FUSION_GRADE);


//TODO : FIGURE OUT WHY these are  breaking the minable tags for pickaxe/wrench..
    public static final BlockEntry<Block> HIGH_TEMP_FISSION_CASING = createCasingBlockWrenchOnly("high_temperature_fission_casing", TerminaCore.id("block/casings/solid/high_temperature_fission_casing"));
    public static final BlockEntry<Block> VOMAHINE_CERTIFIED_CHEMICALLY_RESISTANT_CASING = createCasingBlockWrenchOnly("vomahine_certified_chemically_resistant_casing", TerminaCore.id("block/casings/solid/vomahine_certified_chemically_resistant_casing"));
    public static final BlockEntry<Block> VOMAHINE_CERTIFIED_CHEMICALLY_RESISTANT_PIPE = createCasingBlockWrenchOnly("vomahine_certified_chemically_resistant_pipe", TerminaCore.id("block/casings/solid/vomahine_certified_chemically_resistant_pipe"));
    public static final BlockEntry<Block> VOMAHINE_CERTIFIED_INTERSTELLAR_GRADE_CASING = createCasingBlockWrenchOnly("vomahine_certified_interstellar_grade_casing", TerminaCore.id("block/casings/solid/vomahine_certified_interstellar_grade_casing"));
    public static final BlockEntry<Block> VOMAHINE_ULTRA_POWERED_CASING = createCasingBlockWrenchOnly("vomahine_ultra_powered_casing", TerminaCore.id("block/casings/solid/vomahine_ultra_powered_casing"));
    public static final BlockEntry<Block> HIGHLY_CONDUCTIVE_FISSION_CASING = createCasingBlockWrenchOnly("highly_conductive_fission_casing", TerminaCore.id("block/casings/solid/highly_conductive_fission_casing"));

    //This is a Bunch of Rendering Magic I barely understand (See: I Don't understand at all) ~Ghost
    private static BlockEntry<Block> createCasingBlock(String name, ResourceLocation texture) {
        return createCasingBlock(name, RendererBlock::new, texture, () -> Blocks.IRON_BLOCK, () -> RenderType::cutoutMipped);
    }
    private static BlockEntry<Block> createCasingBlockWrenchOnly(String name, ResourceLocation texture) {
        return createCasingBlockWrenchOnly(name, RendererBlock::new, texture, () -> Blocks.IRON_BLOCK, () -> RenderType::cutoutMipped);
    }
    private static BlockEntry<Block> createGlassCasingBlock(String name, ResourceLocation texture, Supplier<Supplier<RenderType>> type) {
        return createCasingBlockWrenchOnly(name, RendererGlassBlock::new, texture, () -> Blocks.GLASS, type);
    }

    private static BlockEntry<Block> createCasingBlock(String name, BiFunction<BlockBehaviour.Properties, IRenderer, ? extends RendererBlock> blockSupplier, ResourceLocation texture, NonNullSupplier<? extends Block> properties, Supplier<Supplier<RenderType>> type) {
        return REGISTRATE.block(name, p -> (Block) blockSupplier.apply(p,
                        Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_all"),
                                Map.of("all", texture)) : null))
                .initialProperties(properties)
                .blockstate(NonNullBiConsumer.noop())

                .tag(RecipeTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
    }
    private static BlockEntry<Block> createCasingBlockWrenchOnly(String name, BiFunction<BlockBehaviour.Properties, IRenderer, ? extends RendererBlock> blockSupplier, ResourceLocation texture, NonNullSupplier<? extends Block> properties, Supplier<Supplier<RenderType>> type) {
        return REGISTRATE.block(name, p -> (Block) blockSupplier.apply(p,
                        Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_all"),
                                Map.of("all", texture)) : null))
                .initialProperties(properties)
                .blockstate(NonNullBiConsumer.noop())
                .tag(RecipeTags.MINEABLE_WITH_WRENCH)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
    }
    private static BlockEntry<Block> createBottomTopCasingBlock(String name, BiFunction<BlockBehaviour.Properties, IRenderer, ? extends RendererBlock> blockSupplier, ResourceLocation sideTexture, ResourceLocation topTexture, ResourceLocation bottomTexture, NonNullSupplier<? extends Block> properties, Supplier<Supplier<RenderType>> type) {
        return REGISTRATE.block(name, p -> (Block) blockSupplier.apply(p,
                        Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_bottom_top"),
                                Map.of("side", sideTexture, "top", topTexture, "bottom", bottomTexture)) : null))
                .initialProperties(properties)
                .blockstate(NonNullBiConsumer.noop())
                .tag(RecipeTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
    }

    private static BlockEntry<CoilBlock> createCoilBlock(ICoilType coilType) {
        BlockEntry<CoilBlock> coilBlock = REGISTRATE.block("%s_coil_block".formatted(coilType.getName()), p -> new CoilBlock(p, coilType))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(RecipeTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
        GTCEuAPI.HEATING_COILS.put(coilType, coilBlock);
        return coilBlock;
    }
    private static BlockEntry<CoilBlock> createCoilBlock(ICoilType coilType, IRenderer renderer, IRenderer activeRenderer) {
        BlockEntry<CoilBlock> coilBlock = REGISTRATE.block("%s_coil_block".formatted(coilType.getName()), p -> (CoilBlock) new TerminaCoilBlock(p, coilType, renderer, activeRenderer))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::translucent)
                .blockstate(NonNullBiConsumer.noop())
                .tag(RecipeTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
        GTCEuAPI.HEATING_COILS.put(coilType, coilBlock);
        return coilBlock;
    }
    private static BlockEntry<MagnetBlock> createMagnetBlock(IMagnetType magnetType) {
        BlockEntry<MagnetBlock> magnetBlock = REGISTRATE.block("%s_magnet".formatted(magnetType.getName()), p -> new MagnetBlock(p, magnetType))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(RecipeTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
        TerminaCoreAPI.MAGNET_COILS.put(magnetType,magnetBlock);

        return magnetBlock;
    }

    public static void init() {

    }
}
