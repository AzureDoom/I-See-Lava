package mod.azure.iseelava;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("iseelava")
public class ISeeLavaClientMod {

	public ISeeLavaClientMod() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(Fluids.LAVA, RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Fluids.FLOWING_LAVA, RenderType.translucent());
	}
}
