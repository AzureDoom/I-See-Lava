package mod.azure.iseelava;

import net.minecraft.resources.ResourceLocation;

public class CommonMod {
    public static final String MOD_ID = "iseelava";

    public static final ResourceLocation modResource(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
