package com.voidcitymc.plugins.Chat;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
    // Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	getServer().getPluginManager().registerEvents(new Chat(), this);
    	
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
    
    
}
