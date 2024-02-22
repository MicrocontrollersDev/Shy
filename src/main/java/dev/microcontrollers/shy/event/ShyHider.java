package dev.microcontrollers.shy.event;

import dev.microcontrollers.shy.config.ShyConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ShyHider {
    @SubscribeEvent
    public void onEntityRender(RenderLivingEvent.Pre<EntityLivingBase> event) {
        if (!ShyConfig.toggled) return;
        if (ShyConfig.ignoreMobs && !(event.entity instanceof EntityOtherPlayerMP || event.entity instanceof EntityArmorStand)) return;
        if (ShyConfig.ignoreArmorStands && event.entity instanceof EntityArmorStand) return;
        if (ShyConfig.ignoreNPCs && event.entity.getUniqueID().version() == 2) return; // 2 means NPC
        Minecraft mc = Minecraft.getMinecraft();
        if (Math.sqrt(Math.pow(Math.abs(event.entity.posX - mc.thePlayer.posX), 2) + Math.pow(Math.abs(event.entity.posY - mc.thePlayer.posY), 2) + Math.pow(Math.abs(event.entity.posZ - mc.thePlayer.posZ), 2)) < ShyConfig.distance)
            event.setCanceled(true);
    }
}
