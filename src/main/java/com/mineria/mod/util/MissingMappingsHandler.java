package com.mineria.mod.util;

import com.mineria.mod.Mineria;
import com.mineria.mod.References;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = References.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MissingMappingsHandler
{
    private static final Map<String, String> OLD_TO_NEW_MAPPINGS = Util.make(new HashMap<>(), map -> {
        map.put("mineria_xp_orb", "xp_orb");
    });

    @SubscribeEvent
    public static void fixMissingItemMappings(RegistryEvent.MissingMappings<Item> event)
    {
        if(event.getAllMappings() != null)
        {
            List<RegistryEvent.MissingMappings.Mapping<Item>> MOD_MAPPINGS = event.getAllMappings().stream().filter(mapping -> mapping.key.getNamespace().equals("mineria")).collect(Collectors.toList());

            if(!MOD_MAPPINGS.isEmpty())
            {
                Mineria.LOGGER.info("Fixing missing mappings from modid mineria...");
                OLD_TO_NEW_MAPPINGS.forEach((oldName, newName) -> MOD_MAPPINGS.forEach(mapping -> {
                    if(mapping.key.equals(new ResourceLocation(References.MODID, oldName)))
                    {
                        Item newItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(References.MODID, newName));
                        if(newItem == null)
                            Mineria.LOGGER.error("Failed to fix " + mapping.key + ", could not find item with key mineria:" + newName + " ! Please report this error to the mod author.");
                        else
                            mapping.remap(newItem);
                    }
                }));
            }
        }
    }
}
