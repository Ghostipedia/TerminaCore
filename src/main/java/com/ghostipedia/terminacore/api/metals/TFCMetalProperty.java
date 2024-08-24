package com.ghostipedia.terminacore.api.metals;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nullable;

@Setter
@Getter
public class TFCMetalProperty implements IMaterialProperty<TFCMetalProperty> {

    private int heatCapacity;
    private int meltingTemp;
    private int forgingTemp;
    private int weldingTemp;
    private int tier;
    private Material fluidMaterial;

    public TFCMetalProperty(int tier, int forgingTemp, int weldingTemp, int meltingTemp,
                            @Nullable Material fluidMaterial) {
        this.tier = tier;
        this.forgingTemp = forgingTemp;
        this.weldingTemp = weldingTemp;
        this.meltingTemp = meltingTemp;
        this.fluidMaterial = fluidMaterial;
    }

    @Override
    public void verifyProperty(MaterialProperties properties) {
        properties.ensureSet(PropertyKey.INGOT);
        properties.ensureSet(PropertyKey.FLUID);
        this.meltingTemp = Math.max(0, meltingTemp);
        this.tier = Math.max(0, tier);
        this.weldingTemp = Math.max(0, weldingTemp);
        this.forgingTemp = Math.max(0, forgingTemp);
    }
}
