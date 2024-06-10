package mod.azure.iseelava;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;

@EventBusSubscriber(modid = CommonMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class NeoForgeClientMod {

    @SubscribeEvent
    public static void registerRenderers(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(Fluids.LAVA, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(Fluids.FLOWING_LAVA, RenderType.translucent());
    }

    @SubscribeEvent
    public static void onConstructMod(final AddPackFindersEvent event) {
        event.addPackFinders(CommonMod.modResource("resourcepacks/translucent_lava"),
                PackType.CLIENT_RESOURCES,
                Component.literal("iseelava"),
                PackSource.FEATURE,
                true,
                Pack.Position.TOP);
    }
}
