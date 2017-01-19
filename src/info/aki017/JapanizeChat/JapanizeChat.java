package info.aki017.JapanizeChat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class JapanizeChat extends JavaPlugin {
  public static final Logger logger = Bukkit.getLogger();
  private ConfigHandler configHandler;

  public void onDisable() {
    logger.info("JapanizeChat Disabled");

  }

  public void onEnable() {
    new JapanizeChatPlayerListener(this);

    try {
      loadConfig();
    } catch (IOException excepted) {

    }

    // Register commands
    getCommand("japanize").setExecutor(new JapanizeChatCommand(this));

    // Print that the plugin has been enabled!
    logger.info("JapanizeChat version " + getDescription().getVersion() + " is enabled!");

  }

  public void loadConfig() throws IOException {
    File configFile = new File(getDataFolder(), "config.yml");

    try {
      configFile.createNewFile();
    } catch (IOException exception) {
      throw exception;
    }

    configHandler = new ConfigHandler(configFile);
  }

  public ConfigHandler getConfigHandler() {
    return configHandler;
  }
}