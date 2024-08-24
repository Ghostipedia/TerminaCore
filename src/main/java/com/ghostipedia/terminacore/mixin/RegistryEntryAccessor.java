package com.ghostipedia.terminacore.mixin;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = RegistryEntry.class, remap = false)
public interface RegistryEntryAccessor<T> {

    @Accessor
    RegistryObject<T> getDelegate();

}
