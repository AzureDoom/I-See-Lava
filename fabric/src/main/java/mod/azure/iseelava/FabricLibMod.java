package mod.azure.iseelava;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.material.Fluids;

public final class FabricLibMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putFluid(Fluids.LAVA, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putFluid(Fluids.FLOWING_LAVA, RenderType.translucent());
        FabricLoader.getInstance().getModContainer(CommonMod.MOD_ID).ifPresent(container -> ResourceManagerHelper.registerBuiltinResourcePack(CommonMod.modResource("translucent_lava"), container, ResourcePackActivationType.DEFAULT_ENABLED));
    }
}
