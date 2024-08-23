package com.ghostipedia.terminacore.api.metals;

import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.dries007.tfc.common.TFCTiers;

import static com.ghostipedia.terminacore.api.metals.TerminaPropertyKeys.TFC_METAL_PROPERTY;

public class TFCMetalMaterial {

    public static void setTFCMetalProperty() {
        GTMaterials.Aluminium.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.WROUGHT_IRON.getLevel(), 1039, 823, 1243, GTMaterials.Iron));
    }
}
