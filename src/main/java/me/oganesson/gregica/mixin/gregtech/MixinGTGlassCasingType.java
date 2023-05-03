package me.oganesson.gregica.mixin.gregtech;

import gregtech.common.blocks.BlockGlassCasing;
import me.oganesson.gregica.api.blocks.ITiredGlass;
import net.minecraft.util.IStringSerializable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nonnull;

@Mixin(BlockGlassCasing.CasingType.class)
public abstract class MixinGTGlassCasingType implements IStringSerializable,  ITiredGlass {
    
    
    @Shadow(remap = false) @Nonnull public abstract String getName();
    
    @Override
    public int getTier() {
        switch (getName()){
            case("tempered_glass"):
                return 3;
            case("fusion_glass"):
                return 9;
            case("laminated_glass"):
                return 4;
        }
        return 3;
    }
}