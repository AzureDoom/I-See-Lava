package mod.azure.iseelava;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.fluid.Fluids;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ISeeLavaClientMod implements ClientModInitializer {
	public static final String ID = "iseelava";

	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putFluid(Fluids.LAVA, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putFluid(Fluids.FLOWING_LAVA, RenderLayer.getTranslucent());

		FabricLoader.getInstance().getModContainer(ID).ifPresent(container -> {
			ResourceManagerHelper.registerBuiltinResourcePack(asId("translucent_lava"), container, ResourcePackActivationType.DEFAULT_ENABLED);
		});
	}
	public static Identifier asId(String path) {
		return new Identifier(ID, path);
	}
}
