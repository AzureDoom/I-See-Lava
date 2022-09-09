package mod.azure.iseelava;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.fluid.Fluids;

@Environment(EnvType.CLIENT)
public class ISeeLavaClientMod implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putFluid(Fluids.LAVA, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putFluid(Fluids.FLOWING_LAVA, RenderLayer.getCutout());
	}
}
