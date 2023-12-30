package net.github.mugwort.events;


import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerHurtEvent {
    @SubscribeEvent
    public static void onHurt(LivingHurtEvent event){

    }
}
