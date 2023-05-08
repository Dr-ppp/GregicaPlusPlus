package me.oganesson.gregica.common.unification.materials;

import gregtech.api.unification.material.Material;
import me.oganesson.gregica.common.unification.materials.material.FirstDegreeMaterials;
import me.oganesson.gregica.common.unification.materials.material.SecondDegreeMaterials;

public class GCMaterials {
    //Material ID: 26000-27000

    public static Material Coolant;
    public static Material SuperCoolant;
    public static Material Cryotheum;
    public static Material XPJuice;
    public static Material Blood;
    public static Material Pure;
    public static Material Death;
    public static Material Spirit;
    public static Material Hollowtears;
    public static Material AtomicSeparationCatalyst;
    public static Material Tiberium;
    public static Material NeutronsFlow;
    public static Material ProtonFlow;
    public static Material BismuthLeadAlloy;
    public static Material UreaMix;
    public static Material FermentationBase;
    public static Material Resin;
    public static Material CalciumCarbonate;
    public static Material PropionicAcid;
    public static Material SodiumAluminate;
    public static Material RedMud;
    public static Material Butanol;
    public static Material Formaldehyde;

    public static void register() {
        FirstDegreeMaterials.register();
        SecondDegreeMaterials.register();
    }
}