package org.chesterirod.towntal;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TalismanCommand implements CommandExecutor, TabCompleter {

    private static final List<String> TALISMANS_ENGLISH = Arrays.asList("sila", "skorost", "ognestoi", "inviz", "dish");
    private static final List<String> TALISMANS_RUSSIAN = Arrays.asList("силы", "скорости", "огнестойкости", "невидимости", "подводного дыхания");
    private static final Map<String, String> TALISMAN_MAP = new HashMap<>();

    static {
        for (int i = 0; i < TALISMANS_ENGLISH.size(); i++) {
            TALISMAN_MAP.put(TALISMANS_RUSSIAN.get(i), TALISMANS_ENGLISH.get(i));
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("town.talisman.give")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }

        if (args.length != 2) {
            sender.sendMessage(ChatColor.RED + "Usage: /talgive <player> <talisman_name>");
            return true;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);
        if (targetPlayer == null) {
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }

        String talismanType = TALISMAN_MAP.get(args[1].toLowerCase());
        if (talismanType == null) {
            sender.sendMessage(ChatColor.RED + "Invalid talisman name.");
            return true;
        }

        ItemStack talisman;
        switch (talismanType) {
            case "sila":
                talisman = predmety.Sila2();
                break;
            case "skorost":
                talisman = predmety.skorost2();
                break;
            case "ognestoi":
                talisman = predmety.ognestoi();
                break;
            case "inviz":
                talisman = predmety.inviz();
                break;
            case "dish":
                talisman = predmety.dish();
                break;
            default:
                sender.sendMessage(ChatColor.RED + "Invalid talisman name.");
                return true;
        }

        targetPlayer.getInventory().addItem(talisman);
//        sender.sendMessage(ChatColor.GREEN + "You have given a " + talisman.getItemMeta().getDisplayName() + " to " + targetPlayer.getName());
        targetPlayer.sendMessage(ChatColor.GREEN + "Вы получили " + talisman.getItemMeta().getDisplayName());
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> playerNames = new ArrayList<>();
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.getName().toLowerCase().startsWith(args[0].toLowerCase())) {
                    playerNames.add(player.getName());
                }
            }
            return playerNames;
        } else if (args.length == 2) {
            List<String> completions = new ArrayList<>();
            for (String talisman : TALISMANS_RUSSIAN) {
                if (talisman.startsWith(args[1].toLowerCase())) {
                    completions.add(talisman);
                }
            }
            return completions;
        }
        return null;
    }
}
