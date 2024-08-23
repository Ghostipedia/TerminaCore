package com.ghostipedia.terminacore.api.data;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.Conditions.hasOreProperty;

public class TerminaCoreTagPrefix {

    public static TagPrefix crushedLeached;
    public static TagPrefix prismaFrothed;

    public static void initTagPrefixes() {
        crushedLeached = new TagPrefix("leachedOre")
                .idPattern("leached_%s_ore")
                .defaultTagPath("leached_ores/%s")
                .defaultTagPath("leached_ores")
                .materialIconType(TerminaCoreMaterialIconType.crushedLeached)
                .unificationEnabled(true)
                .generateItem(true)
                .generationCondition(hasOreProperty);
        prismaFrothed = new TagPrefix("prismaFrothedOre")
                .idPattern("prisma_frothed_%s_ore")
                .defaultTagPath("prisma_frothed_ores/%s")
                .defaultTagPath("prisma_frothed_ores")
                .materialIconType(TerminaCoreMaterialIconType.prismaFrothed)
                .unificationEnabled(true)
                .generateItem(true)
                .generationCondition(hasOreProperty);
    }
}
