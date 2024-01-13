package mod.acgaming.universaltweaks.tweaks.misc.xp.drop;

import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import mod.acgaming.universaltweaks.UniversalTweaks;
import mod.acgaming.universaltweaks.config.UTConfigGeneral;
import mod.acgaming.universaltweaks.config.UTConfigTweaks;

@Mod.EventBusSubscriber(modid = UniversalTweaks.MODID)
public class UTAdaptiveXPDrops
{
    @SubscribeEvent
    public static void utAdaptiveXPDrops(LivingExperienceDropEvent event)
    {
        if (UTConfigTweaks.ENTITIES.utAdaptiveXPFactor <= 0) return;
        if (UTConfigGeneral.DEBUG.utDebugToggle) UniversalTweaks.LOGGER.debug("UTAdaptiveXPDrops ::: Living experience drop event");
        event.setDroppedExperience(Math.max(1, (int) (event.getEntityLiving().getMaxHealth() * UTConfigTweaks.ENTITIES.utAdaptiveXPFactor)));
    }
}