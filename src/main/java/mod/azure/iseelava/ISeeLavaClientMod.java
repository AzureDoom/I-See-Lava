package mod.azure.iseelava;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.nio.file.Path;
import java.util.Optional;

@Mod.EventBusSubscriber(modid = Main.ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ISeeLavaClientMod {

    @SubscribeEvent
    public static void initClient(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(Fluids.LAVA, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(Fluids.FLOWING_LAVA, RenderType.translucent());
    }

    @SubscribeEvent
    public static void onAddPackFindersEvent(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            Optional<? extends ModContainer> optionalContainer = ModList.get().getModContainerById(Main.ID);

            if (optionalContainer.isEmpty()) {
                return;
            }
            event.addRepositorySource(
                (consumer) -> consumer.accept(createPack("translucent_lava", "Translucent Lava"))
            );
        }
    }

    public static Pack createPack(String id, String name) {
        Path resourcePath = ModList.get().getModFileById(Main.ID).getFile().findResource("resourcepacks", id);
        return Pack.readMetaAndCreate(
            "builtin/" + id,
            Component.literal(name),
            true,
            (path) -> new PathPackResources(path, resourcePath, false),
            PackType.CLIENT_RESOURCES,
            Pack.Position.TOP,
            PackSource.BUILT_IN
        );
    }
}
