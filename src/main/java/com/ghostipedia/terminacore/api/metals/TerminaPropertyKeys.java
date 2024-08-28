package com.ghostipedia.terminacore.api.metals;

import com.ghostipedia.terminacore.common.material.property.TFCOreProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

public class TerminaPropertyKeys {

    public static PropertyKey<TFCMetalProperty> TFC_METAL_PROPERTY = new PropertyKey<>("tfc_metal_property",
            TFCMetalProperty.class);
    public static final PropertyKey<TFCOreProperty> TFC_ORE_PROPERTY = new PropertyKey<>("tfc_ore", TFCOreProperty.class);

}
