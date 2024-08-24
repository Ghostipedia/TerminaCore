package com.ghostipedia.terminacore.api.metals;

import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.dries007.tfc.common.TFCTiers;

import static com.ghostipedia.terminacore.api.metals.TerminaPropertyKeys.TFC_METAL_PROPERTY;

public class TFCMetalMaterial {

    public static void setTFCMetalProperty() {
        GTMaterials.Aluminium.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.WROUGHT_IRON.getLevel(), 120, 245, 660, GTMaterials.Aluminium));
        GTMaterials.Iron.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.BRONZE.getLevel(), 921, 1228, 1538, GTMaterials.Iron));
        GTMaterials.Bronze.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.COPPER.getLevel(), 570, 760, 913, GTMaterials.Bronze));
        GTMaterials.Copper.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.IGNEOUS_EXTRUSIVE.getLevel(), 648, 864, 1100, GTMaterials.Copper));
        GTMaterials.Tin.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.COPPER.getLevel(), 138, 184, 231, GTMaterials.Tin));
        GTMaterials.Lead.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.IGNEOUS_EXTRUSIVE.getLevel(), 255, 290, 330, GTMaterials.Lead));
        GTMaterials.Steel.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.WROUGHT_IRON.getLevel(), 924, 1232, 1540, GTMaterials.Steel));
        GTMaterials.Potin.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.STEEL.getLevel(), 258, 300, 350, GTMaterials.Potin));
        GTMaterials.RoseGold.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.BRONZE.getLevel(), 950, 823, 1100, GTMaterials.RoseGold));
        GTMaterials.SterlingSilver.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.STEEL.getLevel(), 576, 768, 960, GTMaterials.SterlingSilver));
        GTMaterials.RedSteel.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.STEEL.getLevel(), 924, 1232, 1540, GTMaterials.RedSteel));
        GTMaterials.BlueSteel.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.BLACK_STEEL.getLevel(), 924, 1232, 1540, GTMaterials.BlueSteel));
        GTMaterials.BlackBronze.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.BRONZE.getLevel(), 642, 856, 1012, GTMaterials.BlackBronze));
        GTMaterials.BlackSteel.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.STEEL.getLevel(), 891, 1188, 1485, GTMaterials.BlackSteel));
        GTMaterials.Nickel.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.BRONZE.getLevel(), 872, 1162, 1455, GTMaterials.Nickel));
        GTMaterials.Invar.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.STEEL.getLevel(), 950, 823, 1427, GTMaterials.Invar));
        GTMaterials.WroughtIron.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.BRONZE.getLevel(), 921, 1228, 1538, GTMaterials.WroughtIron));
        GTMaterials.Brass.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.BRONZE.getLevel(), 558, 744, 930, GTMaterials.Brass));
        GTMaterials.BismuthBronze.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.BRONZE.getLevel(), 591, 788, 1012, GTMaterials.BismuthBronze));
        GTMaterials.Bismuth.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.BRONZE.getLevel(), 162, 216, 271, GTMaterials.Bismuth));
        GTMaterials.Silver.setProperty(TFC_METAL_PROPERTY,
                new TFCMetalProperty(TFCTiers.BRONZE.getLevel(), 577, 769, 961, GTMaterials.Silver));






    }
}
