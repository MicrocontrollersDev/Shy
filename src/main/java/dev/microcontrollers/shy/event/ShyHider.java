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
        EntityLivingBase entity = event.entity;
        if (ShyConfig.ignoreMobs && !(entity instanceof EntityOtherPlayerMP || entity instanceof EntityArmorStand)) return;
        if (ShyConfig.ignoreArmorStands && entity instanceof EntityArmorStand) return;
        if (ShyConfig.ignoreNPCs && entity.getUniqueID().version() == 2) return; // 2 means NPC
        if (Minecraft.getMinecraft().thePlayer.getDistanceToEntity(entity) < ShyConfig.distance)
            event.setCanceled(true);
    }
}
