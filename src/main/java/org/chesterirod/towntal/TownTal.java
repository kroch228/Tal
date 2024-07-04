package org.chesterirod.towntal;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class TownTal extends JavaPlugin {
    private BukkitTask task;

    @Override
    public void onEnable() {
        TalismanCommand talismanCommand = new TalismanCommand();
        getCommand("talgive").setExecutor(talismanCommand);
        getCommand("talgive").setTabCompleter(talismanCommand);
        getServer().getPluginManager().registerEvents(new MenuNastroyki(), this);
        getServer().getPluginManager().registerEvents(new predmety(), this);
        task = new task().runTaskTimer(this, 0, 20);

        if (getCommand("tal") != null) {
            getCommand("tal").setExecutor(this);
        } else {
            getLogger().severe("Command 'tal' not found in plugin.yml");
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("Town.Tal")) {
            if (args.length > 0) {
                Player targetPlayer = Bukkit.getPlayer(args[0]);
                if (targetPlayer != null) {
                    MenuCreator.openMenu(targetPlayer);
                    sender.sendMessage("Талисман выдан игроку " + targetPlayer.getName());
                } else {
                    sender.sendMessage("Игрок не найден.");
                }
            } else if (sender instanceof Player) {
                Player player = (Player) sender;
                MenuCreator.openMenu(player);
            } else {
                sender.sendMessage("Эту команду можно выполнить только от имени игрока или с указанием имени игрока.");
            }
            return true;
        } else {
            sender.sendMessage("У вас нет разрешения.");
        }
        return false;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
