package org.chesterirod.towntal;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MenuCreator {

    public static void openMenu(Player player) {
        Inventory menu = Bukkit.createInventory(null, 54, "Obsidian Pickaxe Menu");

        ItemStack sila = predmety.Sila2();
        menu.setItem(5, sila);

        ItemStack skor = predmety.skorost2();
        menu.setItem(4,skor);

        ItemStack ogn = predmety.ognestoi();
        menu.setItem(3,ogn);

        ItemStack inv = predmety.inviz();
        menu.setItem(2,inv);

        ItemStack nod = predmety.dish();
        menu.setItem(1,nod);

        player.openInventory(menu);
    }
}