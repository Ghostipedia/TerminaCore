package com.ghostipedia.terminacore;

import com.ghostipedia.terminacore.api.pattern.TerminaPredicates;
import com.ghostipedia.terminacore.api.registries.TerminaRegistration;
import com.ghostipedia.terminacore.api.capability.TerminaCapabilities;
import com.ghostipedia.terminacore.client.TerminaCoreClient;
import com.ghostipedia.terminacore.common.data.*;
import com.ghostipedia.terminacore.common.data.materials.TerminaMaterialSet;
import com.ghostipedia.terminacore.common.data.materials.TerminaMaterials;
import com.ghostipedia.terminacore.gtbridge.TerminaRecipeTypes;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.lowdragmc.lowdraglib.Platform;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Mod(TerminaCore.MOD_ID)
public class TerminaCore {
    public static final String MOD_ID = "terminacore", NAME = "TerminaCore";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static MaterialRegistry MATERIAL_REGISTRY;

    //Init Everything
    public TerminaCore() {
        TerminaCore.init();
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.register(this);
        bus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
       // bus.addGenericListener(Class.class, this::registerRecipeConditions);
       // bus.addGenericListener(MachineDefinition.class, this::registerMachines);
        bus.addGenericListener(MachineDefinition.class, this::registerMachines);

        if (Platform.isClient()) {
            bus.register(TerminaCoreClient.class);
        }
    }

    public static void init() {
        ConfigHolder.init();
        TerminaCreativeModeTabs.init();
        TerminaBlocks.init();
        TerminaBlockEntities.init();
        TerminaItems.init();
        TerminaRegistration.REGISTRATE.registerRegistrate();
        TerminaCoreDatagen.init();
        TerminaPredicates.init();
        TerminaMaterialSet.init();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    @SubscribeEvent
    public void registerMaterialRegistry(MaterialRegistryEvent event) {
        MATERIAL_REGISTRY = GTCEuAPI.materialManager.createRegistry(TerminaCore.MOD_ID);
    }

    @SubscribeEvent
    public void registerMaterials(MaterialEvent event) {
        TerminaMaterials.register();
    }

    @SubscribeEvent
    public void onLoadComplete(FMLLoadCompleteEvent event) {
        GTCEuAPI.HEATING_COILS.remove(CoilBlock.CoilType.RTMALLOY);
        GTCEuAPI.HEATING_COILS.remove(CoilBlock.CoilType.HSSG);
        GTCEuAPI.HEATING_COILS.remove(CoilBlock.CoilType.NAQUADAH);
        GTCEuAPI.HEATING_COILS.remove(CoilBlock.CoilType.TRINIUM);
        GTCEuAPI.HEATING_COILS.remove(CoilBlock.CoilType.TRITANIUM);
//        GCyMMachines.PARALLEL_HATCH = (MachineDefinition[]) Arrays.stream(GCyMMachines.PARALLEL_HATCH).filter(p -> p.getTier() < GTValues.ZPM).toArray();
    }

    public void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        TerminaRecipeTypes.init();
    }

    public void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        TerminaMachines.init();
    }

    @SubscribeEvent
    public void registerCapabilities(RegisterCapabilitiesEvent event) {
        TerminaCapabilities.register(event);
    }
}
