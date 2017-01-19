package info.aki017.JapanizeChat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
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
    } catch (IOException exception) {
      crash(exception);
    }

    // Register commands
    getCommand("japanize").setExecutor(new JapanizeChatCommand(this));

    // Print that the plugin has been enabled!
    logger.info("JapanizeChat version " + getDescription().getVersion() + " is enabled!");

  }

  /**
   * Crash and shutdown this plugin.
   *
   * @param cause Crash reason
   */
  public void crash(Exception cause) {
    logger.severe("Plugin has crashed (Caused by: " + cause.toString() + ")");

    // Print the stacktrace message to memory
    StringWriter messageBuffer = new StringWriter();
    PrintWriter bufferWrapper = new PrintWriter(messageBuffer);
    cause.printStackTrace(bufferWrapper);
    bufferWrapper.close();

    // Log the stacktrace to logger
    String detail = messageBuffer.toString();
    logger.severe("Details: " + detail);

    // Shutdown this plugin
    Bukkit.getPluginManager().disablePlugin(this);
  }

  public void loadConfig() throws IOException {
    File configFile = new File(getDataFolder(), "config.yml");
    try {
      configFile.createNewFile();
    } catch (IOException e) {
      throw new IOException("An exception was thrown while loading configuration file.", e);
    }
    configHandler = new ConfigHandler(configFile);
  }

  public ConfigHandler getConfigHandler() {
    return configHandler;
  }
}