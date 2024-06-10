package mod.azure.iseelava;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(CommonMod.MOD_ID)
public final class NeoForgeMod {

    public static NeoForgeMod instance;

    public NeoForgeMod(IEventBus modEventBus) {
        instance = this;
    }
}
