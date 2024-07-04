package org.chesterirod.towntal;


import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;

public class predmety implements Listener {
    public static ItemStack Sila2() {
        ItemStack sila = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) sila.getItemMeta();
        if (meta == null) {
            // Handle the case where the meta is not a SkullMeta instance
            return sila;
        }

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        PropertyMap propertyMap = profile.getProperties();
        boolean hasTexture = propertyMap.containsKey("textures");
        if (!hasTexture) {
            propertyMap.put("textures", new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTcxOTM4NzYzOTQ0MCwKICAicHJvZmlsZUlkIiA6ICIwNTU3YjFkZThmZTI0OTgyYjY5NmU5NTdmMzQwNTAwYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJjYW1lcm9ub3JlbWFjMTAxIiwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2I5MGVlYjkyZjE5OGFmMTVhZmU3ODc0NDdjNjQ2MWFkZGVlM2RiOTZmMWMzMDQ1YzM4OTc5Njc0MWMyZDFmMGUiCiAgICB9CiAgfQp9"));
        }
        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (NoSuchFieldException e) {
            e.printStackTrace(); // Обработка исключения, связанного с отсутствием поля
        } catch (IllegalAccessException e) {
            e.printStackTrace(); // Обработка исключения, связанного с недоступностью поля
        }
        meta.setDisplayName("§cТалисман силы");
        sila.setItemMeta(meta);
        return sila;
    }

    public static ItemStack skorost2() {
        ItemStack skor = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) skor.getItemMeta();
        if (meta == null) {
            // Handle the case where the meta is not a SkullMeta instance
            return skor;
        }
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        PropertyMap propertyMap = profile.getProperties();
        boolean hasTexture = propertyMap.containsKey("textures");
        if (!hasTexture) {
            propertyMap.put("textures", new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTcxOTM4OTI5MzcxMiwKICAicHJvZmlsZUlkIiA6ICIwNTU3YjFkZThmZTI0OTgyYjY5NmU5NTdmMzQwNTAwYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJjYW1lcm9ub3JlbWFjMTAxIiwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzI0YzIyYjhkZjBhODUzYTQ5Y2I4MmU5MGE2MThkNjUwMTIxMjIzNjFjODM5ODA2MmZjYmFmNzRkNTY5NmMyYTkiCiAgICB9CiAgfQp9"));
        }
        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (NoSuchFieldException e) {
            e.printStackTrace(); // Обработка исключения, связанного с отсутствием поля
        } catch (IllegalAccessException e) {
            e.printStackTrace(); // Обработка исключения, связанного с недоступностью поля
        }
        meta.setDisplayName("§cТалисман скорости");
        skor.setItemMeta(meta);
        return skor;
    }

    public static ItemStack ognestoi() {
        ItemStack ognestoi = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) ognestoi.getItemMeta();
        if (meta == null) {
            // Handle the case where the meta is not a SkullMeta instance
            return ognestoi;
        }

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        PropertyMap propertyMap = profile.getProperties();
        boolean hasTexture = propertyMap.containsKey("textures");
        if (!hasTexture) {
            propertyMap.put("textures", new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTcxOTM4OTY4NzQyMiwKICAicHJvZmlsZUlkIiA6ICIwNTU3YjFkZThmZTI0OTgyYjY5NmU5NTdmMzQwNTAwYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJjYW1lcm9ub3JlbWFjMTAxIiwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2YwZGY2YTQ0NGU5MDM1MTQyMDgxM2E3OGQ0YjRjOTM4NGQ3NmM0ZGM5MTgxZTFjMWVmYzZmNTYzZDM1MzY0MzgiCiAgICB9CiAgfQp9"));
        }
        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (NoSuchFieldException e) {
            e.printStackTrace(); // Обработка исключения, связанного с отсутствием поля
        } catch (IllegalAccessException e) {
            e.printStackTrace(); // Обработка исключения, связанного с недоступностью поля
        }
        meta.setDisplayName("§cТалисман огнейстойкости");
        ognestoi.setItemMeta(meta);
        return ognestoi;
    }

    public static ItemStack inviz() {
        ItemStack in = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) in.getItemMeta();
        if (meta == null) {
            // Handle the case where the meta is not a SkullMeta instance
            return in;
        }

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        PropertyMap propertyMap = profile.getProperties();
        boolean hasTexture = propertyMap.containsKey("textures");
        if (!hasTexture) {
            propertyMap.put("textures", new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTcxOTM4OTk1ODQ4MCwKICAicHJvZmlsZUlkIiA6ICIwNTU3YjFkZThmZTI0OTgyYjY5NmU5NTdmMzQwNTAwYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJjYW1lcm9ub3JlbWFjMTAxIiwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzNlMmQ4NGM5NzNkNTI3ZTQxODc0ZDJkYWRmOWMzOTFjNzA4ZjUyNDk4MWM1ODIwMzUxYmQxM2Q0NDU1ZWRkMTAiCiAgICB9CiAgfQp9"));
        }
        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (NoSuchFieldException e) {
            e.printStackTrace(); // Обработка исключения, связанного с отсутствием поля
        } catch (IllegalAccessException e) {
            e.printStackTrace(); // Обработка исключения, связанного с недоступностью поля
        }
        meta.setDisplayName("§cТалисман невидимости");
        in.setItemMeta(meta);
        return in;
    }

    public static ItemStack dish() {
        ItemStack d = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) d.getItemMeta();
        if (meta == null) {
            // Handle the case where the meta is not a SkullMeta instance
            return d;
        }

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        PropertyMap propertyMap = profile.getProperties();
        boolean hasTexture = propertyMap.containsKey("textures");
//        if (!hasTexture) {
        propertyMap.put("textures", new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTcxOTM5MDQwMTQ5MCwKICAicHJvZmlsZUlkIiA6ICIwNTU3YjFkZThmZTI0OTgyYjY5NmU5NTdmMzQwNTAwYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJjYW1lcm9ub3JlbWFjMTAxIiwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2UyYjU3NzcxNDE0ZjhjMDc3M2ZjOTY1ZjdmNTFlOTRjZGMxMDc4NDM1NDk0MTQ0MDRkNjdkMzc5ZjFkZTM5MzEiCiAgICB9CiAgfQp9"));
//        }
        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (NoSuchFieldException e) {
            e.printStackTrace(); // Обработка исключения, связанного с отсутствием поля
        } catch (IllegalAccessException e) {
            e.printStackTrace(); // Обработка исключения, связанного с недоступностью поля
        }
        meta.setDisplayName("§cТалисман подводного дыхания");
        d.setItemMeta(meta);
        return d;
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        ItemStack item = event.getItemInHand();
        if (item != null && item.getType() == Material.PLAYER_HEAD && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasDisplayName() && meta.getDisplayName().equals("§c§l[★] §cСфера Афины") || meta.getDisplayName().equals("§cТалисман подводного дыхания") || meta.getDisplayName().equals("§cТалисман скорости") || meta.getDisplayName().equals("§cТалисман огнейстойкости") || meta.getDisplayName().equals("§cТалисман невидимости") || meta.getDisplayName().equals("§cТалисман силы")) {
                event.setCancelled(true);
            }
        }
    }

}
