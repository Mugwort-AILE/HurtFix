package net.github.mugwort.events;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayingWorld {
    public static ResourceKey<Level> world = Level.OVERWORLD;
    public static Level level;

    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event){
        level = event.getEntity().getLevel();
    }


    @SubscribeEvent
    public static void onOtherDimension(PlayerEvent.PlayerChangedDimensionEvent event){
        world = event.getEntity().getLevel().dimension();
        level = event.getEntity().level;
    }

}
